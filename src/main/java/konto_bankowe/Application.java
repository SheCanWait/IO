/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konto_bankowe;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class Application {
    ArrayList<Customer> customers;
    User loggedInUser;
    public static String lastAuthenticationCode;

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    
    private Customer getCustomerByLogin(String login) {
        Iterator<Customer> it = customers.iterator();
        while(it.hasNext()) {
            Customer customer = it.next();
            String customerLogin = customer.getLogin();
            boolean loginsEqual = InputValidator.isEqualString(login, customerLogin);
            if(loginsEqual) {
                return customer;
            }
        }
        return null;
    }
    
    public User login(String login, String password) {
        Customer customer = getCustomerByLogin(login);
        
        if(customer != null) {
            String actualPasswordHash = customer.getPasswordHash();
            String hash = InputValidator.getHashOf(password);
            boolean hashesEqual = InputValidator.isEqualString(actualPasswordHash, hash);
            if(hashesEqual) {
                if(Authenticator.authenticateUser(customer) == true) {
                    return customer;
                }
            }
        }
        else {
            throw new IllegalArgumentException(String.format("Customer not found for login: %s", login));
        }
        
        return null;
    }

    public void performTransfer(Customer user, int amount) {
        if(Authenticator.authenticateUser(user) == true) {
            Transfer transfer = getDataForForm();
            if(validateTransferData(transfer) == true) {
                registerTransfer(transfer);
            }
        }
    }

    private Transfer getDataForForm() {
        Transfer transfer = new Transfer();
        transfer.amount = 100;
        transfer.date = Date.from(Instant.now().minusSeconds(60));
        transfer.fulfilled = false;
        transfer.id = 123456;
        transfer.recipient = new Customer(10, "login1", "email1", "password1", "firstName1", "lastName1");
        transfer.sender = new Customer(11, "login2", "email2", "password2", "firstName2", "lastName2");
        transfer.title = "transferTitle";
        return transfer;
    }

    private boolean validateTransferData(Transfer transfer) {
        return InputValidator.validateTransferData(transfer);
    }

    private void registerTransfer(Transfer transfer) {
        updateBalances(transfer);
        transfer.recipient.getBankAccount().updateTransactionHistory(transfer);
        transfer.sender.getBankAccount().updateTransactionHistory(transfer);
    }

    private void updateBalances(Transfer transfer) {
        Customer sender = transfer.getSender();
        BankAccount senderAccount = sender.getBankAccount();
        senderAccount.setBalance(senderAccount.getBalance() - transfer.amount);

        Customer recipient = transfer.getSender();
        BankAccount recipientAccount = recipient.getBankAccount();
        recipientAccount.setBalance(recipientAccount.getBalance() + transfer.amount);
    }
    
    public static String promptForAuthenticationCode() {
        return lastAuthenticationCode;
    }
    
}
