package SegundoEjemplo;

public class HiloMain {
    public static void main(String[] args) {
        MiRunnable miRunnable = new MiRunnable();
        Thread hilo = new Thread(miRunnable);
        hilo.start();
    }
}
