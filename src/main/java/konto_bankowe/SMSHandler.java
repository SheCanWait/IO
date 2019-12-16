/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konto_bankowe;

/**
 *
 * @author User
 */
public class SMSHandler {
    public static void sendMessageTo(String message, Customer recipient) {
        String telephoneNumber = recipient.getTelephoneNumber();
        send(telephoneNumber, message);
    }
    
    private static void send(String telephoneNumber, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("Wiadomosc do ");
        sb.append(telephoneNumber);
        sb.append(": ");
        sb.append(message);
        System.out.println(sb.toString());
    }
}
