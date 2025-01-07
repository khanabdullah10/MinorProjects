package src.onlineShoppingPlatform;

/***
 * The Product class represents an item available for purchase in the online shopping platform.
 * It contains details such as type, name, price, product ID, and description of the product.
 */
public class Product {
    private String type;        // Type of the product (e.g., Electronic, Clothes)
    private String name;        // Name of the product
    private double price;       // Price of the product
    private String productId;   // Unique identifier for the product
    private String description;  // Description of the product
    private int quantity;
    /***
     * Constructs a new Product with the specified details.
     */
    public Product(String pType, String name, double price, String productId, String description) {
        this.type = pType;
        this.name = name;
        this.price = price;
        this.productId = productId;
        this.description = description;
    }

    /***
     * Retrieves the name of the product.
     */
    public String getName() {
        return name;
    }

    /***
     * Retrieves the price of the product.
     */
    public double getPrice() {
        return price;
    }

    /***
     * Retrieves the unique identifier for the product.

     */
    public String getProductId() {
        return productId;
    }

    /***
     * Retrieves the type of the product.

     */
    public String getType() {
        return type;
    }

    /***
     * Returns a string representation of the product, including type, name, price, product ID, and description.

     */
    @Override
    public String toString() {
        return "Type: " + type + " " + name + " " + price + "₹/- " + productId + " " + description;
    }

    public int getQuantity() {
        return quantity;
    }
}
