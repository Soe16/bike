package de.hsba.test.bike.bike.order;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceUnitTest {

    @Mock
    private OrderRepository orderRepositoryMock;

    //Service to test
    @InjectMocks
    private OrderService orderService;

    @Test
    public void shouldFindOrdersWithSearch(){
        //given
        long testId = 1;
        //when
        orderService.findOrder(testId);

        //then
        verify(orderRepositoryMock).findById(testId);
        verify(orderRepositoryMock, never()).findAll();

    }

    @Test
    public void shouldFindOrderWithoutSearch(){

        //when
        orderService.findNewOrders();

        //then
        verify(orderRepositoryMock, never()).customerOrders(anyLong());
        verify(orderRepositoryMock, never()).findCourierOrders(anyLong());
        verify(orderRepositoryMock).findNewOrders();

    }



}
