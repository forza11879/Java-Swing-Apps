/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.entity;

/**
 *
 * @author ipd
 */
public class PlacedOrder {

    public int placedOrderID;
    public String customerName;
    public String flavourList;

    public PlacedOrder(int placedOrderID, String customerName, String flavourList) {
        this.placedOrderID = placedOrderID;
        this.customerName = customerName;
        this.flavourList = flavourList;
    }

    @Override
    public String toString() {
        //return "PlacedOrder{" + "placedOrderID=" + placedOrderID + ", customerName=" + customerName + ", flavourList=" + flavourList + '}';
    return String.format("%s %s %s ", placedOrderID, customerName, flavourList);
    }

    public void setPlacedOrderID(int placedOrderID) {
        this.placedOrderID = placedOrderID;
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.length() < 2) {
            throw new IllegalArgumentException("CustomerName too short");
        }
        this.customerName = customerName;
    }

    public void setFlavourList(String flavourList) {
        
        if (flavourList == null) {
            throw new IllegalArgumentException("Flavour List empty");
        }
        this.flavourList = flavourList;
    }

    public int getPlacedOrderID() {
        return placedOrderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getFlavourList() {
        return flavourList;
    }
    
    

}
