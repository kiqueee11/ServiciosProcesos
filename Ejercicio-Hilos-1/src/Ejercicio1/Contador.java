package Ejercicio1;

public class Contador{
    int contador1=0;
   synchronized void incrementar(){
       contador1++;
        System.out.println("Contador: "+contador1);
   }
   synchronized void restar(){
       contador1--;
       System.out.println("Contador: "+contador1);
   }
}