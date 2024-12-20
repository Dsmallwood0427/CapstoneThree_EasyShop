package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;
import org.yearup.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {

    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Category category = mapRow(resultSet);
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public Category getById(int categoryId) {
        String query = "SELECT * FROM categories WHERE category_id = ?";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, categoryId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapRow(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category create(Category category) {
        String query = "INSERT INTO categories (name, description) VALUES (?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());

            int rows = preparedStatement.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Insert failed, no rows affected!");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    category.setCategoryId(generatedId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }

    @Override
    public void update(int categoryId, Category category) {
        String query = "UPDATE categories SET name = ?, description = ? WHERE category_id = ?";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setInt(3, categoryId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int categoryId) {
        String query = "DELETE FROM categories WHERE category_id = ?";

        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, categoryId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Category mapRow(ResultSet row) throws SQLException {
        Category category = new Category();
        category.setCategoryId(row.getInt("category_id"));
        category.setName(row.getString("name"));
        category.setDescription(row.getString("description"));
        return category;
    }
}
