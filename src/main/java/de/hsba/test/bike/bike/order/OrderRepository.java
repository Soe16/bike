package de.hsba.test.bike.bike.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

    /* versuch1
    @Query("select b from bestellung b where b.deliveree = ''")
    List<Order> findOrdersWithoutKurier();
*/

    /* versuch 2
    static List<Order> findByCurrentState(Integer currentState) {
        return findByCurrentState();
    }
    */

        @Query("select b from bestellung b where b.currentState = 0")
        List<Order> findCurrentState0();

    /* versuch 4
    static List<Order> findByCurrentState(Integer currentState);
    */
}
