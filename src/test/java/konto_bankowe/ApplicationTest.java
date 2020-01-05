package konto_bankowe;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(PowerMockRunner.class)
public class ApplicationTest {

    private static final String LOGIN = "LOGIN";
    private static final String DIFFERENT_LOGIN = "LOGIN";
    private static final String PASSWORD = "PASSWORD";
    private static final String EMAIL = "email@email.com";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    private Application serviceUnderTest;

    @Before
    public void setUp() {
        serviceUnderTest = new Application();
    }

    @PrepareForTest( {InputValidator.class, Authenticator.class})
    @Test
    public void shouldSuccessfullyLoginUser() {
        //given
        Customer customer = createCustomer();
        ArrayList<Customer> customers = new ArrayList<>(Collections.singletonList(customer));
        serviceUnderTest.setCustomers(customers);
        PowerMockito.mockStatic(InputValidator.class);
        PowerMockito.mockStatic(Authenticator.class);
        PowerMockito.when(InputValidator.isEqualString(customer.getLogin(), LOGIN))
                .thenReturn(true);
        PowerMockito.when(InputValidator.getHashOf(PASSWORD))
                .thenReturn("hash");
        PowerMockito.when(InputValidator.isEqualString(customer.getPasswordHash(), "hash"))
                .thenReturn(true);
        PowerMockito.when(Authenticator.authenticateUser(customer))
                .thenReturn(true);

        //when
        User user = serviceUnderTest.login(LOGIN, PASSWORD);

        //then
        assertEquals(user.login, LOGIN);
        assertEquals(user.email, EMAIL);
        assertEquals(user.firstName, FIRST_NAME);
        assertEquals(user.lastName, LAST_NAME);
    }

    @PrepareForTest( {InputValidator.class, Authenticator.class})
    @Test
    public void shouldFailToLoginAsNotExistingUser() {
        //given
        Customer customer = createCustomer();
        ArrayList<Customer> customers = new ArrayList<>(Collections.singletonList(customer));
        serviceUnderTest.setCustomers(customers);
        PowerMockito.mockStatic(InputValidator.class);
        PowerMockito.mockStatic(Authenticator.class);
        PowerMockito.when(InputValidator.isEqualString(customer.getLogin(), DIFFERENT_LOGIN))
                .thenReturn(false);
        PowerMockito.when(InputValidator.getHashOf(PASSWORD))
                .thenReturn("hash");
        PowerMockito.when(InputValidator.isEqualString(customer.getPasswordHash(), "hash"))
                .thenReturn(true);
        PowerMockito.when(Authenticator.authenticateUser(customer))
                .thenReturn(true);

        //when
        User user = serviceUnderTest.login(DIFFERENT_LOGIN, PASSWORD);

        //then
        assertNull(user);
    }

    @Test
    public void shouldFailToLoginAssssNotExistingUser() {
        //given
        Customer customer = createCustomer();
        int amount = 100;
        //TODO

        //when
        serviceUnderTest.performTransfer(customer, amount);

        //then

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
