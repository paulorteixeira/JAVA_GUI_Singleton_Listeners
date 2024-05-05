/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mutlithread;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class Observado {

    private static Observado instance;

    private Object atributoQualquer;
    
    private int counter = 0;
    private String texto = "";
    private String pathExcel ="";
    private List<List<Object>> tabela = new ArrayList<List<Object>>();
    
    private final List<Observador> observadores = new ArrayList<Observador>();

    private Observado() {
        // The following code emulates slow initialization.
    }

    public static Observado getInstance() {
        if (instance == null) {
            instance = new Observado();
        }
        return instance;
    }

    void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.notificar(this);
        }
    }

    public void adicionarObservador(Observador obs) { //também chamado de addListener(...)
        observadores.add(obs); //"obs" passará a ser notificado sobre mudanças em this
    }

    public void removerObservador(Observador obs) { //também chamado de removeListener(...)
        observadores.remove(obs); //"obs" deixará de ser notificado sobre mudanças em this
    }

    public void setAtributoQualquer(Object novoValor) {
        atributoQualquer = novoValor;
        notificarObservadores(); //avisamos os Observadores que houve uma alteração em this
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
        notificarObservadores();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
        notificarObservadores();
    }
    
    public Object getAtributoQualquer() {
        return this.atributoQualquer;
    }

    public String getPathExcel() {
        return pathExcel;
    }

    public void setPathExcel(String pathExcel) {
        this.pathExcel = pathExcel;
         notificarObservadores();
    }

    public List<List<Object>> getTabela() {
        return tabela;
    }

    public void setTabela(List<List<Object>> tabela) {
        this.tabela = tabela;
        notificarObservadores();
    }


}
