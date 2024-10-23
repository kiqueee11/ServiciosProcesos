package QuintoEjemplo;

import java.util.LinkedList;

public class HiloMain {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(400);
        list.add(300);
        list.add(200);
        list.add(100);
        almacen.setElementosLista(list);


        Thread productor = new Thread(()->{
            try{
               int valor = 1;
               while (true){
                   almacen.producir(valor);
                   Thread.sleep(1000);
                   valor++;
               }
            }
            catch (InterruptedException e){
                System.out.println("Error: "+e);
            }
        });
        Thread consumidor = new Thread(()->{
            try{

                while (true){
                    almacen.consumir();
                    Thread.sleep(2000);

                }
            }
            catch (InterruptedException e){
                System.out.println("Error: "+e);
            }
        });
        productor.start();
        consumidor.start();
    }
}
