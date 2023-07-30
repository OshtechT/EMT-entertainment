package Entertainment.EMT.EMTShop;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;

import java.util.List;

@Configuration
public class EventConfig {

    @Bean
    CommandLineRunner commandLineRunner(EventRepository repository){
        return args ->{
            Event MoreLife = new Event(
                    "More-Life",
                    "Silk Road Lounge",
                    "4 Saint Boltolphs Street",
                    "Colchester CO2 7DX",
                    "20th October 2019"

            );
            Event Burst = new Event(
                    "Burst",
                    "Silk Road Lounge",
                    "4 Saint Boltolphs Street",
                    "Colchester CO2 7DX",
                    "20th March 2022"
            );
            Event Intoxicated = new Event(
                    "Intoxicated",
                    "Sangam",
                    "44 Burnt Oak Broadway",
                    "London HA8 0TE",
                    "25th July 2018"
            );
            Event TakeMeOut = new Event(
                    "Take Me-out",
                    "Ivor Crewe Hall",
                    "University of Essex",
                    "Colchester CO4 3SQ",
                    "14 Febuary 2019"
            );

            repository.saveAll(List.of(MoreLife,Burst,Intoxicated,TakeMeOut));


        };
    }
}
