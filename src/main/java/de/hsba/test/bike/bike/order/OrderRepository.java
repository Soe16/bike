package de.hsba.test.bike.bike.order;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    // für den CourierOrderController

    @Query(value = "SELECT * FROM BESTELLUNG B WHERE B.CURRENT_STATE=0", nativeQuery = true)
    List<Order> findNewOrders();

    //Bestellungen die von einem Kurier angenommen werden. Deliver ID und Status werden neu gesetzt.
    @Modifying
    @Query(value = "UPDATE BESTELLUNG SET CURRENT_STATE= 1, DELIVERER_ID=? WHERE ID= ?", nativeQuery = true)
    int updateOrder(Long currentCourierId, Integer id);


    //für den CourierOrderStatusController

    //alle eigenen Aufträge ansehen, welche nicht abgeschlossen und storniert sind.
    @Query(value = "SELECT * FROM BESTELLUNG B WHERE CURRENT_STATE < 3 AND B.DELIVERER_ID = ?", nativeQuery = true)
    List<Order> findCourierOrders(Long courierId);


    // Update Statement um den nächsten Status zu erreichen.
    @Modifying
    @Query(value = "UPDATE BESTELLUNG SET CURRENT_STATE= CURRENT_STATE + 1 WHERE ID= ?", nativeQuery = true)
    int updateStatus(Long orderId);



    //für CustomerOrderController

    // alle noch nicht abgeschlossenen Aufträge
    @Query(value = "SELECT * FROM BESTELLUNG WHERE OWNER_ID=? AND CURRENT_STATE < 3;", nativeQuery = true)
    List<Order> customerOrders(Long currentUserId);

    // Update Statement um zu stornieren
    @Modifying
    @Query(value = "UPDATE BESTELLUNG SET CURRENT_STATE= 4 WHERE OWNER_ID=? AND ID= ?;", nativeQuery = true)
    int cancelOrder(Long currentUserId, Integer id);

}