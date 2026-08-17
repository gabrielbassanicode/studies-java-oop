package composition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Quote {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private Double serviceValue;
    private String carName;
    private LocalDateTime moment;
    private Status status;

    private Client client;
    private List<Part> parts = new ArrayList<>();

    public Quote() {
    }

    public Quote(Client client, Status status, LocalDateTime moment, String carName, Double serviceValue) {
        this.client = client;
        this.status = status;
        this.moment = moment;
        this.carName = carName;
        this.serviceValue = serviceValue;
    }

    public Double getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(Double serviceValue) {
        this.serviceValue = serviceValue;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void addPart(Part part) {
        parts.add(part);

    }
    public void removePart(Part part) {
        parts.remove(part);

    }

    public Double total() {
        double sum = serviceValue;

        for (Part p: parts) {
            sum += p.subTotal();

        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Car: ").append(carName).append("\n");
        sb.append("Service value: ").append(String.format("%.2f", serviceValue)).append("\n");
        sb.append("Moment: " ).append(moment.format(fmt)).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("Client: ").append(client.getName()).append(" ").append(client.getPhoneNumber()).append( "\n");
        sb.append("Parts: " + "\n");

        for (Part p: parts) {
            sb.append(p.getName()).append(", ").append("price: ").append(String.format("%.2f", p.getPrice())).append(" ").append("Sub Total: ")
                    .append(String.format("%.2f", p.subTotal())).append(" | ").append(p.getQuantity()).append( "\n");

        }
        sb.append("Total: ").append(String.format("%.2f", total()));

        return sb.toString();
    }
}
