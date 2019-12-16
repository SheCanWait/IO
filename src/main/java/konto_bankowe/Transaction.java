package konto_bankowe;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Date;

public abstract class Transaction {

    protected int id;
    protected Date date;
    protected String title;
    protected Customer recipient;
    protected Customer sender;
    protected boolean fulfilled;
    protected int amount;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public Customer getRecipient() {
        return recipient;
    }

    public Customer getSender() {
        return sender;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRecipient(Customer recipient) {
        this.recipient = recipient;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
