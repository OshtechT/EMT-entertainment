package EMTShop;

import java.sql.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;   
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.kernel.pdf.PdfWriter;


public class HsqlShopDB{

    Connection con;
    static int nOrders = 0;
    static HsqlShopDB singleton;
    static String dbFile = "EMTshopDB";

    public static void main(String[] args) throws Exception {
        // simple method to test that ShopDB works
        System.out.println("Got this far...");
        HsqlShopDB db = new HsqlShopDB();
        System.out.println("created shop db");
        db.createTables();
        db.clear();

        db.listTables();
        db.addTickets();
        db.addEvents();
        Basket basket = new Basket();
        System.out.println("created the basket");
        System.out.println("Testing getAllProducts");
        Collection<Ticket> tickets = db.getAllTickets();
        for (Ticket t : tickets) {
            System.out.println(t);
        }
        System.out.println("Testing getTickets(ticketid)");
        Ticket ticket = db.getTicket("1");
        System.out.println(ticket);
       
         Collection<Ticket> Mlifetickets = db.getAllTicketsEvents("1");
        for (Ticket t : Mlifetickets) {
            System.out.println(t);
        }
        System.out.println("Testing getTickets(ticketid)");
        Ticket ticket2 = db.getTicketsEvent("1");
        System.out.println(ticket2);


       System.out.println("Testing getAllEvents");
        Collection<Event> events = db.getAllEvents();
        for (Event e : events) {
            System.out.println(e);
        }
        System.out.println("Testing getEvents(eventid)");

        Event event = db.getEvent("1");
        System.out.println(event);

        System.out.println("Testing order: ");
        basket.addItem(ticket);
        basket.addEventItem(event);
        basket.addQuantity(2);
        System.out.println("added an item");
        String name = "Alex";
        db.order(basket,name,"fiygaoigfay","098765432");
        db.getOrders();
        System.out.println("order done");
        db.shutdown();
    }

    public HsqlShopDB() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");

            // connect to the database.   This will load the db files and start the
            // database if it is not alread running.
            con = DriverManager.getConnection("jdbc:hsqldb:file:" 
                   +  dbFile ,    // filename
                    "sa",                     // username
                    "");                      // password

            System.out.println("created con");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public void listTables() throws Exception {
        DatabaseMetaData dbm = con.getMetaData();
        ResultSet rs = dbm.getTables(null, null, "", new String[]{"TABLE"});
        System.out.println("Tables:");
        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }
    }

    public static HsqlShopDB getSingleton() {
        if (singleton == null) {
            singleton = new HsqlShopDB();
        }
        return singleton;
    }

    public ResultSet getTickets() {
        try {
            Statement s = con.createStatement();
            // this is dubious practice - it leaves
            // the result set open after the method has finished executing
            // could you improve on this?
            System.out.println("Created statement");
            ResultSet rs = s.executeQuery("Select * from TicketTable2");
            System.out.println("Returning result set...");
            s.close();
            return rs;
        }
        catch (Exception e) {
            System.out.println("Exception in getTickets(): " + e);
            return null;
        }
    }

    public Collection<Ticket> getAllTickets() {
        return getTicketCollection("Select * from TicketTable2");
    }
     public Collection<Ticket> getAllTicketsEvents(String eventid) {
        String query = "Select * from TicketTable2 where event = '" + eventid + "'";
        return getTicketCollection(query);
    }


    public Ticket getTicket(String ticketid) {
        try {
            // re-use the getProductCollection method
            // even though we only expect to get a single Product Object
            String query = "Select * from TicketTable2 where ticketID = '" + ticketid + "'";
            Collection c = getTicketCollection(query);
            Iterator i = c.iterator();
            return (Ticket) i.next();
        }
        catch (Exception e) {
            // unable to find the product matching that pid
            return null;
        }
    }
    public Ticket getTicketsEvent(String eventid) {
        try {
            // re-use the getProductCollection method
            // even though we only expect to get a single Product Object
            String query = "Select * from TicketTable2 where event = '" + eventid + "'";
            Collection c = getTicketCollection(query);
            Iterator i = c.iterator();
            return (Ticket) i.next();
        }
        catch (Exception e) {
            // unable to find the product matching that pid
            return null;
        }
    }

    public Collection<Ticket> getTicketCollection(String query) {
        LinkedList<Ticket> list = new LinkedList<Ticket>();
        try {
            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Ticket ticket = new Ticket(
                        rs.getString("ticketid"),
                        rs.getString("type"),
                        rs.getString("entry"),
                        rs.getString("event"),
                        rs.getDouble("price")                );
                list.add(ticket);
            }
            return list;
        }
        catch (Exception e) {
            System.out.println("Exception in getTicket(): " + e);
            return null;
        }
    }
        public ResultSet getEvents() {
        try {
            Statement s = con.createStatement();
            // this is dubious practice - it leaves
            // the result set open after the method has finished executing
            // could you improve on this?
            System.out.println("Created statement");
            ResultSet rs = s.executeQuery("Select * from EventTable3");
            System.out.println("Returning result set...");
            s.close();
            return rs;
        }
        catch (Exception e) {
            System.out.println("Exception in getEvents(): " + e);
            return null;
        }
    }

    public Collection<Event> getAllEvents() {
        return getEventCollection("Select * from EventTable3");
    }

    public Event getEvent(String eventid) {
        try {
            // re-use the getProductCollection method
            // even though we only expect to get a single Product Object
            String query = "Select * from EventTable3 where eventID = '" + eventid + "'";
            Collection c = getEventCollection(query);
            Iterator i = c.iterator();
            return (Event) i.next();
        }
        catch (Exception e) {
            // unable to find the product matching that pid
            return null;
        }
    }

    public Collection<Event> getEventCollection(String query) {
        LinkedList<Event> list = new LinkedList<Event>();
        try {
            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Event event = new Event(
                        rs.getString("eventid"),
                        rs.getString("title"),
                        rs.getString("location"),
                        rs.getString("street"),
                        rs.getString("postcode"),
                        rs.getString("date")                );
                list.add(event);
            }
            return list;
        }
        catch (Exception e) {
            System.out.println("Exception in getEvent(): " + e);
            return null;
        }
    }
     public ResultSet getOrders() {
        try {
            Statement s = con.createStatement();
            // this is dubious practice - it leaves
            // the result set open after the method has finished executing
            // could you improve on this?
            System.out.println("Created statement");
            ResultSet rs = s.executeQuery("Select * from OrderTable2");
            System.out.println("Returning result set...");
             while (rs.next()) {
                         String cust = rs.getString("customer");
                         String OID = rs.getString("OrderID");
                         String Email = rs.getString("email");
                         String mobile = rs.getString("mobile");
                         String thing =  "Customer Name:" + cust + " |orderID:" + OID + " |E-mail Address:" + Email + " |Phone Number:" + mobile ;
                         System.out.println("Customer Name:" + cust + " |orderID:" + OID + " |E-mail Address:" + Email + " |Phone Number:" + mobile );
            }
            s.close();

            return rs;
        }
        catch (Exception e) {
            System.out.println("Exception in getOrders(): " + e);
            return null;
        }
    }

    public void order(Basket basket, String customer, String email, String mobile) {
        try {
            String orderId = System.currentTimeMillis() + ":" + nOrders++;
             Collection<Ticket> items = basket.getItems();
              Collection<Event> Eitems = basket.getEventItems();
             Collection<Integer> Qitems = basket.getQuantity();

             Iterator<Ticket> i = items.iterator();
             Iterator<Event> e = Eitems.iterator();
             Iterator<Integer> q = Qitems.iterator();


            // iterate over the basket of contents ...
             while(i.hasNext()){
                Random random = new Random();
                int QRCode =  random.nextInt(99999999);    
                createPDF c = new createPDF();

                Event event = e.next();
                Ticket t = i.next();
                Integer quantity = q.next();
                // and place the order for each one
                order(con, t, orderId, customer, email, mobile, event, quantity);
                c.CreatePDF(orderId,QRCode,t,event,customer);
            }
        }
        catch (Exception e) {
             System.out.println("This one");
            e.printStackTrace();
        }
    }

    public void addTickets() {
        addTicket(new Ticket("1", "Early-Bird","9:30PM","1", 4.99));
        addTicket(new Ticket("2", "Standard-Entry","11PM","1", 9.99));
        addTicket(new Ticket("3", "Late-Entry","12AM","1", 14.99));
        addTicket(new Ticket("4", "VIP","12AM","1", 24.99));
        addTicket(new Ticket("5", "Early-Bird","9:30PM","2", 4.99));
        addTicket(new Ticket("6", "Standard-Entry","11PM","2", 9.99));
        addTicket(new Ticket("7", "Late-Entry","12AM","2", 14.99));
        addTicket(new Ticket("8", "VIP","12AM","2", 24.99));
         addTicket(new Ticket("9", "Early-Bird","9:30PM","3", 4.99));
        addTicket(new Ticket("10", "Standard-Entry","9:30PM","3", 9.99));
        addTicket(new Ticket("11", "Late-Entry","9:30PM","3", 14.99));
        addTicket(new Ticket("12", "VIP","9:30PM","3", 24.99));
        addTicket(new Ticket("13", "Early-Bird","9:30PM","4", 4.99));
        addTicket(new Ticket("14", "Standard-Entry","11PM","4", 9.99));
        addTicket(new Ticket("15", "Late-Entry","12AM","4", 14.99));
        addTicket(new Ticket("16", "VIP","12PM","4", 24.99));

    }

    public void addTicket(Ticket t) {
        String add = String.format("INSERT INTO TicketTable2 VALUES ('%s', '%s','%s', '%s', '%s')",
                t.ticketid, t.type,t.entry,t.event,t.price);
        System.out.println(add);
        update(add);
    }

    public void addEvents() {
        addEvent(new Event("1", "More-Life","Silk Road Lounge", "4 Saint Boltolphs Street", "Colchester CO2 7DX","20th October 2019"));
        addEvent(new Event("2", "Intoxicated","Sangam", "44 Burnt Oak Broadway", "London HA8 0TE", "25th July 2018"));
        addEvent(new Event("3", "Take Me-out","Ivor Crewe Hall", "University of Essex", "Colchester CO4 3SQ","14 Febuary 2019"));
        addEvent(new Event("4", "Burst","Silk Road Lounge","4 Saint Boltolphs Street","Colchester CO2 7DX","20th March 2022"));
    }

    public void addEvent(Event e) {
        String add = String.format("INSERT INTO EventTable3 VALUES ('%s', '%s','%s', '%s','%s', '%s')",
                e.eventid, e.title,e.location,e.street,e.postcode,e.date);
        System.out.println(add);
        update(add);
    }


    private void order(Connection con, Ticket t, String orderId, String customer, String email, String mobile , Event event, Integer quantity) throws Exception {
        String insert = "INSERT INTO OrderTable2 VALUES ( '";
        insert += t.type + "', '";
        insert += orderId + "', '";
        insert += customer + "', '";
        insert += quantity + "', '";
        insert += t.price + "', '";
        insert += email + "', '";
        insert += mobile + "', '";
        insert += event.title + "')";
        System.out.println("Insert = " + insert);
        Statement stmt = con.createStatement();
        int rows = stmt.executeUpdate(insert);
        stmt.close();
        System.out.println(rows + " rows inserted");
    }
    public void clear(){
        System.out.println("database cleard");
//	update("DROP TABLE TicketTable");
//	update("DROP TABLE EventTable");
//	update("DROP TABLE Orders");
	update("DELETE FROM TicketTable2");
	update("DELETE FROM EventTable3");
	update("DELETE FROM OrderTable2");
    }
    public void createTables() {
        update(
                "CREATE TABLE IF NOT EXISTS TicketTable2 (" +
                        " ticketid VARCHAR(256)," +
			" type VARCHAR(256)," +
			" entry VARCHAR(256)," +
			" event VARCHAR(256)," +
                        " price DOUBLE," +
                        ") "
        );
        System.out.println("TicketTable");
        update(
                "CREATE TABLE IF NOT EXISTS EventTable3 (" +
                        " eventid VARCHAR(256)," +
                        " title VARCHAR(256)," +
                        " location  VARCHAR(256)," +
                        " street  VARCHAR(256)," +
                        " postcode  VARCHAR(256)," +
                        " date  VARCHAR(256)," +
                        ") "
        );
        System.out.println("EventTable");

        update(
                "CREATE TABLE IF NOT EXISTS Orders (" +
                        " ticket VARCHAR(256)," +
                        " OrderID VARCHAR(256)," +
                        " customer  VARCHAR(256)," +
                        " quanitity FLOAT," +
                        " price DOUBLE," +
                        " email  VARCHAR(256)," +
                        " mobile  VARCHAR(11)," +
                        " event  VARCHAR(11)" +
                        ") "
        );
        System.out.println("OrderTable");

    }

    //use for SQL commands CREATE, DROP, INSERT and UPDATE
    // from TestDB in HSQLDB Guide.pdf
    public synchronized void update(String expression) {

        try {
            Statement st = con.createStatement();    // statements

            int i = st.executeUpdate(expression);    // run the query

            if (i == -1) {
                System.out.println("db error : " + expression);
            }

            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }    // void update()

    public void shutdown() throws SQLException {

        Statement st = con.createStatement();

        // db writes out to files and performs clean shuts down
        // otherwise there will be an unclean shutdown
        // when program ends
        st.execute("SHUTDOWN");
        con.close();    // if there are no other open connection
    }

}
