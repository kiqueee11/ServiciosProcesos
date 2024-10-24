package Ejericicio2;

import java.util.LinkedList;

public class Carro {
    String cocheN="Carro del norte";
    String cocheS="Carro del sur";
    LinkedList<String> puente = new LinkedList<>();
    boolean accesoNorte =false;
    boolean accesoSur=true;

    void entrarPuenteS() throws InterruptedException {
        synchronized (this){
            while(puente.contains(cocheN)){
                wait();
                notify();
            }
            while(puente.contains(cocheS)){
                wait();
                notify();
            }
            if(accesoSur) {
                this.puente.add(cocheS);
                System.out.println("El " + cocheS + " entra en el puente");
                accesoSur = false;
                notify();

            }else{
                wait();
            }
        }
    }
    void salirPuenteS() throws InterruptedException {
        synchronized (this){
            while(!puente.contains(cocheS)){
                wait();
                notify();
            }

            puente.remove(cocheS);
            System.out.println("El "+cocheS+" a salido del puente");
            accesoNorte = true;
            notify();
        }
    }
    void entrarPuenteN() throws InterruptedException {
        synchronized (this){
            while(puente.contains(cocheN)){
                wait();
                notify();
            }
            while(puente.contains(cocheS)){
                wait();
                notify();
            }
            if(accesoNorte) {
                this.puente.add(cocheN);
                System.out.println("El " + cocheN + " entra en el puente");
                accesoNorte = false;
                notify();

            }else {
                wait();
                notify();
            }
        }
    }
    void salirPuenteN() throws InterruptedException {
        synchronized (this){

            while(!puente.contains(cocheN)){
                wait();
                notify();
            }

            puente.remove(cocheN);
            System.out.println("El "+cocheN+" a salido del puente");
            accesoSur=true;
            notify();
        }
    }
}
