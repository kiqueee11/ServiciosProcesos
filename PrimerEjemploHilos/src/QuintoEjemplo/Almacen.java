package QuintoEjemplo;

import java.util.LinkedList;

public class Almacen {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int CAPACIDAD = 5;

    public void setElementosLista(LinkedList<Integer> listaProv){
        list=listaProv;
    }

    public void producir(int valor) throws InterruptedException {
        synchronized (this) {
            while (list.size() == CAPACIDAD) {
                wait();
            }
            list.add(valor);
            System.out.println("Producido " + valor);
            notify();
        }
    }

    public void consumir()throws InterruptedException{
        synchronized (this){
            while(list.isEmpty()){
                wait();
            }
            int valor = list.removeFirst();
            System.out.println("Producto consumido: "+valor);
            notify();
        }

    }

}
