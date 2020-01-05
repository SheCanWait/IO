/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konto_bankowe;

public abstract class User {
    protected int id;
    protected String login;
    protected String email;
    protected String passwordHash;
    protected String firstName;
    protected String lastName;

    public User(int id, String login, String email, String password, String firstName, String lastName) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.passwordHash = InputValidator.getHashOf(password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPassword(String password) {
        this.passwordHash = InputValidator.getHashOf(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Imiê: ");
        sb.append(getFirstName());
        sb.append("\nNazwisko: ");
        sb.append(getLastName());
        
        return sb.toString();
    }

}
