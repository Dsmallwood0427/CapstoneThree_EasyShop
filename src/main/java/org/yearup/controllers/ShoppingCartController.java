package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.ShoppingCartItem;

import java.util.List;

//@RestController
//@RequestMapping("cart")
//@CrossOrigin
public class ShoppingCartController {

   // private final ShoppingCartDao shoppingCartDao;

//    @Autowired
//    public ShoppingCartController(ShoppingCartDao shoppingCartDao) {
//        this.shoppingCartDao = shoppingCartDao;
//    }

    // Add a product to the cart
    @PostMapping("products/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductToCart(@PathVariable int productId, @RequestBody ShoppingCartItem item) {
        try {
         //   item.setProductId(productId);

          //  shoppingCartDao.addProduct(item);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to add product to the cart.");
        }
    }

    // Update the quantity of an existing product in the cart
    @PutMapping("products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProductInCart(@PathVariable int productId, @RequestBody ShoppingCartItem item) {
        try {
         //  item.setProductId(productId);
         //   shoppingCartDao.updateProduct(item);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update product in the cart.");
        }
    }

    // Clear all products from the cart
    @DeleteMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCart() {
        try {
         //   shoppingCartDao.clearCart();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to clear the cart.");
        }
    }

    // Optional: Get all products in the cart (if needed for testing)
    @GetMapping("")
    public List<ShoppingCartItem> getCartItems() {
    //    return shoppingCartDao.getAllProducts();
        return null;
    }
}
    // add a POST method to add a product to the cart - the url should be
    // https://localhost:8080/cart/products/15 (15 is the productId to be added


    // add a PUT method to update an existing product in the cart - the url should be
    // https://localhost:8080/cart/products/15 (15 is the productId to be updated)
    // the BODY should be a ShoppingCartItem - quantity is the only value that will be updated


    // add a DELETE method to clear all products from the current users cart
    // https://localhost:8080/cart


