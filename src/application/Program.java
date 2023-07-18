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

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        String birthDate = sc.next();
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d08 = LocalDate.parse(birthDate, fmt1);
        Client client = new Client(name, email, d08);
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderData = sc.next();
        OrderStatus os2 = OrderStatus.valueOf(orderData);
        LocalDateTime d02 = LocalDateTime.now();
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Order order = new Order(d02, os2, client);
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
        System.out.print("Order moment: " + d02.format(fmt2) + "\n");
        System.out.print("Order status: " + order.getStatus() + "\n");
        System.out.print("Client: " + client.getName() + " (" + d08.format(fmt1) + ") - " + client.getEmail() + "\n");
        System.out.println("Order items: ");

        for(OrderItem s : order.getItems()){
            System.out.print(s);
        }
        System.out.println();
        System.out.printf("Total price: %.2f%n", order.total());

        sc.close();

    }
}
