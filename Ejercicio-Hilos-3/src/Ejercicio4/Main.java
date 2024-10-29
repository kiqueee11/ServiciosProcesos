package Ejercicio4;
public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();
        Runnable trabajador = () -> {
            String nombre = Thread.currentThread().getName();

            try {
                fabrica.esperarInicio(nombre);
            } catch (InterruptedException var3) {
                InterruptedException e = var3;
                System.out.println("Error: " + String.valueOf(e));
            }

        };
        Thread trabajador1 = new Thread(trabajador, "Trabajador1");
        Thread trabajador2 = new Thread(trabajador, "Trabajador2");
        Thread trabajador3 = new Thread(trabajador, "Trabajador3");
        trabajador1.start();
        trabajador2.start();
        trabajador3.start();

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException var7) {
            InterruptedException e = var7;
            System.out.println("Error:" + String.valueOf(e));
        }

        fabrica.iniciarTrabajo();
    }
}