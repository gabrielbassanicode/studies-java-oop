package interfacePaymentSystemConcept;
import java.time.LocalDate;

public class ContractService {

    // Installment calculation based in an interface

    private OnlinePaymentSystem paymentSystem;

    public ContractService(OnlinePaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public void processContract(Contract contract, Integer months) {

        double installmentPerMonth = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {

            LocalDate monthOfInstallment = contract.getDate().plusMonths(i);

            double installmentInterest = installmentPerMonth + paymentSystem.interest(installmentPerMonth, i);
            double installmentTotal = installmentInterest + paymentSystem.paymentFee(installmentInterest);


            contract.addInstallment(new Installment(monthOfInstallment, installmentTotal));

        }
    }
}
