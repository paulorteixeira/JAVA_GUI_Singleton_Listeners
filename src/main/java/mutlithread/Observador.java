/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mutlithread;

/**
 *
 * @author Paulo
 */
public interface Observador { //também chamado de "Listener"
    public void notificar(Observado obs); //também chamado de "notify()"
}
