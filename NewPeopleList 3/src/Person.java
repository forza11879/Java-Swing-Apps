/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ipd
 */
public class Person {
    
    public Person(String name, int age, String postcode) {
        this.name = name;
        this.age = age;
        this.postcode = postcode;
    }    

    String name;
    int age;
    String postcode;   
    
    @Override
    public String toString() {
        return String.format("%s is %d y/o at %s", name, age, postcode);
    }
    
    
    
}
