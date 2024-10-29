package Ejercicio4;


    public class Fabrica {
        private boolean llegaMaterial = false;

        public Fabrica() {
        }

        public synchronized void esperarInicio(String trabajador) throws InterruptedException {
            while(!this.llegaMaterial) {
                System.out.println(trabajador + " esta esperando el material");
                this.wait();
            }

            System.out.println(trabajador + " ha comenzado a trabajar");
        }

        public synchronized void iniciarTrabajo() {
            this.llegaMaterial = true;
            System.out.println("Ha llegado el material");
            this.notifyAll();
        }
    }


