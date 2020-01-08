package konto_bankowe;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Category(KontoBankoweTestCategory2.class)
public class BankAccountTest {

    private BankAccount serviceUnderTest;

    @Before
    public void setUp() {
        serviceUnderTest = new BankAccount();
    }

    @Test
    public void shouldAddSingleTransferToTransactionsHistory() {
        //given
        Transfer transfer1 = new Transfer();
        transfer1.id = 1;
        Transfer transfer2 = new Transfer();
        transfer2.id = 2;
        ArrayList<Transaction> transactions = new ArrayList<>(Arrays.asList(transfer1));
        serviceUnderTest.setTransactions(transactions);

        //when
        serviceUnderTest.updateTransactionHistory(transfer2);

        //then
        assertEquals(2, serviceUnderTest.getTransactions().size());
        assertEquals(serviceUnderTest.getTransactions().get(0), transfer1);
        assertEquals(serviceUnderTest.getTransactions().get(1), transfer2);
    }

    @Test
    public void shouldAddSingleTransferToEmptyTransactionsHistory() {
        //given
        Transfer transfer1 = new Transfer();
        transfer1.id = 1;
        ArrayList<Transaction> transactions = new ArrayList<>(Collections.emptyList());
        serviceUnderTest.setTransactions(transactions);

        //when
        serviceUnderTest.updateTransactionHistory(transfer1);

        //then
        assertEquals(1, serviceUnderTest.getTransactions().size());
        assertEquals(serviceUnderTest.getTransactions().get(0), transfer1);
    }
}
