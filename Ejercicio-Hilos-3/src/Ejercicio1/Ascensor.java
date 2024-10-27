package Ejercicio1;


import java.util.LinkedList;

public class Ascensor {

    public final int CAPACIDAD = 2;
    LinkedList<Integer> ascensor = new LinkedList();



    public void entrarAscensor(int persona) throws InterruptedException {
        synchronized (this) {
            if (ascensor.size() == CAPACIDAD) {
                wait();
                notify();
            }
            if(ascensor.isEmpty()){
                ascensor.add(100);

            }
            ascensor.add(persona);
            System.out.println("La persona " + persona + " ha entrado en el acensor");
            notify();
        }
    }
    public void salirAscensor() throws InterruptedException {
        synchronized (this) {
            if (ascensor.size() !=CAPACIDAD) {
                wait();
                notify();
            }


            int persona = ascensor.removeFirst();
            System.out.println("La persona " + persona + " ha salido de el acensor");
            notify();
        }
    }
}
