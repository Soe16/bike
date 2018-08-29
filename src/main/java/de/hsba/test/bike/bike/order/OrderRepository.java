package de.hsba.test.bike.bike.order;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

    //@PreAuthorize("#username == authentication.principal.username")
    @Query(value="SELECT ID FROM USER U WHERE U.NAME=?", nativeQuery = true)
    Long getCurrentUserId(String currentUserName);

    // für den CourierOrderController

    @Query(value="SELECT * FROM BESTELLUNG B WHERE B.CURRENT_STATE=0", nativeQuery = true)
    List<Order> findNewOrders();


    //Kurier muss noch mitgenommen werden
    @Modifying
    @Query(value="UPDATE BESTELLUNG SET CURRENT_STATE= 1, DELIVERER_ID=1 WHERE ID= ?", nativeQuery = true)
    int updateOrder(Integer id);


    //für CustomerOrderController

    //Owner_ID muss noch als Variable hinterlegt sein!
    @Query(value="SELECT * FROM BESTELLUNG WHERE OWNER_ID=? AND CURRENT_STATE!=4;", nativeQuery = true)
    List<Order> customerOrders(Long currentUserId);

    @Modifying
    @Query(value="DELETE FROM BESTELLUNG WHERE OWNER_ID=? AND ID= ?;", nativeQuery = true)
    int deleteOrder(Integer id);

    /*
RequestContextHolder.currentRequestAttributes().getSessionId();
*/


/*
@Param("id")

    // für eine Beispiel Order benötigt man einen Owner, dass hier war der versuch diesen owener von den usern abzufragen
        @Query("select u from User u where u.name = 'bob'")
        User findUser();

        */

    /* versuch1
    @Query("select b from bestellung b where b.deliveree = ''")
    List<Order> findOrdersWithoutKurier();
*/

    /* versuch 2
    static List<Order> findByCurrentState(Integer currentState) {
        return findByCurrentState();
    }
    */

/*
        @Query("select b from bestellung b where b.currentState = 0")
        List<Order> findCurrentState0();

        */



    /* versuch 4
    static List<Order> findByCurrentState(Integer currentState);
    */

        /*
    Order getOrderByCurrentState(Integer currentState);
*/
/*
    // https://www.youtube.com/watch?v=kttfBthzIPI
    List<Order> listAllNewOrders();



    Order findByCurrentState(Integer currentState);
    */
}
