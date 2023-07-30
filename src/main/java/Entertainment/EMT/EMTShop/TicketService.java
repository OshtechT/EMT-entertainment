package Entertainment.EMT.EMTShop;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository){

        this.ticketRepository = ticketRepository;
    }
    public Optional<Ticket> getTicket(String type){
        return ticketRepository.getTicketByType(type);
    }
    public List<Ticket> getTickets() {

        return ticketRepository.findAll();
    }
    public void deleteTicket(Ticket ticket){
        Optional<Ticket> t = ticketRepository.getTicketByType(ticket.type);
        if(!t.isPresent()){
            throw new IllegalStateException("ticket "+t.get().type+" does not exist");
        }else {
            ticketRepository.delete(t.get());
        }
    }

    public void addTicket(Ticket ticket){
        Optional<Ticket> t = ticketRepository.getTicketByTypeAndEvent(ticket.type, ticket.event);
        if(t.isPresent()){
            throw new IllegalStateException("ticket "+t.get().type+" does not exist");
        }else {
            ticketRepository.save(ticket);
        }
    }

    @Transactional
    public void updateTicket(Ticket ticket){
        Optional<Ticket> t = ticketRepository.getTicketByTypeAndEvent(ticket.type, ticket.event);
        if(t.isPresent()){
            Ticket newTick = ticketRepository.getReferenceById(t.get().getTicketid());
            newTick.setPrice(ticket.price);
            newTick.setEntry(ticket.entry);
            newTick.setLimit(ticket.lim);
        }else {
            throw new IllegalStateException("Ticket: "+t.get().type+" does not exist");
        }
    }

    @Transactional
    public void incrementLimit(Ticket ticket){
        Optional<Ticket> t = ticketRepository.getTicketByTypeAndEvent(ticket.type, ticket.event);
        if(t.isPresent()){
            Ticket newTick = ticketRepository.getReferenceById(t.get().getTicketid());
            newTick.setLimit(ticket.lim - 1);
        }else {
            throw new IllegalStateException("Ticket: "+t.get().type+" does not exist");
        }
    }

}
