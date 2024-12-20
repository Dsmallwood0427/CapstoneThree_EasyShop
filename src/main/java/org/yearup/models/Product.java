package org.yearup.models;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Product extends Category {
    private int productId;

    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    private String name;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be non-negative")
    private BigDecimal price;

    @Min(value = 0, message = "Category ID must be non-negative")
    private int categoryId;

    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    private String color;

    @Min(value = 0, message = "Stock must be non-negative")
    private int stock;

    private boolean isFeatured;
    private String imageUrl;

    public Product() {
        this.stock = 0;
        this.price = BigDecimal.ZERO;
        this.isFeatured = false;
    }

    public Product(int productId, String name, BigDecimal price, int categoryId, String description, String color, int stock, boolean isFeatured, String imageUrl) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
        this.color = color;
        this.stock = stock;
        this.isFeatured = isFeatured;
        this.imageUrl = imageUrl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryId=" + categoryId +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", stock=" + stock +
                ", isFeatured=" + isFeatured +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int anInt) {
        this.productId = anInt;
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return  color;
    }

    public int getStock() {
        return stock;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public String getImageUrl() {
        return  imageUrl;
    }

    public void setImageUrl(String image) {

    }

    public void setFeatured(boolean b) {
    }

    public void setStock(int i) {
    }

    public void setColor(String black) {
    }

    public void setPrice(BigDecimal bigDecimal) {
    }
}