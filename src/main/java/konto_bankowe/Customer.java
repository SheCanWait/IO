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
public class Customer extends User {
    private String mothersMaidenName;
    private String PESEL;
    private String telephoneNumber;

    private BankAccount bankAccount;

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public void setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Customer(int id, String login, String email, String passwordHash, String firstName, String lastName, String mothersMaidenName, String PESEL, String telephoneNumber) {
        super(id, login, email, passwordHash, firstName, lastName);
        this.mothersMaidenName = mothersMaidenName;
        this.PESEL = PESEL;
        this.telephoneNumber = telephoneNumber;
    }

    public Customer(int id, String login, String email, String passwordHash, String firstName, String lastName) {
        super(id, login, email, passwordHash, firstName, lastName);
    }

}
