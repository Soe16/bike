package de.hsba.test.bike.bike.web;

import de.hsba.test.bike.bike.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.Statement;
import java.sql.ResultSet;
import java.util.Vector;


@Controller
@RequestMapping("/orders")
public class viewOrderController {


    @GetMapping("/")
    public String vieworders(){
        return "orders";
    }

//Datenbankabfrage hier rein, table muss definiert werden: table ist " bestellung  " : https://jaxenter.de/mysql-und-java-datenabfrage-8123

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


}


