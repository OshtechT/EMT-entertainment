package Entertainment.EMT.EMTShop;


import jakarta.persistence.*;
import org.opencv.photo.AlignMTB;

@Entity
@Table
public class Ticket {
    @Id
    @SequenceGenerator(
            name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_sequence"
    )
    private Long ticketid;
    public String type;
    public String entry;
    public String event;
    public double price;
    public Integer lim;
    public Ticket(Long ticketid,String type,String entry,String event, double price,Integer lim){
        this.ticketid = ticketid;
	    this.type = type;
        this.entry = entry;
        this.event = event;
        this.price = price;
        this.lim = lim;
    }
    public Ticket(String type,String entry,String event, double price){
        this.type = type;
        this.entry = entry;
        this.event = event;
        this.price = price;
    }
    public Ticket(String type,String entry,String event, double price, Integer lim){
        this.type = type;
        this.entry = entry;
        this.event = event;
        this.price = price;
        this.lim = lim;
    }
    public Ticket() {

    }

    public long getTicketid() {
        return ticketid;
    }

    public void setTicketid(long ticketid) {
        this.ticketid = ticketid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return type + "\t " + price;
    }

    public Integer getLimit() {
        return lim;
    }

    public void setLimit(Integer lim) {
        this.lim = lim;
    }
}
