package org.sda;

import java.sql.*;

public class PreparedStatementExercise {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sda";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected succesfully!");

        PreparedStatement pstm = connection
                .prepareStatement("INSERT INTO users(name,email) VALUES (?, ?)");
        pstm.setString(1, "Alice");
        pstm.setString(2, "alice@example.com");
        pstm.executeUpdate();

    }
}
