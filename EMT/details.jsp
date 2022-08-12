<%@page language="java" contentType="text/html" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Properties" %>

<%@ page import="EMTShop.HsqlShopDB "%>
<%@ page import="EMTShop.email "%>
<%@ page import="EMTShop.createPDF "%>

<jsp:useBean id='db'
             scope='session'
             class='EMTShop.HsqlShopDB'/>
<jsp:useBean id='basket'
             scope='session'
             class='EMTShop.Basket'/>
<%@ page import="java.util.Collection, java.util.Iterator"%>


<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <link rel="stylesheet" type="text/css" href="details.css"/>
   <title>EMT Entertainment</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<%
   db = new HsqlShopDB();

%>

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
         <h1>Please confirm your details</h1>
          <form method="POST" action="details.jsp">
          <label for="fname">First name:</label>
          <input type="text" id="fname" name="fname">
          <label for="number">Phone Number:</label>
          <input type="text" id="number" name="number">
          <label for="email">E-Mail Address:</label>
          <input type="text" id="email" name="email">
          <label for="cemail">Confirm E-Mail Address:</label>
          <input type="text" id="cemail" name="cemail">
          <input type="submit" value="proceed to checkout" name="VIP1">

          </form> 
     </div>
     </div>
<%
          String name = request.getParameter("fname");
          String mobile = request.getParameter("number");
          String email = request.getParameter("email");
          String cemail = request.getParameter("cemail");
          if (name!=null){
          db.order(basket, name, email, mobile);
          email e = new email();
          e.orderEmail(basket,name,email, mobile);

           
          
 

          basket.clearBasket();
          }else{
%>

             <p>please type in something<p>

<%
          }
     
          db.shutdown();
          
%>

  </div>
  
