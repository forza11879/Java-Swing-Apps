/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ipd
 */
public class PlacedOrderTest {

    public PlacedOrderTest() {
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
     * Test of toString method, of class PlacedOrder.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PlacedOrder instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlacedOrderID method, of class PlacedOrder.
     */
    @Test
    public void testSetPlacedOrderID() {
        System.out.println("setPlacedOrderID");
        int placedOrderID = 0;
        PlacedOrder instance = null;
        instance.setPlacedOrderID(placedOrderID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerName method, of class PlacedOrder.
     */
    @Test
    public void testSetCustomerNameNull() {
        System.out.println("setCustomerName null....");
        PlacedOrder po = new PlacedOrder(2, "aaaaa", "aaaaa");
        //
        boolean exception = false;
        try {
            po.setCustomerName(null);
        } catch (IllegalArgumentException e) {
            exception = true;
        } catch (NullPointerException e) {
            fail("setCustomerName(null) must throw IllegalArgumentException, not NullPointerException");
        }
        assertEquals("setCustomerName(null) must throw exception", exception, true);
    }

    @Test
    public void testSetCustomerNameTooShort() {
        System.out.println("setCustomerName too short.....");
        PlacedOrder po = new PlacedOrder(2, "aaaaa", "aaaaa");
        //
        boolean exception = false;
        try {
            po.setCustomerName("");
        } catch (IllegalArgumentException e) {
            exception = true;
        }

        assertEquals("setCustomerName(\"\") must throw exception", exception, true);
        //
        exception = false;
        try {
            po.setCustomerName("a");
        } catch (IllegalArgumentException e) {
            exception = true;
        }
        assertEquals("setCustomerName(\"a\") must throw exception", exception, true);
    }

    @Test
    public void testSetCustomerNameLongEnough() {
        System.out.println("setCustomerName long enough....");
        PlacedOrder po = new PlacedOrder(2, "aaaaa", "aaaaa");
        String customerName = "M";
        try {
            for (int i = 2; i <= 20; i++) {
                customerName += "a";
                po.setCustomerName(customerName);
            }
        } catch (IllegalArgumentException e) {
            fail("setCustomerName(\"" + customerName + "\") should not throw IllegalArgumentException");
        }
    }

    @Test
    public void testSetFlavourListNull() {
        System.out.println("setFlavourList null....");
        PlacedOrder po = new PlacedOrder(2, "aaaaa", "aaaaa");
        //
        boolean exception = false;
        try {
            po.setFlavourList(null);
        } catch (IllegalArgumentException e) {
            exception = true;
        } catch (NullPointerException e) {
            fail("setFlavourList(null) must throw IllegalArgumentException, not NullPointerException");
        }
        assertEquals("setFlavourList(null) must throw exception", exception, true);
    }

    /**
     * Test of getPlacedOrderID method, of class PlacedOrder.
     */
    @Test
    public void testGetPlacedOrderID() {
        System.out.println("getPlacedOrderID");
        PlacedOrder instance = null;
        int expResult = 0;
        int result = instance.getPlacedOrderID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerName method, of class PlacedOrder.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        PlacedOrder instance = null;
        String expResult = "";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlavourList method, of class PlacedOrder.
     */
    @Test
    public void testGetFlavourList() {
        System.out.println("getFlavourList");
        PlacedOrder instance = null;
        String expResult = "";
        String result = instance.getFlavourList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
