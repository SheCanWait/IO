package konto_bankowe;

import java.util.ArrayList;

public class BankAccount {

    private String accountNumber;
    private Customer owner;
    private int balance;
    private ArrayList<Transaction> transactions;

    public void updateTransactionHistory(Transfer transfer) {
        getTransactions().add(transfer);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

}
