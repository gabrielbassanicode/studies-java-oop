package compositionOrderConcept;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyy");
    private Instant moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();


    public Order() {
    }

    public Order(Instant moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);

    }
    public void removeItem(OrderItem item) {
        items.remove(item);

    }

    public Double total() {
        double sum = 0;

        for (OrderItem i: items) {
            sum += i.subTotal();

        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n");
        sb.append("Order moment: ");
        sb.append(moment.atZone(ZoneId.systemDefault()).format(fmt)).append("\n");

        sb.append("Order status: ").append(status).append("\n");
        sb.append("Client: ").append(client.getName()).append(" ").append(client.getBirthDay().format(fmt2)).append( " - ").append(client.getEmail());
        sb.append("\nOrder items: \n");

        for (OrderItem i: items) {
            sb.append(i.getProduct().getName()).append( ", ").append(i.getProduct().getPrice()).append(", ");
            sb.append("Quantity: ").append(i.getQuantity()).append(", ");
            sb.append("Subtotal: ").append(i.subTotal()).append("\n");

        }
        sb.append("Total price: ").append(total());
        return sb.toString();

    }
}
