package Entertainment.EMT.EMTShop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t WHERE t.type = ?1")
    Optional<Ticket> getTicketByType(String type);

    @Query("SELECT t FROM Ticket t WHERE t.type = ?1 AND t.event = ?2")
    Optional<Ticket> getTicketByTypeAndEvent(String type, String event);
}
