package compositionOrderConcept;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date(DD/MM/YYYY): ");
        String stringBirth = sc.nextLine();
        LocalDate birthDay = LocalDate.parse(stringBirth, fmt);

        Client client = new Client(name, email, birthDay);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine().toUpperCase());
        System.out.print("How many items to this order? ");
        int amount = sc.nextInt();
        sc.nextLine();

        Instant moment = Instant.now();
        Order order = new Order(moment, status, client);

        for(int i = 0; i < amount; i++) {
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Enter the quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            Product product = new Product(productName, productPrice);
            OrderItem item = new OrderItem(quantity, product);
            order.addItem(item);

        }
        System.out.println();
        System.out.println(order);


        sc.close();
    }


}
