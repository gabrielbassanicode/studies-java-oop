package interfacePaymentSystemConcept;

// Example system

public class PayBank implements OnlinePaymentSystem {

    public Double paymentFee(Double value) {
        return value * 0.02;

    }

    public Double interest(Double value, Integer month) {
        return value * 0.01 * month;
    }
}
