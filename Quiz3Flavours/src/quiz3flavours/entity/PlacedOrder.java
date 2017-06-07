/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3flavours.entity;

/**
 *
 * @author ipd
 */
public class PlacedOrder {
    
    public int id;
    public String custName;
    public String flavourList;

    public PlacedOrder(int id, String custName, String flavourList) {
        this.id = id;
        this.custName = custName;
        this.flavourList = flavourList;
    }

    @Override
    public String toString() {
        return String.format("%s ordered: %s", custName, flavourList);
    }
}
