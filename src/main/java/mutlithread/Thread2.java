/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mutlithread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo
 */
public class Thread2 extends Thread  {
    public void run() {
        for (int i = 0; i <= 200; i++) {
            try {
                Thread.sleep(500);
                System.out.println("This code is running in a thread 2");
                Observado.getInstance().setCounter(i);

            } catch (InterruptedException ex) {
                Logger.getLogger(Observado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("cabo");
    }
}
