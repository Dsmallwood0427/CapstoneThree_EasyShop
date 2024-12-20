package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {
    private final List<Category> categories = new ArrayList<>();
    private int nextId = 1;

    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categories.stream()
                .filter(category -> category.getCategoryId() == categoryId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product getById(int categoryId) {
        return null;
    }

    @Override
    public Category create(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
        return category;
    }

    @Override
    public void update(int categoryId, Category category) {
        Optional<Category> existing = categories.stream()
                .filter(cat -> cat.getCategoryId() == categoryId)
                .findFirst();

        existing.ifPresent(cat -> {
            cat.setName(category.getName());
            cat.setDescription(category.getDescription());
        });
    }

    @Override
    public void delete(int categoryId) {
        categories.removeIf(category -> category.getCategoryId() == categoryId);
    }
}
