package konto_bankowe;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Category(KontoBankoweTestCategory2.class)
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

    @Test
    public void shouldThrowExceptionForInvalidTelephoneNumber() {
        //given
        String message = "message";
        Customer recipient = createCustomer();
        String invalidTelephoneNumber = "qwe123rty";
        recipient.setTelephoneNumber(invalidTelephoneNumber);

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SMSHandler.sendMessageTo(message, recipient);
        });

        //then
        assertNotNull(exception);
        assertEquals(String.format("Invalid telephone number: %s", invalidTelephoneNumber), exception.getMessage());
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
