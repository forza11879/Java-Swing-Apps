package tryjunit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class TryJUnitTest {

    public TryJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addTwoNaturalNumbers method, of class TryJUnit.
     */
    @Test
    public void testAddTwoNaturalNumbers() {
        System.out.println("addTwoNaturalNumbers");
        int a = 123;
        int b = 17;
        int expResult = 140;
        int result = TryJUnit.addTwoNaturalNumbers(a, b);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddTwoNaturalNumbersNegative() {
        System.out.println("addTwoNaturalNumbersNegative");

        try {
            TryJUnit.addTwoNaturalNumbers(-3, 3);
            fail("-3 is not a natural number and should throw an exception");
        } catch (IllegalArgumentException e) {
        }

        try {
            TryJUnit.addTwoNaturalNumbers(5, -5);
            fail("-5 is not a natural number and should throw an exception");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test of main method, of class TryJUnit.
     */
    @Ignore
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TryJUnit.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
