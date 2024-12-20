package org.yearup.data.mysql;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yearup.models.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MySqlProductDaoTest extends BaseDaoTestClass {

    private MySqlProductDao dao;

    @BeforeEach
    public void setup() {
        dao = new MySqlProductDao(dataSource);
    }

    @Test
    public void getById_shouldReturn_theCorrectProduct() {
        // Arrange
        int productId = 1;
        Product expected = new Product();
        expected.setProductId(1);
        expected.setName("Smartphone");
        expected.setPrice(new BigDecimal("499.99"));
        expected.setCategoryId(1);
        expected.setDescription("A powerful and feature-rich smartphone for all your communication needs.");
        expected.setColor("Black");
        expected.setStock(50);
        expected.setFeatured(false);
        expected.setImageUrl("smartphone.jpg");

        // Act
        Product actual = dao.getById(productId);

        // Assert
        assertNotNull(actual, "Expected a product to be returned, but got null.");
        assertEquals(expected.getProductId(), actual.getProductId(), "The product ID should match.");
        assertEquals(expected.getName(), actual.getName(), "The product name should match.");
        assertEquals(expected.getPrice(), actual.getPrice(), "The product price should match.");
        assertEquals(expected.getCategoryId(), actual.getCategoryId(), "The category ID should match.");
        assertEquals(expected.getDescription(), actual.getDescription(), "The description should match.");
        assertEquals(expected.getColor(), actual.getColor(), "The color should match.");
        assertEquals(expected.getStock(), actual.getStock(), "The stock value should match.");
        assertEquals(expected.isFeatured(), actual.isFeatured(), "The featured flag should match.");
        assertEquals(expected.getImageUrl(), actual.getImageUrl(), "The image URL should match.");
    }

}
