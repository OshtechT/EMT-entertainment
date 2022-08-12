<%@page language="java" contentType="text/html" %>
<%@ page import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ page import = "javax.mail.internet.*,javax.activation.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html>
<%
   String result;
   
   // Recipient's email ID needs to be mentioned.
   String to = "entertainmentemt@gmail.com";

   // Sender's email ID needs to be mentioned
   String from = "oshtintech@gmail.com";

   // Assuming you are sending email from localhost
   String host = "localhost";

   // Get system properties object
   Properties properties = System.getProperties();

   // Setup mail server
   properties.setProperty("mail.smtp.host", host);
   props.setProperty(“mail.user”, “oshtintech@gmail.com”);
   props.setProperty(“mail.password”, “ComputerScience2021”);

   // Get the default Session object.
   Session mailSession = Session.getDefaultInstance(properties);

   try {
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(mailSession);
      
      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));
      
      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));
      // Set Subject: header field
      message.setSubject("VIP Package");
      
      // Now set the actual message
      message.setText("This person wants to know something about the package");
      
      // Send message
      Transport.send(message);
      result = "Sent message successfully....";
   } catch (MessagingException mex) {
      mex.printStackTrace();
      result = "Error: unable to send message....";
   }
%>


<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <link rel="stylesheet" type="text/css" href="details.css"/>
   <title>EMT Entertainment</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
  <div class="section-1">
    <a href="index.jsp">
       <img class="Logo" src="EMTLogo.png" alt="EMT Logo">
     </a>
     <a href="https://instagram.com/emt_entertainment?utm_medium=copy_link">
        <img class="Insta" src="instagram.jpeg" alt="Instagram Logo">
     </a>
     <a href="https://www.youtube.com/channel/UCbGqh9UeYydlgRUklZtjqoQ">
         <img class="Youtube" src="youtube.jpeg" alt="Youtube Logo">
     </a>
      <a href="Basket.jsp">
         <img class="Basket" src="basket.png" alt="Basket Logo">
     </a>

  </div>
    <div class="menu-button">
       <div class="menu-button_burger"></div>
       <script src="EMT.js"></script>
       <div class="menu">
         <div>
        <div>
          <ul>
           <li><a  href="index.jsp">HOME</a></li>
       <!--    <button onclick="myFunction()" class="btn"> EVENTS & TICKETS</button>  -->
            <li><a  href="eventstickets.html ">EVENTS & TICKETS</a>
               <ul>
                 <li><a  href="nightlife.html">NIGHTLIFE & CONCERTS</a></li>
                 <li><a  href="#n">SHOWS & SEATED EVENTS</a></li>
                 <li><a  href="#n">SPORTS</a></li>
               </ul>
           </li>
           <li><a  href="#n">FASHION & LIFESTYLE</a></li>
           <li><a  href="musicfilm.html">MUSIC & FILM</a></li>
           <li><a href="#Videos">PRIVATE BOOKINGS</a>
           <ul>
           <li><a  href="staycation.html">STAYCATIONS</a></li>
           <li><a  href="#n">HOLIDAYS</a></li>
           <li><a  href="#n">BIRTHDAYS</a></li>
           <li><a  href="#n">CORPRATE EVENTS</a></li>
          </ul>
        </li>
     <li><a href="#contact">ABOUT US</a></li>
     </ul>
     </div>
     </div>
      </div>
    </div>
   </div>
   </div>

  <div class="topnav">
    <ul>
     <li><a  href="index.jsp">HOME</a></li>
     <li><a  href="eventstickets.html">EVENTS & TICKETS</a>
       <ul>
         <li><a  href="nightlife.html">NIGHTLIFE & CONCERTS</a></li>
         <li><a  href="seatedevents.html">SHOWS & SEATED EVENTS</a></li>
         <li><a  href="sports.html">SPORTS</a></li>
       </ul>
     </li>
     <li><a  href="#n">FASHION & LIFESTYLE</a></li>
     <li><a  href="musicfilm.html">MUSIC & FILM</a></li>
     <li><a href="#Videos">PRIVATE BOOKINGS</a>
       <ul>
         <li><a  href="staycation.html">STAYCATIONS</a></li>
         <li><a  href="#n">HOLIDAYS</a></li>
         <li><a  href="#n">BIRTHDAYS</a></li>
         <li><a  href="#n">CORPRATE EVENTS</a></li>
       </ul>
      </li>
     <li><a href="#contact">ABOUT US</a></li>
     </ul>
  </div>
  <div class="outside">
     <div class= "blog">
     <div class= "form">
        <p align = "center">
         <% 
            out.println("Result: " + result + "\n");
         %>
      </p>
     </div>
     </div>
  </div>
  
