package compositionOrder;

public class OrderItem {

    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem() {
    }

    public OrderItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.price = product.getPrice();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public Double subTotal() {
        return quantity * product.getPrice();

    }
}

