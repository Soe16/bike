package de.hsba.test.bike.bike.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

    @Query(value="SELECT * FROM BESTELLUNG B WHERE B.CURRENT_STATE=0", nativeQuery = true)
    List<Order> findNewOrders();


/*
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
