package Ejercicio2;

public class Numeros {
    int numero=1;
     void numeroPar() throws InterruptedException {
        synchronized (this){
            while (numero % 2 != 0){
                wait();
            }
            System.out.println("Numero par "+numero);
            numero++;
            notify();
        }
    }
     void numeroImpar() throws InterruptedException {
        synchronized (this){
            while (numero % 2 == 0){
                wait();
            }
            System.out.println("Numero impar "+numero);
            numero++;
            notify();
        }
    }
}
