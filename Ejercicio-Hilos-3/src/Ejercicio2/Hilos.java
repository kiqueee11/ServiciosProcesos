package Ejercicio2;


public class Hilos {
boolean inicio=false;
    public void sePrepara(String nombre) throws InterruptedException {
        synchronized (this){
            if(!inicio){
                System.out.println("El hilo "+nombre+" se prepara");
                wait();
            }
            System.out.println("El hilo "+nombre+" se lanza");
        }
    }
    public void lanzarHilos(){
        synchronized (this){
                inicio = true;
                System.out.println("Se lanzan los hilos");
                notifyAll();

        }
    }
}
