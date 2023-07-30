package Entertainment.EMT.EMTShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class TicketConfig {
    @Bean
    CommandLineRunner commandLineRunner2(TicketRepository repository) {
        return args -> {
            Ticket EarlyBird = new Ticket(
                    "Early-Bird",
                    "10pm",
                    "More-Life",
                    4.99,
                    100
            );
            Ticket Standard = new Ticket(
                    "Standard-Entry",
                    "12am",
                    "More-Life",
                    9.99,
                    100
            );
            Ticket Late = new Ticket(
                    "Last-Entry",
                    "2am",
                    "More-Life",
                    14.99,
                    100
            );
            Ticket VIP = new Ticket(
                    "VIP",
                    "2am",
                    "More-Life",
                    24.99,
                    100
            );
            Ticket Door = new Ticket(
                    "Door",
                    "12am",
                    "Burst",
                    11.99,
                    100
            );
            Ticket DoorTicket = new Ticket(
                    "Door",
                    "12am",
                    "Intoxicated",
                    9.99,
                    100
            );
            Ticket Seated = new Ticket(
                    "Seated",
                    "2pm",
                    "Take Me-out",
                    14.99,
                    100
            );
            Ticket VIPe = new Ticket(
                    "VIP",
                    "2am",
                    "Burst",
                    25.99,
                    100
            );
            repository.saveAll(List.of(EarlyBird,Standard,Late,VIP,Door,DoorTicket,Seated,VIPe));
        };
    }
}
