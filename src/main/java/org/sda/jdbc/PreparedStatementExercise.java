package org.sda.jdbc;

import java.sql.*;

public class PreparedStatementExercise {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sda";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected succesfully!");

        PreparedStatement pstm = connection
                .prepareStatement("DELETE FROM USERS WHERE ID = ?");
        pstm.setInt(1, 1);
        pstm.executeUpdate();

    }
}
