package projetos;
import java.util.Scanner;
import java.util.Locale;    

public class cv {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

       
        
        System.out.println("Digite seu ultimo nome, idade e altura (mesma linha): ");
        String ultimoNome = scan.next();
        int idade = scan.nextInt();
        double altura = scan.nextDouble();

      
        System.out.printf("Ultimo nome: %s%nIdade: %d%nAltura: %.2f%n", ultimoNome, idade, altura);

        scan.close();
        
    }   
}
