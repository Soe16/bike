package de.hsba.test.bike.bike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    @SpringBootApplication
    public class BikeApplication {


        //database connection to view orders
        public static void main(String[] args) throws SQLException {
            SpringApplication.run(de.hsba.test.bike.bike.BikeApplication.class, args);
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

            conn.close();

        }
    }
