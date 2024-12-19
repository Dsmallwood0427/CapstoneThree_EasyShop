package org.yearup.data;

import org.yearup.models.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartDao {
    void addProduct(ShoppingCartItem item);
    void updateProduct(ShoppingCartItem item);
    void clearCart();
    List<ShoppingCartItem> getAllProducts(); // Optional, for testing
}