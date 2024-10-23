package Ejericicio2;

import java.util.LinkedList;

public class Carro {
    String cocheN="Carro del norte";
    String cocheS="Carro del sur";
    LinkedList<String> puente = new LinkedList<>();

    void entrarPuenteS() throws InterruptedException {
        synchronized (this){
            while(puente.contains(cocheN)){
                wait();
            }
            while(puente.contains(cocheS)){
                wait();
            }

            this.puente.add(cocheS);
            System.out.println("El "+cocheS+" entra en el puente");
            notify();
        }
    }
    void salirPuenteS() throws InterruptedException {
        synchronized (this){
            while(!puente.contains(cocheS)){
                wait();
            }

            puente.remove(cocheS);
            System.out.println("El "+cocheS+" a salido del puente");
            notify();
        }
    }
    void entrarPuenteN() throws InterruptedException {
        synchronized (this){
            while(puente.contains(cocheN)){
                wait();
            }
            while(puente.contains(cocheS)){
                wait();
            }
            this.puente.add(cocheN);
            System.out.println("El "+cocheN+" entra en el puente");
            notify();
        }
    }
    void salirPuenteN() throws InterruptedException {
        synchronized (this){
            while(!puente.contains(cocheN)){
                wait();
            }

            puente.remove(cocheN);
            System.out.println("El "+cocheN+" a salido del puente");
            notify();
        }
    }
}
