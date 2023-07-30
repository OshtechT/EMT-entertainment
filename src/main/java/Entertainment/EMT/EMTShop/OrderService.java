package Entertainment.EMT.EMTShop;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private static OrdersRepository ordersRepository;
    private static EmailService emailService;
    private static TicketService ticketService;
    private static EventService eventService;


    @Autowired
    public OrderService(OrdersRepository ordersRepository, EmailService emailService, EventService eventService, TicketService ticketService) {
        this.ordersRepository = ordersRepository;
        this.emailService = emailService;
        this.eventService = eventService;
        this.ticketService = ticketService;
    }
    public List<Orders> getOrders() {

        return ordersRepository.findAll();
    }
    public static void addOrders(Orders order) throws Exception {
        Optional<Orders> ev = ordersRepository.getOrderByBarcode(order.getBarcode());
        if(ev.isPresent()){
            throw new IllegalAccessException("barcode already exist");
        }
       // createPDF c = new createPDF();
        List<Event> Elist = eventService.getEvents();
        List<Ticket> Tlist = ticketService.getTickets();
        Ticket t = new Ticket();
        Event e = new Event();
        for(int j=0;j < Tlist.size(); j++) {
            if (order.ticket.equals(Tlist.get(j).type)) {
             t = Tlist.get(j);
            }
        }
        for(int j=0;j < Elist.size(); j++) {
            if (order.event.equals(Elist.get(j).title)) {
                e = Elist.get(j);
            }
        }
        createPDF c = new createPDF();

        Integer code = Integer.valueOf(order.barcode);
        String customer = order.Fname + " " + order.Lname;
        c.CreatePDF(order.barcode,code,t,e,customer);
        emailService.orderEmail(order);
        emailService.notifyEmail(order);
        ordersRepository.save(order);
        for(int j=0;j < Tlist.size(); j++) {
            if (order.ticket.equals(Tlist.get(j).type)) {
                Ticket ti = Tlist.get(j);
                ticketService.incrementLimit(ti);
                System.out.println(j+"Ticket limit after:"+ti.lim);
            }
        }

    }
    public String checkOrder(String barcode) throws IllegalAccessException {
        Optional<Orders> order = ordersRepository.getOrderByBarcode(barcode);
        if(order.isPresent()){
            String result = order.get().Fname+"\n"+order.get().ticket+"\n"+order.get().event+"\n"+order.get().email+"\n"+order.get().mobile;
            markIn(barcode);
            return result;
        }else{
            String result = "Barcode is not in the Orders Database";
            return result;
        }

    }
    @Transactional
    public String markIn(String barcode) throws IllegalAccessException {
        Optional<Orders> order = ordersRepository.getOrderByBarcode(barcode);
        Orders o = ordersRepository.getReferenceById(order.get().getOrderid());
        if(order.isPresent()){
            String result = order.get().Fname+"\n"+order.get().ticket+"\n"+order.get().event+"\n"+order.get().email+"\n"+order.get().mobile;
            if(o.scanned == false){
                o.setScanned(true);
             return result;
            }else{
               return "Ticket has already been scanned";

            }
        }else{
            String result = "Barcode is not in the Orders Database";
            return result;
        }
//        if(o.scanned = false){
//            o.setScanned(true);
//            return "Customer has been checked in";
//        }else{
//            String result = "Ticket has already been scanned";
//            return result;
//        }

    }
}
