<%@page language="java" contentType="text/html" %>
<%@ page import="EMTShop.Ticket"%>
<%@ page import="EMTShop.Basket"%>
<%@ page import="java.util.Collection, java.util.Iterator"%>
<jsp:useBean id='db'
             scope='session'
             class='EMTShop.HsqlShopDB'/>
<jsp:useBean id='basket'
             scope='session'
             class='EMTShop.Basket'/>



<jsp:setProperty name='db' property='*' />
<html>
  <head>
    <title>Bean test</title>
  </head>
   <body>
<% 
    String ticktype = request.getParameter("time");
    Ticket ticket = db.getTicket(ticktype);
     out.println("ticketid = " + ticktype);
    if (ticket == null) {
        // do something sensible!!!
        out.println( "ticket not here fam" );
    }
    else {
           basket.addItem(ticktype);
        %>
    <h2> <%= ticket.type %> X <%= ticket.price %>  Tickets have been added to basket </h2>
      <p>This is the basket <%= basket.getItems()%><p>
      <%
    }
%>
   <p><a  href="morelife.html">Bask to page</a>
   <a href="Basket.jsp">
         <img class="Basket" src="Basket.png" alt="Basket Logo">
     </a>

   </body>
</html
 
