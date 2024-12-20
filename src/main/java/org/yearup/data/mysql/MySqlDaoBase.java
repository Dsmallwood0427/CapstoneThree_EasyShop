package org.yearup.data.mysql;


import org.yearup.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class MySqlDaoBase {
    private final DataSource dataSource;

    // Constructor injection ensures DataSource dependency is provided
    public MySqlDaoBase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Provide a connection to the database
    protected Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Utility method to safely close resources
    protected void close(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Exception e) {
                // Log the exception if logging is set up
                System.err.println("Error closing resource: " + e.getMessage());
            }
        }
    }

    // Utility method to handle transactions if needed
    protected void handleTransaction(Connection connection, boolean commit) {
        if (connection != null) {
            try {
                if (commit) {
                    connection.commit();
                } else {
                    connection.rollback();
                }
            } catch (SQLException e) {
                System.err.println("Error handling transaction: " + e.getMessage());
            }
        }
    }

    public abstract void update(int id, User user);
}
