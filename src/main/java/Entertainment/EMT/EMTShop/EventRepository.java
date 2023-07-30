package Entertainment.EMT.EMTShop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT s FROM Event s WHERE s.title = ?1")
    Optional<Event> getEventByTitle(String title);

}
