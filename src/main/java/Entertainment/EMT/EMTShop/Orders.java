package Entertainment.EMT.EMTShop;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table
public class Orders {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long orderid;

    public String barcode;
    public String event;
    public String ticket;
    public Integer quantity;
    @NotEmpty(message = "Please enter your First Name")
    public String Fname;
    @NotEmpty(message = "Please enter your Surname")
    public String Lname;
    @Email
    public String email;
    @NotNull
    @Size(min = 11,  message = "Please enter a valid UK registered phone number")
    public String mobile;

    public boolean scanned;

    public Orders(Long orderid, String barcode,String event,String ticket,Integer quantity, String Fname, String Lname, String email, String mobile,Boolean scanned){
        this.orderid = orderid;
        this.barcode = barcode;
        this.event = event;
        this.ticket = ticket;
        this.quantity = quantity;
        this.Fname = Fname;
        this.Lname = Lname;
        this.email = email;
        this.mobile = mobile;
        this.scanned = scanned;
    }
    public Orders(String barcode,String event,String ticket,Integer quantity, String Fname, String Lname, String email, String mobile, Boolean scanned){
        this.barcode = barcode;
        this.event = event;
        this.ticket = ticket;
        this.quantity = quantity;
        this.Fname = Fname;
        this.Lname = Lname;
        this.email = email;
        this.mobile = mobile;
        this.scanned = scanned;
    }

    public Orders( String Fname, String Lname, String email, String mobile){
        this.Fname = Fname;
        this.Lname = Lname;
        this.email = email;
        this.mobile = mobile;

    }


    public Orders() {

    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isScanned() {
        return scanned;
    }

    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }
}
