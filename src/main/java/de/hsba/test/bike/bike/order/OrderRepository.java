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

    //alle eigenen Aufträge ansehen
    @Query(value = "SELECT * FROM BESTELLUNG B WHERE B.DELIVERER_ID = ?", nativeQuery = true)
    List<Order> findCourierOrders(Long courierId);


    /* modifizieren um neuen status zu bekommen
    @Modifying
    @Query(value = "UPDATE BESTELLUNG SET CURRENT_STATE= 1, DELIVERER_ID=? WHERE ID= ?", nativeQuery = true)
    int updateOrder(Long currentCourierId, Integer id);
    */



    //für CustomerOrderController

    //Owner_ID muss noch als Variable hinterlegt sein!
    @Query(value = "SELECT * FROM BESTELLUNG WHERE OWNER_ID=? AND CURRENT_STATE!=4;", nativeQuery = true)
    List<Order> customerOrders(Long currentUserId);

    @Modifying
    @Query(value = "DELETE FROM BESTELLUNG WHERE OWNER_ID=? AND ID= ?;", nativeQuery = true)
    int deleteOrder(Long currentUserId, Integer id);

}