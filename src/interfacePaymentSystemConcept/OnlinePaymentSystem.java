package interfacePaymentSystemConcept;

public interface OnlinePaymentSystem {

    Double paymentFee(Double value);

    Double interest(Double value, Integer month);

}
