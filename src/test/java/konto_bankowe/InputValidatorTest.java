package konto_bankowe;

import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.*;


public class InputValidatorTest {

    private static final String LOGIN = "LOGIN";
    private static final String EMAIL = "email@email.com";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @Test
    public void shouldGetCorrectHashOfString() {
        //given
        String valueToGetHashOf = "someString";

        //when
        String hashOfTheString = InputValidator.getHashOf(valueToGetHashOf);

        //then
        assertEquals(hashOfTheString, Integer.toHexString(valueToGetHashOf.hashCode()));
    }

    @Test
    public void shouldReturnTrueForEqualStrings() {
        //given
        String string1 = "someString";
        String string2 = "someString";

        //when
        boolean areStringsEqual = InputValidator.isEqualString(string1, string2);

        //then
        assertTrue(areStringsEqual);
    }

    @Test
    public void shouldReturnFalseForNotEqualStrings() {
        //given
        String string1 = "someString1";
        String string2 = "someString2";

        //when
        boolean areStringsEqual = InputValidator.isEqualString(string1, string2);

        //then
        assertFalse(areStringsEqual);
    }

    @Test
    public void shouldSuccessfullyValidateTransferDataForCorrectData() {
        //given
        Transfer transfer = new Transfer();
        transfer.id = 1;
        transfer.date = Date.from(Instant.now().plusSeconds(60));
        transfer.title = "title";
        transfer.recipient = createCustomer();
        transfer.sender = createCustomer();
        transfer.amount = 100;

        //when
        boolean validationResult = InputValidator.validateTransferData(transfer);

        //then
        assertTrue(validationResult);
    }

    @Test
    public void shouldFailToValidateTransferDataForIncorrectId() {
        //given
        Transfer transfer = new Transfer();
        transfer.id = -5;
        transfer.date = Date.from(Instant.now().plusSeconds(60));
        transfer.title = "title";
        transfer.recipient = createCustomer();
        transfer.sender = createCustomer();
        transfer.amount = 100;

        //when
        boolean validationResult = InputValidator.validateTransferData(transfer);

        //then
        assertFalse(validationResult);
    }

    @Test
    public void shouldFailToValidateTransferDataForIncorrectDate() {
        //given
        Transfer transfer = new Transfer();
        transfer.id = 1;
        transfer.date = Date.from(Instant.now().minusSeconds(60));
        transfer.title = "title";
        transfer.recipient = createCustomer();
        transfer.sender = createCustomer();
        transfer.amount = 100;

        //when
        boolean validationResult = InputValidator.validateTransferData(transfer);

        //then
        assertFalse(validationResult);
    }

    @Test
    public void shouldFailToValidateTransferDataForNullTitle() {
        //given
        Transfer transfer = new Transfer();
        transfer.id = 1;
        transfer.date = Date.from(Instant.now().plusSeconds(60));
        transfer.title = null;
        transfer.recipient = createCustomer();
        transfer.sender = createCustomer();
        transfer.amount = 100;

        //when
        boolean validationResult = InputValidator.validateTransferData(transfer);

        //then
        assertFalse(validationResult);
    }

    @Test
    public void shouldFailToValidateTransferDataForEmptyTitle() {
        //given
        Transfer transfer = new Transfer();
        transfer.id = 1;
        transfer.date = Date.from(Instant.now().plusSeconds(60));
        transfer.title = "";
        transfer.recipient = createCustomer();
        transfer.sender = createCustomer();
        transfer.amount = 100;

        //when
        boolean validationResult = InputValidator.validateTransferData(transfer);

        //then
        assertFalse(validationResult);
    }

    @Test
    public void shouldFailToValidateTransferDataForEmptyRecipient() {
        //given
        Transfer transfer = new Transfer();
        transfer.id = 1;
        transfer.date = Date.from(Instant.now().plusSeconds(60));
        transfer.title = "title";
        transfer.recipient = null;
        transfer.sender = createCustomer();
        transfer.amount = 100;

        //when
        boolean validationResult = InputValidator.validateTransferData(transfer);

        //then
        assertFalse(validationResult);
    }

    @Test
    public void shouldFailToValidateTransferDataForEmptySender() {
        //given
        Transfer transfer = new Transfer();
        transfer.id = 1;
        transfer.date = Date.from(Instant.now().plusSeconds(60));
        transfer.title = "title";
        transfer.recipient = createCustomer();
        transfer.sender = null;
        transfer.amount = 100;

        //when
        boolean validationResult = InputValidator.validateTransferData(transfer);

        //then
        assertFalse(validationResult);
    }

    @Test
    public void shouldFailToValidateTransferDataForIncorrectAmount() {
        //given
        Transfer transfer = new Transfer();
        transfer.id = 1;
        transfer.date = Date.from(Instant.now().plusSeconds(60));
        transfer.title = "title";
        transfer.recipient = createCustomer();
        transfer.sender = null;
        transfer.amount = -100;

        //when
        boolean validationResult = InputValidator.validateTransferData(transfer);

        //then
        assertFalse(validationResult);
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
