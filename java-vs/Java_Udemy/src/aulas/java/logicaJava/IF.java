package logicaJava;

import java.util.Scanner;

public class IF {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("digite a media:");
        double media = entrada.nextDouble();

        if (media >= 7.0)
            System.out.println("Aprovado");

        entrada.close();
    }
}
