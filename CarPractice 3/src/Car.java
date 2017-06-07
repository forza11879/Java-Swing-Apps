/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ipd
 */
public class Car {
    
    public Car(String nameModel, int yop, double acceleration) {
        this.nameModel = nameModel;
        this.yop = yop;
        this.acceleration = acceleration;
    }    

    String nameModel;
    int yop;
    double acceleration;   
    
    @Override
    public String toString() {
        return String.format("%s from %s yop has %f", nameModel, yop, acceleration);
    }
    
    
}
