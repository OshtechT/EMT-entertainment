package Entertainment.EMT.EMTShop;

import com.itextpdf.layout.element.Image;
import jakarta.mail.Multipart;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.apache.tomcat.util.http.fileupload.UploadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class EventController {
    private final EmailService emailService;
    private final EventService eventservice;
    private final TicketService ticketService;
    private final OrderService orderService;

    private final BasketService basketService;


    @Autowired
    public  EventController(EventService eventservice, TicketService ticketService, OrderService orderService, EmailService emailService, BasketService basketService){
        this.eventservice = eventservice;
        this.ticketService = ticketService;
        this.orderService = orderService;
        this.emailService = emailService;
        this.basketService = basketService;
    }


    @GetMapping("/events")
    public String listOfEvents(Model model){
        Item item = new Item();
        List<Event> eventList = eventservice.getEvents();
        List<Ticket> ticketList = ticketService.getTickets();
        model.addAttribute("events", eventList);
        model.addAttribute("tickets", ticketList);
        model.addAttribute("item", item);
        return "events-list";
    }


    @GetMapping
    public List<Event> getEvents(){
        return eventservice.getEvents();
    }

    @PostMapping
    public void addEvent(@RequestBody Event event) throws IllegalAccessException {
        eventservice.addEvent(event);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEvent(@PathVariable("id") Long id){
        eventservice.deleteEvent(id);
    }
    @PutMapping(path = "{id}")
    public void updateEvent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String street,
            @RequestParam(required = false) String postcode,
            @RequestParam(required = false) String date) {
        eventservice.updateEvent(id,title,location,street,postcode,date);
    }

    @PostMapping("/basket")
    public String submitForm(HttpSession session , @ModelAttribute("item") Item item){
        String sessionId = session.getId();
        System.out.println(sessionId);
        List<Item> ItemList = new ArrayList<Item>();
        ItemList.add(item);
        basketService.addToBasket(sessionId,ItemList);
        System.out.println(item);
        return "redirect:/basket";

    }
    @GetMapping("/basket")
    public String listOfItems(HttpSession session, Model model) {
        Orders orders = new Orders();
        String sessionId = session.getId();
        List<Item> Items = basketService.getBasket(sessionId);
        List<Event> eventList = eventservice.getEvents();
        List<Ticket> ticketList = ticketService.getTickets();
        Integer i;
        Double totalPrice =0.0;
        for( i=0; i < Items.size(); i++){
            for(int j=0;j < ticketList.size(); j++) {
                if (Items.get(i).ticket.equals(ticketList.get(j).type)) {
                    totalPrice = totalPrice + (ticketList.get(j).price * Items.get(i).quantity);
                    System.out.println(totalPrice);
                }
            }
        }
        model.addAttribute("events", eventList);
        model.addAttribute("tickets", ticketList);
        model.addAttribute("Items", Items);
        model.addAttribute("Tprice", totalPrice);
        model.addAttribute("orders", orders);
        return "shopping-basket";
    }

    @GetMapping("/clear")
    public String clearBasket(HttpSession session, Model model) {
        List<Item> Items = basketService.getBasket(session.getId());
        List<Event> eventList = eventservice.getEvents();
        List<Ticket> ticketList = ticketService.getTickets();
        Integer i;
        Double totalPrice =0.0;
        for( i=0; i < Items.size(); i++){
            for(int j=0;j < ticketList.size(); j++) {
                if (Items.get(i).ticket.equals(ticketList.get(j).type)) {
                    totalPrice = totalPrice + (ticketList.get(j).price * Items.get(i).quantity);
                    System.out.println(totalPrice);
                }
            }
        }
        basketService.clearBasket(session.getId());
        model.addAttribute("events", eventList);
        model.addAttribute("tickets", ticketList);
        model.addAttribute("Items", Items);
        model.addAttribute("Tprice", totalPrice);

        return "redirect:/basket";
    }
    @PostMapping("/details")
    public String submitDetails(HttpSession session, @Valid Orders orders, BindingResult result, Model model) throws Exception {
        if(result.hasErrors()){
            List<Item> Items = basketService.getBasket(session.getId());
            List<Event> eventList = eventservice.getEvents();
            List<Ticket> ticketList = ticketService.getTickets();
            Integer i;
            Double totalPrice =0.0;
            System.out.println(Items.size());
            for( i=0; i < Items.size(); i++){
                for(int j=0;j < ticketList.size(); j++) {
                    if (Items.get(i).ticket.equals(ticketList.get(j).type)) {
                        totalPrice = totalPrice + (ticketList.get(j).price * Items.get(i).quantity);
                        System.out.println(totalPrice);
                    }
                }
            }
            model.addAttribute("events", eventList);
            model.addAttribute("tickets", ticketList);
            model.addAttribute("Items", Items);
            model.addAttribute("Tprice", totalPrice);
            model.addAttribute("orders", orders);

            return "details";
        }
        Iterator<Item> i = basketService.getBasket(session.getId()).iterator();
        while(i.hasNext()){
            Item item = i.next();
            Random r = new Random();
            int x = r.nextInt(999999999);
            String barcode = String.valueOf(x);
            Orders ordersNew = new Orders(barcode,item.event,item.ticket, item.quantity,orders.Fname,orders.Lname,orders.email,orders.mobile,false);
            OrderService.addOrders(ordersNew);
        }
        basketService.clearBasket(session.getId());
        return "redirect:/thank-you";

    }


    @GetMapping("/details")
    public String getDetails(HttpSession session, Model model) {
        Orders orders = new Orders();
        List<Item> Items = basketService.getBasket(session.getId());
        List<Event> eventList = eventservice.getEvents();
        List<Ticket> ticketList = ticketService.getTickets();
        Integer i;
        Double totalPrice =0.0;
        System.out.println(Items.size());
        for( i=0; i < Items.size(); i++){
            for(int j=0;j < ticketList.size(); j++) {
                if (Items.get(i).ticket.equals(ticketList.get(j).type)) {
                    totalPrice = totalPrice + (ticketList.get(j).price * Items.get(i).quantity);
                    System.out.println(totalPrice);
                }
            }
        }
        model.addAttribute("events", eventList);
        model.addAttribute("tickets", ticketList);
        model.addAttribute("Items", Items);
        model.addAttribute("Tprice", totalPrice);
        model.addAttribute("orders", orders);

        return "details";
    }
    @GetMapping("/thank-you")
    public String addOrderSuccess(HttpSession session, Model model) {
        Orders orders = new Orders();
        List<Item> Items = basketService.getBasket(session.getId());
        List<Event> eventList = eventservice.getEvents();
        List<Ticket> ticketList = ticketService.getTickets();
        Integer i;
        Double totalPrice =0.0;
        for( i=0; i < Items.size(); i++){
            for(int j=0;j < ticketList.size(); j++) {
                if (Items.get(i).ticket.equals(ticketList.get(j).type)) {
                    totalPrice = totalPrice + (ticketList.get(j).price * Items.get(i).quantity);
                    System.out.println(totalPrice);
                }
            }
        }
        model.addAttribute("events", eventList);
        model.addAttribute("tickets", ticketList);
        model.addAttribute("Items", Items);
        model.addAttribute("Tprice", totalPrice);
        model.addAttribute("orders", orders);

        return "thank-you";
    }
    @GetMapping("/contact-us")
    public String pBooking(Model model) {
        PBForm form = new PBForm();
        model.addAttribute("form", form);
        return "contact-us";
    }
    @PostMapping("/contact-us")
    public String PBEmail(@ModelAttribute("form") PBForm form) throws Exception {
        emailService.PBEmail(form);
        return "redirect::contact-us";
    }
    @GetMapping("/admin")
    public String manageEvents(Model model) {
        Ticket t = new Ticket();
        Event e = new Event();
        Picture p = new Picture();
        List<Event> eventList = eventservice.getEvents();
        List<Ticket> ticketList = ticketService.getTickets();
        model.addAttribute("events", eventList);
        model.addAttribute("tickets", ticketList);
        model.addAttribute("tick", t);
        model.addAttribute("ev", e);
        model.addAttribute("pictur", p);
        return "event-manager";
    }

    @PostMapping("/deleteEvent")
    public String deleteEvent(@ModelAttribute("ev") Event event){
        System.out.println(event);
        eventservice.deleteEventByEvent(event);
        return "redirect:admin";

    }

    @PostMapping("/createEvent")
    public String createEvent(@ModelAttribute("ev") Event event) throws IllegalAccessException {
        System.out.println(event);
        eventservice.addEvent(event);
        return "redirect:admin";

    }
    @PostMapping("/editTicket")
    public String editTicket(@ModelAttribute("tick") Ticket ticket) throws IllegalAccessException {
        System.out.println(ticket.price);
        ticketService.updateTicket(ticket);

        return "redirect:admin";
    }
    @PostMapping("/deleteTicket")
    public String deleteTicket(@ModelAttribute("tick") Ticket ticket) throws IllegalAccessException {
        ticketService.deleteTicket(ticket);
        return "redirect:admin";

    }

    @PostMapping("/createTicket")
    public String createTicket(@ModelAttribute("tick") Ticket ticket) throws IllegalAccessException {
        if (ticket.price == (int)ticket.price) {
            ticketService.addTicket(ticket);
        }
        return "redirect:admin";
    }
    @PostMapping("/changePicture")
    public String changePicture(@RequestParam("event") String title, @RequestParam("pic")MultipartFile multipartFile) throws IOException {
        String fileName = "src/main/resources/static/images/"+title + ".jpg";
        File newImage = new File(fileName);
        newImage.createNewFile();
        FileOutputStream fos = new FileOutputStream(newImage);
        fos.write(multipartFile.getBytes());
        fos.close();
        System.out.println("works so far");
        return "redirect:admin";
    }
    @GetMapping("/about-us")
    public String aboutUs(Model model) {
        return "about-us";
    }

}
