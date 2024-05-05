/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mutlithread;

import com.mycompany.testeswingworker.NewJFrame;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Paulo
 */
public class Main {
    public Main(){
        Iniciar();
    }
    
    public static void main(String[] args) {
        new Main();
    }
    
    public void Iniciar(){
        BasicConfigurator.configure();
        Observado observado = Observado.getInstance();
        mainGUI njf = new mainGUI();
        observado.adicionarObservador(njf);
        
        njf.setVisible(true);
    }
}
