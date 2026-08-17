package interfacePaymentSystemConcept;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter the contract data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date(DD/MM/YYYY): ");
        LocalDate contractDate = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();
        System.out.print("Enter the number of installments: ");
        int instalmentsNumber = sc.nextInt();

        Contract contract = new Contract(number,contractDate, contractValue);
        ContractService contractService = new ContractService(new PayBank());

        contractService.processContract(contract, instalmentsNumber);


        for (Installment i: contract.getInstallments()) {
            System.out.println(i.getDueDate().format(fmt) + " - " + String.format("%.2f", i.getValue()));

        }

        sc.close();
    }
}
