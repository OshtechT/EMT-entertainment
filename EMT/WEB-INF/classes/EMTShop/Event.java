package EMTShop;


public class Event {
    public String eventid;
    public String title;
    public String location;
    public String street;
    public String postcode;
    public String date;
    public Event(String eventid,String title,String location,String street,String postcode,String date){
        this.eventid = eventid;
        this.title = title;
        this.location = location;
        this.street = street;
        this.postcode = postcode;
        this.date = date;

    }

    public String toString() {
        return title + "\t " + location;
    }

}

