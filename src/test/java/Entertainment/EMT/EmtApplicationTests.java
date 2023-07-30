package Entertainment.EMT;

import Entertainment.EMT.EMTShop.Event;
import Entertainment.EMT.EMTShop.EventRepository;
import Entertainment.EMT.EMTShop.Ticket;
import Entertainment.EMT.EMTShop.TicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmtApplicationTests {

	@Test
	public  void testSetEventTitle() {
		Event e = new Event();
		e.setTitle("More-Life");
		Assertions.assertEquals("More-Life", e.title);
	}

	@Test
	public  void testSetEventLocation() {
		Event e = new Event();
		e.setLocation("Venue");
		Assertions.assertEquals("Venue", e.location);
	}
	@Test
	public  void testSetEventPostcode() {
		Event e = new Event();
		e.setPostcode("CO1 3XU");
		Assertions.assertEquals("CO1 3XU", e.postcode);
	}
	@Test
	public  void testSetEventStreet() {
		Event e = new Event();
		e.setStreet("Goldbeaters Grove");
		Assertions.assertEquals("Goldbeaters Grove", e.street);
	}
	@Test
	public  void testSetEventDate() {
		Event e = new Event();
		e.setDate("20th October 2019");
		Assertions.assertEquals("20th October 2019", e.date);
	}
	@Test
	public  void testSetTicketType() {
		Ticket t = new Ticket();
		t.setType("VIP entry");
		Assertions.assertEquals("VIP entry", t.type);
	}
	@Test
	public  void testSetTicketEntry() {
		Ticket t = new Ticket();
		t.setEntry("12am");
		Assertions.assertEquals("12am", t.entry);
	}
	@Test
	public  void testSetTicketPrice() {
		Ticket t = new Ticket();
		t.setPrice(24.99);
		Assertions.assertEquals(24.99, t.price);
	}
	@Test
	public  void testSetTicketEvent() {
		Ticket t = new Ticket();
		t.setEvent("Burst");
		Assertions.assertEquals("Burst", t.event);
	}
	@Test
	public  void testSetTicketLimit() {
		Ticket t = new Ticket();
		t.setLimit(20);
		Assertions.assertEquals(20, t.lim);
	}
//	@Test
//	public  void testAddTicket(TicketService ticketService) {
//		Ticket Late = new Ticket(
//				"Last-Entry",
//				"2am",
//				"More-Life",
//				14.99,
//				100
//		);
//		ticketService.addTicket(Late);
//		List<Ticket> TicketList = ticketService.getTickets();
//		Assertions.assertEquals(Late, TicketList.get(0));
//	}


}
