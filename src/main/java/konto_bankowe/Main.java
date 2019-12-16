/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konto_bankowe;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application app = new Application();
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "test", "example@example.com", "123", "Jan", "Kowalski", "Przyk³adowa", "123456789", "123456789"));
        customers.add(new Customer(2, "makapaka123", "makapaka@makapaka.com", "makapaka", "Maka", "Paka", "Kamienna", "123456780", "122456789"));
        app.setCustomers(customers);
        
        System.out.println(app.login("makapaka123", "makapaka"));

        app.performTransfer(customers.get(0), 50);
        app.performTransfer(customers.get(1), 10);

    }
    
}
