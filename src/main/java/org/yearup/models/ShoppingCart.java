package org.yearup.models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Integer, ShoppingCartItem> items = new HashMap<>();

    // Get all items in the cart
    public Map<Integer, ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, ShoppingCartItem> items) {
        this.items = items;
    }

    // Check if the cart contains a specific product
    public boolean contains(int productId) {
        return items.containsKey(productId);
    }

    // Add an item to the cart
    public void add(ShoppingCartItem item) {
        if (contains(item.getProductId())) {
            // If the product is already in the cart, update the quantity
            ShoppingCartItem existingItem = items.get(item.getProductId());
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(item.getProductId(), item);
        }
    }

    // Get an item by productId
    public ShoppingCartItem get(int productId) {
        return items.get(productId);
    }

    // Update the quantity of an item in the cart
    public void updateQuantity(int productId, int newQuantity) {
        if (contains(productId)) {
            ShoppingCartItem item = items.get(productId);
            item.setQuantity(newQuantity);
        } else {
            throw new IllegalArgumentException("Product not found in the cart.");
        }
    }

    // Remove an item from the cart
    public void remove(int productId) {
        if (contains(productId)) {
            items.remove(productId);
        } else {
            throw new IllegalArgumentException("Product not found in the cart.");
        }
    }

    // Clear all items from the cart
    public void clear() {
        items.clear();
    }

    // Calculate the total price of all items in the cart
    public BigDecimal getTotal() {
        return items.values()
                .stream()
                .map(ShoppingCartItem::getLineTotal) // Multiply price by quantity
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
