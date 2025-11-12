package orientacao_objeto.Estrutura_estoq;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product product = new Product();
        System.out.println("Entre product data: ");
        System.out.print("Nome: ");
        product.name = sc.nextLine();
        System.out.print("Price: ");
        product.price = sc.nextDouble();
        System.out.print("Quantity in stock: ");
        product.quantity = sc.nextInt();

        System.out.println();
        System.out.println("Product data: " + product);

        System.out.println();
        System.out.print("Enter the number of product to be added in sfock:");
        int quantity = sc.nextInt();
        product.addProduto(quantity);

        System.out.println();
        System.out.println("Updated data: " + product);
        
        System.out.println();
        System.out.print("Enter the number of product to be remove in sfock: ");
        quantity = sc.nextInt();
        product.removeProducts(quantity);

        System.out.println();
        System.out.println("Product data: " + product);
       
       
       
        sc.close();
    }

}
