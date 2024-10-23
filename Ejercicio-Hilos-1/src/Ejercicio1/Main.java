package Ejercicio1;


public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();
        Thread hilo1 = new Thread(()->{
            for (int i = 1; i <6 ; i++) {
                contador.incrementar();
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    System.out.println("Error: "+e);
                }
            }
        });
        Thread hilo2 = new Thread(()->{
            for (int i = 1; i <6 ; i++) {
                contador.restar();
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    System.out.println("Error: "+e);
                }
            }
        });
        hilo1.start();
        while (hilo1.isAlive()){}
        hilo2.start();

    }
}
