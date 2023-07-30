package Entertainment.EMT.EMTShop;
import jakarta.persistence.criteria.Order;
import org.aspectj.weaver.ast.Or;

import java.sql.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
public class HsqlShopDB {
    Connection con;
    static int nOrders = 0;
    static HsqlShopDB singleton;
    static String dbFile = "/h";
    public static void main(String[] args) throws Exception {
        // simple method to test that ShopDB works
        System.out.println("Got this far...");
        HsqlShopDB db = new HsqlShopDB();
        System.out.println("created shop db");
    }
    public HsqlShopDB() throws SQLException {


        try {

//            Class.forName("org.postgresql.jdbcDriver");

            // connect to the database.   This will load the db files and start the
            // database if it is not alread running.
            con = DriverManager.getConnection("jdbc:postgresql:emtdb","postgres","password");
            System.out.println("created con");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }


    }
    public ResultSet getOrders() {
        try {
            // this is dubious practice - it leaves
            // the result set open after the method has finished executing
            // could you improve on this?
            Statement s = con.createStatement();
            System.out.println("Created statement");
            ResultSet rs = s.executeQuery("Select * from Orders");
            System.out.println("Returning result set...");

            s.close();
            return rs;
        }
        catch (Exception e) {
            System.out.println("Exception in getTickets(): " + e);
            return null;
        }
    }
    public Collection<Orders> getOrderCollection(String query) {
        LinkedList<Orders> list = new LinkedList<Orders>();
        try {
            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Orders order = new Orders(
                        rs.getString("barcode"),
                        rs.getString("event"),
                        rs.getString("ticket"),
                        rs.getInt("quantity"),
                        rs.getString("Fname"),
                        rs.getString("Lname"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getBoolean("scanned")                );
                list.add(order);
            }
            return list;
        }
        catch (Exception e) {
            System.out.println("Exception in getTicket(): " + e);
            return null;
        }
    }



//    public Collection<Ticket> getAllTickets() {
//        return getTicketCollection("Select * from TicketTable2");
//    }
//    public Collection<Ticket> getAllTicketsEvents(String eventid) {
//        String query = "Select * from TicketTable2 where event = '" + eventid + "'";
//        return getTicketCollection(query);
//    }



}
