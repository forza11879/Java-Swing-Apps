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
public class Flavour {

    public int flavourID;
    public String name;

    public Flavour(int flavourID, String name) {
        this.flavourID = flavourID;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", flavourID, name);
    }

    public void setFlavourID(int flavourID) {
        this.flavourID = flavourID;
    }

    public void setName(String name) {
        
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Name too short");
        }
        this.name = name;
    }

    public int getFlavourID() {
        return flavourID;
    }

    public String getName() {
        return name;
    }
    
   
}
