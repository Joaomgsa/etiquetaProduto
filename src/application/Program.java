package application;

import entities.ImportedProduct;
import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the number of products : ");
        int n = sc.nextInt();

        List<Product> list = new ArrayList<>();

        for (int i =1; i <= n ; i++) {
            System.out.println("Product #"+i+"data");
            System.out.print("Common, used or imported (c/u/i)? ");
            char typeOfProduct = sc.next().charAt(0);
            System.out.print("Name : ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price : ");
            Double price = sc.nextDouble();
            switch (typeOfProduct) {
                case 'c':
                    list.add(new Product(name,price));
                break;
                //falta colocar o SDF para capturar a data.
                case 'u':
                    System.out.print("Manufacture date DD/MM/YY :");
                break;

                case 'i':
                    System.out.print("Customs fee:  ");
                    double customFee = sc.nextDouble();
                    list.add(new ImportedProduct(name, price, customFee));
            }

            System.out.println();
            System.out.println("Price Tag");


            //falta ajustar formatos para aparecer datas e condicionais para imprimir produtos diferentes(Provavelmente outro switch)
            for (Product product : list
            ){
                System.out.println(product.getName()+ "$" + String.format("%.2f", product.getPrice()) );
            }

            sc.close();

        }

    }
}