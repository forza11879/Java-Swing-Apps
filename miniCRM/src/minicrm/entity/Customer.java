/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicrm.entity;

/**
 *
 * @author ipd
 */
public class Customer {
    
public int customerID;
public String nameFirst;
public String nameLast;
public String address;
public String postalCode;
public String phoneNumber;
public String SIN;

    @Override
    public String toString() {
        //return "Customer{" + "customerID=" + customerID + ", nameFirst=" + nameFirst + ", nameLast=" + nameLast + ", address=" + address + ", postalCode=" + postalCode + ", phoneNumber=" + phoneNumber + ", SIN=" + SIN + '}';
        return String.format("%s %s %s %s %s %s", nameFirst, nameLast, address, postalCode, phoneNumber, SIN );
    }



    public Customer(int customerID, String nameFirst, String nameLast, String address, String postalCode, String phoneNumber, String SIN) {
        this.customerID = customerID;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.SIN = SIN;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSIN() {
        return SIN;
    }

    
}
