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
public class Flavour {
    public int id;
    public String name;

    public Flavour(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
