package Entertainment.EMT.EMTShop;


import jakarta.persistence.Entity;
import jakarta.persistence.*;


@Entity
@Table
public class Event {
    @Id
    @SequenceGenerator(
            name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )

    private Long eventid;
    public String title;
    public String location;
    public String street;
    public String postcode;
    public String date;

    public Event(Long eventid ,String title,String location,String street,String postcode,String date){
        this.eventid = eventid;
        this.title = title;
        this.location = location;
        this.street = street;
        this.postcode = postcode;
        this.date = date;

    }


    public Event(String title, String location, String street, String postcode, String date){
        this.title = title;
        this.location = location;
        this.street = street;
        this.postcode = postcode;
        this.date = date;
    }

    public Event() {

    }


    public String toString() {
        return title + "\t " + location;
    }

    public Long getID() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

