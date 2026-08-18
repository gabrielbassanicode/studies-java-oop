package abstraction;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Shape> shapeList = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int number = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            System.out.printf("Shape #%d data:\n", i);
            System.out.print("Rectangle or circle (R/C)? ");
            char option = sc.next().toUpperCase().charAt(0);
            sc.nextLine();
            System.out.print("Color(black/red/blue): ");
            Color color = Color.valueOf(sc.nextLine().toUpperCase());

            if (option == 'R') {
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();

                shapeList.add(new Rectangle(color, width, height));

            }else  {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();

                shapeList.add(new Circle(color, radius));
            }
        }
        System.out.println();
        System.out.println("SHAPES AREA:");

        for (Shape s: shapeList) {
            System.out.println("Area: " + String.format("%.2f", s.area()) + " Color: " + s.getColor());
        }
        sc.close();
    }
}
