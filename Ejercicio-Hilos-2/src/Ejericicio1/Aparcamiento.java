package Ejericicio1;

import java.util.LinkedList;

public class Aparcamiento {
    LinkedList<Integer> aparcados = new LinkedList<>();
    final int CAPACIDAD = 5;

    public void setElementosLista(LinkedList<Integer> listaProv){
        aparcados=listaProv;
    }
    void aparcar(int coche) throws InterruptedException {
        synchronized (this){
            while(aparcados.size()==CAPACIDAD){
                wait();
            }
            this.aparcados.add(coche);
            System.out.println("El coche: "+coche+" ha sido aparcado");
            notify();
        }
    }
    void salir() throws InterruptedException {
        synchronized (this){
            while(aparcados.isEmpty()){
                wait();
            }
            int coche=aparcados.removeFirst();
            System.out.println("El coche: "+coche+" ha salido del estacionamiento");
            notify();
        }
    }
}
