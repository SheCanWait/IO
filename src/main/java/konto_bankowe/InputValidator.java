/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konto_bankowe;

import java.util.Date;

/**
 *
 * @author User
 */
public class InputValidator {
    static String getHashOf(String value) {
        return Integer.toHexString(value.hashCode());
    }
    
    static boolean isEqualString(String val1, String val2) {
        boolean equal = val1.equals(val2);
        return equal;
    }

    static boolean validateTransferData(Transfer transfer) {
        if(transfer.id < 0) {
            return false;
        }
        if(transfer.date.before(new Date())) {
            return false;
        }
        if(transfer.title == null || transfer.title.length() <= 0) {
            return false;
        }
        if(transfer.recipient == null) {
            return false;
        }
        if(transfer.sender == null) {
            return false;
        }
        if(transfer.amount <= 0) {
            return false;
        }
        return true;
    }
}
