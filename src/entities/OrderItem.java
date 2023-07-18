package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    //Criação do objeto produto
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
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

    public void setProduct(Product product) {
        this.product = product;
    }
    public Double subTotal(){
        price = product.getPrice() * quantity;
        return price;
    }

    /*@Override
    public String toString() {
        return getProduct().getName() + ", " +
                "$" + String.format("%.2f", price) + ", " +
                "Quantity: " +
                quantity + ", " +
                "Subtotal: " + "$" +
                String.format("%.2f", subTotal()) + "\n";
    }*/
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getProduct().getName() + ", ");
        sb.append("$");
        sb.append(String.format("%.2f", price) + ", ");
        sb.append("Quantity: ");
        sb.append(quantity + ", ");
        sb.append("Subtotal: $");
        sb.append(String.format("%.2f", subTotal()) + "\n");

        return sb.toString();
    }
}
