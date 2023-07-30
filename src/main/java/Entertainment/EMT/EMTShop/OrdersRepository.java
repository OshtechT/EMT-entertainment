package Entertainment.EMT.EMTShop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository <Orders, Long>{
    @Query("SELECT b FROM Orders b WHERE b.barcode = ?1")
    Optional<Orders> getOrderByBarcode(String barcode);


}
