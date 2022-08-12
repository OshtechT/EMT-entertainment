package EMTShop;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;

import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.Address;


import javax.mail.Session;

import java.util.Properties;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class email {
     String name = "test2";
     String email = "test2@gmail.com";
     String phone = "07913606830"; 
    public void orderEmail(Basket basket, String name, String email, String phone) throws Exception{
       Properties properties = new Properties();
       properties.put("mail.smtp.auth", true);
       properties.put("mail.smtp.host", "smtp.gmail.com");
       properties.put("mail.smtp.port", "587");
       properties.put("mail.smtp.starttls.enable", true);
       properties.put("mail.transport.protocol", "smtp");
       properties.put("mail.smtp.ssl.trust", "*");
  
       Session session = Session.getInstance(properties, new Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("emteventswebsite@gmail.com","ydcfimllfyxecdvi");
           }
       });
          Collection<Ticket> items = basket.getItems();
          Collection<Event> Eitems = basket.getEventItems();
          Collection<Integer> Qitems = basket.getQuantity();

          double counter = 0.0;
          Iterator<Ticket> i = items.iterator();
          Iterator<Event> e = Eitems.iterator();
          Iterator<Integer> q = Qitems.iterator();
          Message message = new MimeMessage(session);
          message.setSubject("From" + email);
          MimeMultipart multipart = new MimeMultipart();
          MimeBodyPart field1 = new MimeBodyPart();
          MimeBodyPart field2 = new MimeBodyPart();
          field1.setContent("<h1>Latest Order from website</h1>", "text/html");

          while(i.hasNext()){
             Event event = e.next();
             Ticket ticket = i.next();
             Integer Quantity = q.next();
             String src = event.title + ".jpg";
             Double price = ticket.price * Quantity;
             counter = counter + price;
       
             field2.setContent("<body style= bgcolor:#333333>"+
                                     "<table style= bgcolor:#>"+
                                        "<tr>"+
                                           "<td> EMT Order Summary</td>"+
                                        "</tr>"+
                                        "<tr>"+  
                                      "<td> Customer Name:  " + name +"</td>"+
                                     "<td>   email:  "+ email +"</td>"+
                                     "<td>   mobile:  "+ phone +"</td>"+
                                     "<td>    EMT Presents:  "+ event.title +"</td>"+
                                      "<td>    Ticket type:   "+ ticket.type +"</td>"+
                                      "<td>    Tickets:   "+ Quantity +"</td>"+
                                      "<td>    price:   "+ price +"</td>"+
                                      "<td>    Venue:  "+ event.location +"</td>"+
                                      "</tr></table> </body>", "text/html; charset=utf-8");

             multipart.addBodyPart(field1);
             multipart.addBodyPart(field2);
             Address addressTo = new InternetAddress("to18574@essex.ac.uk");
             message.setContent(multipart);
             message.setRecipient(Message.RecipientType.TO, addressTo);
             Transport.send(message);
             System.out.println("Message has been sent");

          }

     }

     public static void main(String[] args) throws Exception{
         email e = new email();
          Basket basket = new Basket();
          basket.addItem("1");
          basket.addEventItem("1");
          basket.addQuantity(1);

         e.orderEmail(basket,"test","test2@gmail.com", "07913606830");
      }

}
 
