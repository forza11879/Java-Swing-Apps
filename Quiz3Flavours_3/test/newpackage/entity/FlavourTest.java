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
public class FlavourTest {

    public FlavourTest() {
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

    @Test
    public void testToString() {
        System.out.println("toString");
        Flavour instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetFlavourID() {
        System.out.println("setFlavourID");
        int flavourID = 0;
        Flavour instance = null;
        instance.setFlavourID(flavourID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetNameNull() {
        System.out.println("setName null....");
        Flavour f = new Flavour(2, "aaaaa");
        //
        boolean exception = false;
        try {
            f.setName(null);
        } catch (IllegalArgumentException e) {
            exception = true;
        } catch (NullPointerException e) {
            fail("setName(null) must throw IllegalArgumentException, not NullPointerException");
        }
        assertEquals("setName(null) must throw exception", exception, true);
    }

    @Test
    public void testSetNameTooShort() {
        System.out.println("setName too short....");
        Flavour f = new Flavour(2, "aaaaa");
        //
        boolean exception = false;
        try {
            f.setName("");
        } catch (IllegalArgumentException e) {
            exception = true;
        }

        assertEquals("setName(\"\") must throw exception", exception, true);
        //
        exception = false;
        try {
            f.setName("a");
        } catch (IllegalArgumentException e) {
            exception = true;
        }
        assertEquals("setName(\"a\") must throw exception", exception, true);
    }
    
    @Test
    public void testSetNameLongEnough() {
        System.out.println("setName long enough....");
        Flavour f = new Flavour(2, "aaaaa");
        String name = "M";
        try {
            for (int i = 2; i <= 20; i++) {
                name += "a";
                f.setName(name);
            }
        } catch (IllegalArgumentException e) {
            fail("setName(\"" + name + "\") should not throw IllegalArgumentException");
        }
    }

    @Test
    public void testGetFlavourID() {
        System.out.println("getFlavourID");
        Flavour instance = null;
        int expResult = 0;
        int result = instance.getFlavourID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Flavour.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Flavour instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
