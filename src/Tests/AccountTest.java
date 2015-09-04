package Tests;

import Model.Account;
import Model.Exceptions.NoCharacterExistsException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Brandon on 2015-09-04.
 */
public class AccountTest {

    private Account test;
    private Account test2;

    @Before
    public void setup() {
        try {
            test = new Account("WTBsurvivability");
        } catch (NoCharacterExistsException e) {
            fail();
        }
        try {
            test2 = new Account("----");
            fail();
        } catch (NoCharacterExistsException e) {

        }
    }

    @Test
    public void testGetAccount() {
        assertEquals("agentvenom1", test.getAccountName());
        assertFalse(test.isOnline());
    }

    @Test
    public void testEquality() throws NoCharacterExistsException {
        Account test3 = new Account("WTBsurvivability");
        assertEquals(test, test3);
    }
}