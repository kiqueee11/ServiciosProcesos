package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();

        Thread subirAscensor = new Thread(()->{
           try{
               int persona  = 0;
               while (true) {
                   persona++;
                   ascensor.entrarAscensor(persona);
                   Thread.sleep(1000);
               }
           }catch (InterruptedException e){

               System.out.println("Error: "+e);

           }
        });

        Thread bajarAscensor = new Thread(()->{
            try{
                while (true) {
                    ascensor.salirAscensor();
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){

                System.out.println("Error: "+e);

            }
        });

        subirAscensor.start();
        bajarAscensor.start();
    }
}
