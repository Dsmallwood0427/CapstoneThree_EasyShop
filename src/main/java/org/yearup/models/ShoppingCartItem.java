package org.yearup.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class ShoppingCartItem {
    private Product product;
    private int quantity = 1;
    private BigDecimal discountPercent = BigDecimal.ZERO;

    // Default constructor
    public ShoppingCartItem() {
    }

    // Constructor to initialize with a product and quantity
    public ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Constructor to initialize with a product, quantity, and discount
    public ShoppingCartItem(Product product, int quantity, BigDecimal discountPercent) {
        this.product = product;
        this.quantity = quantity;
        this.discountPercent = discountPercent;
    }

    // Getter and Setter for Product
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Getter and Setter for Quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1.");
        }
        this.quantity = quantity;
    }

    // Getter and Setter for Discount Percent
    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        if (discountPercent.compareTo(BigDecimal.ZERO) < 0 || discountPercent.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("Discount percent must be between 0 and 1.");
        }
        this.discountPercent = discountPercent;
    }

    // Get Product ID (Derived from Product)
    @JsonIgnore
    public int getProductId() {
        return this.product != null ? this.product.getProductId() : 0;
    }

    // Calculate Line Total
    public BigDecimal getLineTotal() {
        if (product == null || product.getPrice() == null) {
            throw new IllegalStateException("Product or product price is missing.");
        }

        BigDecimal basePrice = product.getPrice();
        BigDecimal quantityDecimal = new BigDecimal(this.quantity);

        BigDecimal subTotal = basePrice.multiply(quantityDecimal); // Price * Quantity
        BigDecimal discountAmount = subTotal.multiply(discountPercent); // Discount Amount

        return subTotal.subtract(discountAmount); // Subtract Discount
    }
}