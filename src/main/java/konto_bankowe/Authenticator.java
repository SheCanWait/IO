/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konto_bankowe;

import java.util.Random;

/**
 *
 * @author User
 */
public class Authenticator {
    public static boolean authenticateUser(Customer user) {
        String authenticationCode = sendAuthenticationMessage(user);
        String authenticationCodeProvided = Application.promptForAuthenticationCode();
        return InputValidator.isEqualString(authenticationCodeProvided, authenticationCode);
    }
    
    private static String sendAuthenticationMessage(Customer user) {
        String authenticationCode = generateAuthenticationCode();
        StringBuilder sb = new StringBuilder();
        
        sb.append("Twoj kod weryfikacyjny: ");
        sb.append(authenticationCode);
        
        String message = sb.toString();
        
        SMSHandler.sendMessageTo(message, user);
        
        return authenticationCode;
    }
    
    private static String generateAuthenticationCode() {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        while(sb.length() < 9) {
            int number = r.nextInt(10);
            String num_str = Integer.toString(number);
            sb.append(num_str);
        }
        String authenticationCode = sb.toString();
        // Potrzebne do zasymulowania wpisywania kodu weryfikacyjnego przez u¿ytkownika
        Application.lastAuthenticationCode = authenticationCode;
        return authenticationCode;
    }
}
