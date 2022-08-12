<%@page language="java" contentType="text/html" %>
<%@ page import="EMTShop.Ticket"%>
<%@ page import="EMTShop.Event"%>
<%@ page import="EMTShop.Basket"%>
<%@ page import="java.util.Collection, java.util.Iterator"%>
<jsp:useBean id='db'
             scope='session'
             class='EMTShop.HsqlShopDB'/>
<jsp:useBean id='basket'
             scope='session'
             class='EMTShop.Basket'/>



<jsp:setProperty name='db' property='*' />

<html lang="en">
<head>
   <meta charset="utf-8">
   <link rel="stylesheet" type="text/css" href="flyer.css"/>
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
     <h1>EMT Presents: More Life the Silk Road shutdown:</h1>
     <img class="flyer"src="More-Life.jpg" alt= "flyer">
     <div class="info">
     <h2> Event Date: 21st November<br>
          Time: 10:00PM-3:00AM<br>
          Last Entry: 12:00AM<br>
          More Info:</h2>
      <p>Coming to you with a DJ Line up and Vibes like Never before<br>
           <br>
           <br>
           Sounds on the night brought to you by: DJ Suukz, DJ Kwarmz Original, DJ Larni and  DJ Dynamic  so make sure to bring your dancing shoes beause these tunes will do more than make you bop your head.<br>
           <br>
           Genre's on the night: R&B, Afrobeat, Hip Hop, UK Drill, Bashment and much, much more!!<br>
           <br>
           THIS EVENT WILL SELL OUT!! So be sure to purchase your tickets ASAP!!</p>
     </div>
     <div class="tickets">
        <p>£5  Early-Bird(enter before 10:00pm to be valid)
        <br>
        <br>
        £10 Standard Entry(enter before 12:00pm to be valid)
        <br>
        <br>
        £15 Last Entry(enter before 12:00pm to be valid)
        <br>
        <br>
        £30 VIP(enter before 12:00pm to be valid)</p>
     <form class="form" method="POST" action="morelife.jsp">
        <label for="DDList">Ticket:</label>

       <select class"DDList "size="1" id="DDList" name="time">
       <option value="1"  selected="">Early-Bird</option>
       <option value="2">Standard-Entry</option>
       <option value="3">Late-Entry</option>
       <option value="4">VIP</option>
     </select>
       <label for="DDList2">Quantity:</label> 
       <select class="DDList2" size="1" id="DDList2" name="amount">
       <option selected="">1</option>
       <option>2</option>
       <option>3</option>
     </select> <input type="submit" value="add to basket" name="VIP1"> 
    </form>
    <div class="fixr">
        <script src="https://web-cdn.fixr.co/scripts/fixr-checkout-widget.v1.min.js"></script>
    </div>
    </div>
     </div>
  </div>
<% 
   /* Integer q = request.getParameter("amount"); */
    String ticktype = request.getParameter("time");
    Ticket ticket = db.getTicket(ticktype);
    Event event = db.getEvent("1");
     out.println("ticketid = " + ticktype);
    if (ticket == null) {
        // do something sensible!!!
        out.println( "ticket not here fam" );
    }
    else {
             try
        {
          Integer q = Integer.parseInt(request.getParameter("amount"));
           basket.addQuantity(q);

        }
        catch (NumberFormatException nfe){
             System.out.println("NumberFormatException: " + nfe.getMessage());
        }

           basket.addItem(ticktype);
           basket.addEventItem("1");

    }
     Double order = basket.getTotal();
     if( order > 0.0){
%>
 <a href="Basket.jsp">
 <div class="notification">
    <pre> Your Order: <%= basket.getTotalString() %> </pre>
     <p> Go to your shopping basket</p>

 </div>
 </a>
 <div class="circle">
  <pre><%= basket.getItems().size() %>
 <div>
<%
  }
%>
 </body>
</html>
