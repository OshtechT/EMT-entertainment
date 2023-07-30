package Entertainment.EMT.EMTShop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class Item {
    public String event;
    public String ticket;
    public Integer quantity;
    public Double ticketprice ;

    public Item(String event, String ticket, Integer quantity, Double ticketprice){
        this.event = event;
        this.ticket = ticket;
        this.quantity = quantity;
        this.ticketprice = ticketprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Double getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "event='" + event + '\'' +
                ", ticket='" + ticket + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
