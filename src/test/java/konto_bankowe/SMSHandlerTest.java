package konto_bankowe;


import org.junit.Test;

public class SMSHandlerTest {

    private static final String LOGIN = "LOGIN";
    private static final String EMAIL = "email@email.com";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @Test
    public void shouldSendMessageToCustomerForCorrectUserAndCorrectRecipient() {
        //given
        String message = "message";
        Customer recipient = createCustomer();

        //when
        SMSHandler.sendMessageTo(message, recipient);

        //then
        //no exceptions thrown, method execution finished
    }

    private static Customer createCustomer() {
        int id = 1;
        String login = LOGIN;
        String email = EMAIL;
        String passwordHash = "passwordHash";
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        String mothersMaidenName = "mothersMaidenName";
        String PESEL = "74637283746";
        String telephoneNumber = "123456789";
        return new Customer(id, login, email, passwordHash, firstName,
                lastName, mothersMaidenName, PESEL, telephoneNumber);
    }
}
