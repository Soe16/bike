package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/orders")
public class CourierOrderController {


    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
        public String listOrders(Model model){

            model.addAttribute("orders", orderRepository.findNewOrders());

            return "orders";
    }

    //https://stackoverflow.com/questions/42945495/getting-the-selected-values-from-a-checkbox-list-to-the-controller-with-spring-b
    @PostMapping
    public String update(@RequestParam("idChecked") List<String> idOrders) {
            if(idOrders != null) {
                for(String idOrdersUp : idOrders){
                    int id = Integer.parseInt(idOrdersUp);
                    orderRepository.updateOrder(id);

                }
            }
        return "index";
    }


    // checkboxes die gecheckt sind, wird in datenbank bestellung geladen, dass 1. currentstatus verändern auf: (1) "The order was accepted by a courier" dementsprechen name des couriers hinterlegen..
    // aufträge verwalten, neue seite für Kurier, same shit mit bestellung abgeholt und bestellung abgeliefert.


}

    /*
    public void setOrderRepository(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
*/
    /*
    @RequestMapping("/orders")


    public String listOrders(Model model){

        model.addAttribute("orders", orderRepository.findNewOrders());

        return "orders";
        */














    /*
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @RequestMapping("/orders")
    public String listOrders(Model model){

        model.addAttribute("orders", orderRepository.listAllNewOrders());

        return "orders";
    }

    */







/* zu Versuch 2 und 4 bei OrderRepository
    //Versuch nur Bestellungen mit currentstate 0 zu filtern, Siehe orderRepository Interface

    public void QueryCurrentState () {
        System.out.println("\n Find current State equals 0");
        OrderRepository.findByCurrentState(0).forEach(System.out::println);
    }
 */

/* Versuch

    public void QueryCurrentState () {
        System.out.println("\n Find current State equals 0");
        OrderRepository.findCurrentState0().forEach(System.out::println);
    }

*/










//Datenbankabfrage hier rein, table muss definiert werden: table ist " bestellung  " : https://jaxenter.de/mysql-und-java-datenabfrage-8123
/*
    public Vector loadCustomers(String table)
    { Statement stmt = null;
        ResultSet result = null;
        try {
            stmt = connection.createStatement();
            result = stmt.executeQuery("SELECT * FROM " + table);
            result.first(); // <- first entry of the result set
// STEP 2: copy the data from the result set into the vector
            Vector customers = new Vector();

            while(! result.isAfterLast()) // as long as valid data is in the result set
            {
                int id = result.getInt("kid");
                String Customer = result.getString("name");
                String CustomerStreet =
                String vorname = result.getString("vname");
                String

                Kunde kunde = new Kunde(id, name, vorname);
                customers.add(kunde);
                result.next(); // go to next line in the customer table
            }

// STEP 3: return the vector containing the customer data
            return customers;
        } catch (Exception ex) {
            System.out.println("Error during access + " + table + "n" + ex.getMessage());
            return null;
        }
    }

/* SELECT * FROM tablename t WHERE t.status = "NewState"; */





