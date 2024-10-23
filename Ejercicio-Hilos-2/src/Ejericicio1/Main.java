package Ejericicio1;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Aparcamiento aparcamiento = new Aparcamiento();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(100);
        list.add(90);
        list.add(80);
        list.add(70);
        list.add(60);

        aparcamiento.setElementosLista(list);
        Thread coche1 = new Thread(()->{
            try {
                int coche =0 ;
                while (true) {
                    aparcamiento.aparcar(coche);
                    Thread.sleep(1000);
                    coche++;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread coche2 = new Thread(()->{
            try {
                while (true) {
                    aparcamiento.salir();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        coche1.start();
        coche2.start();
    }
}
