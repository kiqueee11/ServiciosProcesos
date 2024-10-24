package Ejericicio2;


import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro();

        Thread carroNorteEntra = new Thread(()->{
            try {
                while(true) {

                    carro.entrarPuenteN();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread carroNorteSale = new Thread(()->{
            try {
                while(true) {
                    carro.salirPuenteN();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread carroSurEntra = new Thread(()->{
            try {
                while(true) {
                    carro.entrarPuenteS();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread carroSurSale = new Thread(()->{
            try {
                while(true) {
                    carro.salirPuenteS();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        carroSurEntra.start();
        carroSurSale.start();
        carroNorteEntra.start();
        carroNorteSale.start();
    }
}
