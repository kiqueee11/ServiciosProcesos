package Ejercicio2;

import Ejercicio1.Contador;

public class Main {
    public static void main(String[] args) {
        Numeros numeros = new Numeros();
        Thread hilo1 = new Thread(()->{
            try{
                while(true) {
                    numeros.numeroPar();
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });
        Thread hilo2 = new Thread(()->{
            try{
                while(true) {
                    numeros.numeroImpar();
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });
        hilo1.start();
        hilo2.start();
    }
}
