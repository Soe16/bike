package de.hsba.test.bike.bike.order;

import de.hsba.test.bike.bike.user.User;
import de.hsba.test.bike.bike.user.UserAdapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.jaxb.OrderAdapter;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceIntegrationTest {

    @Autowired
    private OrderService serviceToTest;

    @PersistenceContext
    private EntityManager entityManager;

    private User testCustomer = new User("tester", "test","test@mail.de", "Customer");
    private User testDeliverer = new User("john", "test","j@mail.de", "Deliverer");
    private User owner = new User("Owner", "test", "o@mail.de", "Customer");

    @Before
    public void setUp() {
        entityManager.persist(testCustomer);
        SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken(new UserAdapter(testCustomer), null));
        entityManager.persist(testDeliverer);
        SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken(new UserAdapter(testDeliverer), null));
        entityManager.persist(owner);
        SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken(new UserAdapter(owner), null));
    }

    @Test
    public void shouldFindOrder(){
        long idTest;
        idTest = 1;

        //given
        Order order1 = buildOrder(idTest);


        //when
        Collection<Order> orders = serviceToTest.findNewOrders();

        //then
        assertEquals(1, orders.size());

    }

    private Order buildOrder(Long iD){
        Order order = new Order();
        order.setId(iD);
        order.setCurrentState(1);
        order.setCustomer("TestCustomer");
        order.setCustomerStreet("Teststr.");
        order.setCustomerNumber("2");
        order.setCustomerZip("22177");
        order.setDeliveree("TestDeliverer");
        order.setDeliverStreet("Teststr.");
        order.setDeliverNumber("105");
        order.setDeliverZip("22177");
        order.setOwner(owner);

        return serviceToTest.save(order);

    }
}
