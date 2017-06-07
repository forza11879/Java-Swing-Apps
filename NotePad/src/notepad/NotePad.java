/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import javax.swing.JFrame;

public class NotePad {
    

   
   
    public static void main(String[] args) {
       NotePadGUI obj = new NotePadGUI();
       
       obj.setBounds(0, 0, 700, 700);
       obj.setTitle("Note Pad");
       obj.setResizable(false);
       obj.setVisible(true);
       obj.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
       
   
  
    }
    
}
