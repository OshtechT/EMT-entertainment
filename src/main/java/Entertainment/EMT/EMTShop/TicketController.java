package Entertainment.EMT.EMTShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;


    @Autowired
    public  TicketController(TicketService  ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getTickets(){
       return ticketService.getTickets();


    }
}
