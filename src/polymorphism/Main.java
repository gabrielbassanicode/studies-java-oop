package polymorphism;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Person> payerList = new ArrayList<>();

        System.out.print("How many payers? ");
        int amount = sc.nextInt();

        for (int i = 1; i <= amount; i++) {
            System.out.printf("Tax payer #%d data: \n", i);
            System.out.print("Individual or company?(I/C) ");
            char option = sc.next().toUpperCase().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();

            if (option == 'I') {
                System.out.print("Medical expenses: ");
                double medicalExpenses = sc.nextDouble();

                payerList.add(new NaturalPerson(name, annualIncome, medicalExpenses));

            }else  {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();

                payerList.add(new LegalEntity(name, annualIncome, numberOfEmployees));

            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");

        double total = 0.0;
        for (Person p: payerList) {
            total += p.taxCalculation();
            System.out.println(p);

        }
        System.out.println();
        System.out.println("TOTAL TAXES: $" + String.format("%.2f", total));

        sc.close();
    }


}
