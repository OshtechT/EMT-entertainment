package EMTShop;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class Basket {
    Collection<Integer> Quantities;
    Collection<Event> EventsItems;
    Collection<Ticket> items;
    HsqlShopDB db;

    public static void main(String[] args) {
        Basket b = new Basket();
        b.addItem("1");
        b.addEventItem("1");
        System.out.println(b.getItems()); 
        System.out.println(b.getEventItems()); 
        System.out.println( b.getTotalString() );
        b.clearBasket();
        System.out.println( b.getTotalString() );
        // check that adding a null String causes no problems
        String ticketid = null;
        b.addItem( ticketid );
        System.out.println( b.getTotalString() );
    }

      
    public Basket() {
        db = HsqlShopDB.getSingleton();
        items = new ArrayList<Ticket>();
        EventsItems = new ArrayList<Event>();
        Quantities = new ArrayList<Integer>();
    }

    /**
     *
     * @return Collection of Product items that are stored in the basket
     *
     * Each item is a product object - need to be clear about that...
     *
     * When we come to list the Basket contents, it will be much more
     * convenient to have all the product details as items in this way
     * in order to calculate that product totals etc.
     *
     */
     
    public Collection<Ticket> getItems() {
        return items;
    }
    
   public Collection<Event> getEventItems() {
        return EventsItems;
    }
     public Collection<Integer> getQuantity() {
        return Quantities;
    }


    /**
     * empty the basket - the basket should contain no items after calling this method
     */
    public void clearBasket() {
        items.clear();
        EventsItems.clear();
        Quantities.clear();
    }

    /**
     *
     *  Adds an item specified by its product code to the shopping basket
     *
     * @param pid - the product code
     */
    public void addItem(String ticketid) {

        // need to look the product name up in the
        // database to allow this kind of item adding...

        addItem( db.getTicket( ticketid ) );

    }
    public void addEventItem(String eventid) {

        // need to look the product name up in the
        // database to allow this kind of item adding...

        addEventItem( db.getEvent( eventid ) );

    }
    public void remove(Iterator i){
    items.remove(i);
    }
    public void addItem(Ticket t) {
        // ensure that we don't add any nulls to the item list
        if (t != null ) {
            items.add( t );
        }
    }
     public void addEventItem(Event e) {
        // ensure that we don't add any nulls to the item list
        if (e != null ) {
            EventsItems.add( e );
        }
    }
     public void addQuantity(Integer i) {
        // ensure that we don't add any nulls to the item list
        if (i != null ) {
            Quantities.add( i );
        }
    }


    /**
     *
     * @return the total value of items in the basket
     */
    public double getTotal() {
        double total = 0.0;
        // iterate over the set of products...
      Iterator<Ticket> i = items.iterator();
      Iterator<Event> e = EventsItems.iterator();
      Iterator<Integer> q = Quantities.iterator();
     while(i.hasNext()){
      Event event = e.next();
      Ticket ticket = i.next();
      Integer Quantity = q.next();
      Double price = ticket.price * Quantity;
      total = total + price;
      }
        // return the total
        return total;
    }

    /**
     *
     * @return the total value of items in the basket as
     * a String with two decimal places - hence directly
     * suitable for inclusion as a total in a web page
     */
    public String getTotalString() {
        double total = getTotal();
        int pounds = (int) total;
        int pence = ( (int) (total * 100) ) % 100;

        return "£" + pounds + "." + pence;
    }


}
