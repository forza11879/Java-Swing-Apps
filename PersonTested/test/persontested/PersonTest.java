/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persontested;

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
public class PersonTest {

    public PersonTest() {
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
     * Test of getName method, of class Person.
     */
    // @Test
    public void testGetName() {
        System.out.println("getName");
        Person instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetNameNull() {
        System.out.println("setName null");
        Person p = new Person("aaaaa", 7);
        //
        boolean exception = false;
        try {
            p.setName(null);
        } catch (IllegalArgumentException e) {
            exception = true;
        } catch (NullPointerException e) {
            fail("setName(null) must throw IllegalArgumentException, not NullPointerException");
        }
        assertEquals("setName(null) must throw exception", exception, true);
    }

    @Test
    public void testSetNameTooShort() {
        System.out.println("setName too short");
        Person p = new Person("aaaaa", 7);
        //
        boolean exception = false;
        try {
            p.setName("");
        } catch (IllegalArgumentException e) {
            exception = true;
        }
        
        /*
        // equivalent of assertEquals below
        if (exception != true) {
            fail("setName(\"\") must throw exception");
        }
        */        
        assertEquals("setName(\"\") must throw exception", exception, true);
        //
        exception = false;
        try {
            p.setName("a");
        } catch (IllegalArgumentException e) {
            exception = true;
        }
        assertEquals("setName(\"a\") must throw exception", exception, true);
    }

    @Test
    public void testSetNameLongEnough() {
        System.out.println("setName long enough");
        Person p = new Person("aaaaa", 7);
        String name = "M";
        try {
            for (int i = 2; i <= 20; i++) {
                name += "a";
                p.setName(name);
            }
        } catch (IllegalArgumentException e) {
            fail("setName(\"" + name + "\") should not throw IllegalArgumentException");
        }
    }

    /**
     * Test of getAge method, of class Person.
     */
    // @Test
    public void testGetAge() {
        System.out.println("getAge");
        Person instance = null;
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAge method, of class Person.
     */
    @Test
    public void testSetAge1to150() {
        System.out.println("setAge...");
        Person instance = new Person("Jerry", 20);
        for (int age = 0; age <= 150; age++) {
            instance.setAge(age);
        }
        System.out.println("setAge 1 to 150 passed");
    }

    @Test
    public void testSetAgeOutOfRangeNegative() {
        System.out.println("setAge out of range...");
        Person instance = new Person("Jerry", 20);
        for (int age = -1; age > -100; age--) {
            boolean exception = false;
            try {
                instance.setAge(age);
            } catch (IllegalArgumentException e) {
                exception = true;
            }
            // if (exception != true) then fail with the message
            assertEquals("Exception expected for age " + age, exception, true);
        }
    }

    @Test
    public void testSetAgeOutOfRangeAbove150() {
        System.out.println("setAge out of range above 150...");
        Person instance = new Person("Jerry", 20);
        for (int age = 151; age < 250; age++) {
            boolean exception = false;
            try {
                instance.setAge(age);
            } catch (IllegalArgumentException e) {
                exception = true;
            }
            // if (exception != true) then fail with the message
            assertEquals("Exception expected for age " + age, exception, true);
        }
    }

    /**
     * Test of toString method, of class Person.
     */
    // @Test
    public void testToString() {
        System.out.println("toString");
        Person instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
