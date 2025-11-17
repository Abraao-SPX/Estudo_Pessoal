package logicaJava;

import java.util.Scanner;
 
    public class Escaner {
 
     static void main(String[] args) {
 
    Scanner sc1 = new Scanner(System.in); 
    
    long  c, d, oma;

    c = sc1.nextInt();
    d = sc1.nextInt();

    oma = c + d ;

    System.out.println("seu resutado é " + oma);
    
    sc1.close();

 }

}