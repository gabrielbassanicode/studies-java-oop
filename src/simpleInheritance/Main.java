package simpleInheritance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Employee register:");
        System.out.print("How many employees? ");
        int amount = sc.nextInt();
        List<Employee> employees = new ArrayList<>();


        for (int i = 0; i < amount; i++) {
            System.out.println(i + 1 + "# employee");
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Birthday(dd/MM/yyyy): ");
            LocalDate birth = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Role in job (DEVELOPER, MANAGER): ");
            Role role = Role.valueOf(sc.nextLine().toUpperCase());


            if (role == Role.DEVELOPER) {
                System.out.print("How many projects he finished? ");
                int completedProjects = sc.nextInt();
                Employee employee = new Developer(name, salary, birth, completedProjects, role);
                employees.add(employee);

            }else {
                System.out.print("What for bonus? ");
                double bonus = sc.nextDouble();
                Employee employee = new Manager(name, salary, birth, bonus, role);
                employees.add(employee);
            }
        }

        System.out.println("Employees: ");
        for (Employee e: employees) {
            System.out.println(e);
            System.out.println();

        }

        sc.close();;
    }
}
