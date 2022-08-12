package EMTShop;


public class Ticket {
    public String ticketid;
    public String type;
    public String entry;
    public String event;
    public double price;
    public Ticket(String ticketid,String type,String entry,String event, double price){
        this.ticketid = ticketid;
	this.type = type;
        this.entry = entry;
        this.event = event;
        this.price = price;
    }

    public String toString() {
        return type + "\t " + price;
    }

}
