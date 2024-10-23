package CuartoEjemplo;

class Contador {
    private int contador = 0;

    public synchronized void incrementar() {
        contador++;
        System.out.println("Contador: " + contador);
    }
}

public class HiloMain {
    public static void main(String[] args) {
        Contador contador = new Contador();
        Thread hilo1 = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                contador.incrementar();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });
        Thread hilo2 = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                contador.incrementar();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });

        hilo1.start();
        hilo2.start();

    }
}
