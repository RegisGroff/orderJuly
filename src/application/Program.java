package application;

import entities.Client;
import entities.Enum.OrderStatus;
import entities.Order;
import entities.OrderItem;
import entities.Product;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Birth Date (DD/MM/YYYY): ");
        String birthDate = sc.next();
        LocalDate d01 = LocalDate.parse(birthDate, fmt1);

        Client client = new Client(name, email, d01);

        System.out.println("Enter order data:");

        System.out.print("Status: ");
        String orderData = sc.next();
        OrderStatus os = OrderStatus.valueOf(orderData);
        LocalDateTime d02 = LocalDateTime.now();
        Order order = new Order(d02, os, client);
        System.out.print("How many items to this order? ");
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= N; i ++){
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity, product.getPrice(), product);
            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order moment: " + d02.format(fmt2));
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + client.getName() + " (" + d01.format(fmt1) + ") - " + client.getEmail());
        System.out.println("Order items: ");

        for(OrderItem s : order.getItems()){
            System.out.print(s);
        }

        System.out.printf("Total price: %.2f%n", order.total());

        sc.close();
    }
}
