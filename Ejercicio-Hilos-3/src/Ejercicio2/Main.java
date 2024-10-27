package Ejercicio2;


public class Main {
    public static void main(String[] args) {
        Hilos hilos = new Hilos();

        Runnable runnable = ()-> {
            String nombre = Thread.currentThread().getName();

            try {
                hilos.sePrepara(nombre);
            }catch (InterruptedException e){
                System.out.println("Error: "+e);
            }
            };
        Thread hilo1 = new Thread(runnable, "Hilo1");
        Thread hilo2 = new Thread(runnable, "Hilo2");
        Thread hilo3 = new Thread(runnable, "Hilo3");

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hilos.lanzarHilos();
    }
}
