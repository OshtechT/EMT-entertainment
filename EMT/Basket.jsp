
<%@page language="java" contentType="text/html" %>
<%@ page import="EMTShop.Ticket"%>
<%@ page import="EMTShop.Event"%>
<jsp:useBean id='db'
             scope='session'
             class='EMTShop.HsqlShopDB'/>
<jsp:useBean id='basket'
             scope='session'
             class='EMTShop.Basket'/>
<%@ page import="java.util.Collection, java.util.Iterator"%>

<!DOCTYPE html>


<html>
  <head>
     <meta charset="utf-8">
     <link rel="stylesheet" type="text/css" href="basket.css"/>
    <title>Basket</title>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <SCRIPT LANGUAGE="JavaScript">
       
        function button1()
        {
            document.form1.buttonName.value = "yes";
            form1.submit();
        } 
        function button2()
        {
            document.form2.button2.value = "yes";
            form2.submit();
        } 

    </SCRIPT>
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
       <div class="menu-button">
       <div class="menu-button_burger"></div>
       <script src="EMT.js"></script>
       <div class="menu">
         <div>
        <div>
          <ul>
           <li><a  href="index.jsp">HOME</a></li>
            <li><a  href="eventstickets.html ">EVENTS & TICKETS</a>
               <ul>
                 <li><a  href="nightlife.html">NIGHTLIFE & CONCERTS</a></li>
                 <li><a  href="#n">SHOWS & SEATED EVENTS</a></li>
                 <li><a  href="#n">SPORTS</a></li>
               </ul>
           </li>
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
     <li><a  href="EMT.html">HOME</a></li>
     <li><a  href="eventstickets.html">EVENTS & TICKETS</a>
       <ul>
         <li><a  href="nightlife.html">NIGHTLIFE & CONCERTS</a></li>
         <li><a  href="seatedevents.html">SHOWS & SEATED EVENTS</a></li>
         <li><a  href="sports.html">SPORTS</a></li>
       </ul>
     </li>
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
     <h1> Basket</h1>
      <p><br><br></p>
    <div class="tarea">
     <table>
       <tr>
         <th>Flyer</th>
         <th>Event Name</th>
         <th>Quantity</th>
         <th>Ticket</th>
         <th>Venue</th>
         <th>Price</th>
       </tr>
     <%  
     if(request.getParameter("buttonName") != null) {
               basket.clearBasket();
        }
/*      Collection<Integer> Q = basket.getQuantity(); */
      Collection<Ticket> items = basket.getItems();
      Collection<Event> Eitems = basket.getEventItems();
      Collection<Integer> Qitems = basket.getQuantity();
      
      Iterator<Ticket> i = items.iterator();
      Iterator<Event> e = Eitems.iterator();
      Iterator<Integer> q = Qitems.iterator();
      String ticktype = request.getParameter("time");
      
      double counter = 0.0;
     while(i.hasNext()){
      Event event = e.next();
      Ticket ticket = i.next();
      Integer Quantity = q.next();
      String src = event.title + ".jpg";
      Double price = ticket.price * Quantity;
      counter = counter + price;
%>
     <tr>
     <td> <img class="flyer" src="<%= src%>" alt= "flyer"></td>
     <td>EMT Presents:<%= event.title%> </td>
     <td>X <%= Quantity%></td>
     <td><%= ticket.type%> entry</td>
     <td><%= event.location%></td>
     <td> £<%= price%></td>
     </tr>        
<%
    }
%>
    </table>
     </div>
     <div class="checkout">
     <pre><br><br>Total Price:                                                        <%= basket.getTotalString() %></pre>
       <FORM NAME="form1" METHOD="POST">
        <INPUT TYPE="HIDDEN" NAME="buttonName">
        <INPUT TYPE="BUTTON" VALUE="Clear the basket" ONCLICK="button1()">
    </FORM>
<% 
    if(counter > 0.0){
%>
     <a href="details.jsp">
     <div class="checkbutton">
         <pre>Go to checkout</pre>
    </div>
    </a>
<%
   }
%>
    </div>
   </body>
 </head>
</html>
