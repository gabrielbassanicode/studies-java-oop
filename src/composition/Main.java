package composition;
import java.time.LocalDateTime;

public class Main {


    public static void main(String[] args) {

        // Hardcode

        Client client = new Client("Michael Johnson", "+1 555 284 7391");
        String carName = "Toyota Corolla";
        double serviceValue = 850.00;
        LocalDateTime moment = LocalDateTime.now();

        Part part = new Part("Front Door", 650.00, 2);
        Part part1 = new Part("Front Seat", 400.00, 1);
        Status status = Status.WORKING;

        Quote quote = new Quote(client, status, moment, carName, serviceValue);
        quote.addPart(part);
        quote.addPart(part1);
        System.out.println(quote);

    }
}
