package Ejericicio2;

import java.util.LinkedList;

public class Carro {
    LinkedList<String> puente = new LinkedList<>();
    String coche;
    void entrarPuenteS() throws InterruptedException {
        synchronized (this){
            while(puente.contains(coche)){
                wait();
            }
            coche="Carro del sur";
            this.puente.add(coche);
            System.out.println("El "+coche+" entra en el puente");
            notify();
        }
    }
    void salirPuenteS() throws InterruptedException {
        synchronized (this){
            while(!puente.contains(coche)){
                wait();
            }
            coche="Carro del sur";
            puente.remove(coche);
            System.out.println("El "+coche+" a salido del puente");
            notify();
        }
    }
    void entrarPuenteN() throws InterruptedException {
        synchronized (this){
            while(puente.contains(coche)){
                wait();
            }
            coche="Carro del norte";
            puente.add(coche);
            System.out.println("El "+coche+" entra en el puente");
            notify();
        }
    }
    void salirPuenteN() throws InterruptedException {
        synchronized (this){
            while(!puente.contains(coche)){
                wait();
            }
            coche="Carro del norte";
            puente.remove(coche);
            System.out.println("El "+coche+" a salido del puente");
            notify();
        }
    }
}
