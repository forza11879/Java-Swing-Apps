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
public class Representative {
    
public int representativeID;
public String nameFirst;
public String nameLast;

    @Override
    public String toString() {
        return String.format("%s %s", nameFirst, nameLast);
    }




    public Representative(int representativeID, String nameFirst, String nameLast) {
        this.representativeID = representativeID;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
    }

    public void setRepresentativeID(int representativeID) {
        this.representativeID = representativeID;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public int getRepresentativeID() {
        return representativeID;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }


    
}
