/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitone;

import java.util.Date;

/**
 *
 * @author ipd
 */
public class Person {
    
   private String name;
    private int age;
    // Homework: 1) encapsulate fields, 2) write setters, 3) write unit tests for each setter
    String postalCode; // "7A7 A7A"
    double weightKg; // 0-300 (both inclusive)
    Date dateOfBirth; // valid date YYYY-MM-DD from 1900 to 2099 year

    public Person(String name, int age, String postalCode, double weightKg, Date dateOfBirth) {
        this.name = name;
        this.age = age;
        this.postalCode = postalCode;
        this.weightKg = weightKg;
        this.dateOfBirth = dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", postalCode=" + postalCode + ", weightKg=" + weightKg + ", dateOfBirth=" + dateOfBirth + '}';
    }
    
    
}
