package konto_bankowe;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertFalse;

@RunWith(PowerMockRunner.class)
public class AuthenticatorTest {

    private static final String LOGIN = "LOGIN";
    private static final String EMAIL = "email@email.com";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @PrepareForTest(Application.class)
    @Test
    public void shouldFailToAuthenticateForWrongAuthenticationCode() {
        //given
        Customer customer = createCustomer();
        PowerMockito.mockStatic(Application.class);
        PowerMockito.when(Application.promptForAuthenticationCode()).thenReturn("qwertyuio");

        //when
        boolean isAuthenticationSuccessful = Authenticator.authenticateUser(customer);

        //then
        assertFalse(isAuthenticationSuccessful);
    }

    @PrepareForTest(Application.class)
    @Test
    public void shouldFailToAuthenticateForTooLongCode() {
        //given
        Customer customer = createCustomer();
        PowerMockito.mockStatic(Application.class);
        PowerMockito.when(Application.promptForAuthenticationCode()).thenReturn("0123456789");

        //when
        boolean isAuthenticationSuccessful = Authenticator.authenticateUser(customer);

        //then
        assertFalse(isAuthenticationSuccessful);
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
