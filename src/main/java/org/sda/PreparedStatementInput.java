package org.sda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInput {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.next();

        System.out.println("Enter your email: ");
        String email = scanner.next();

        String url = "jdbc:mysql://localhost:3306/sda";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected succesfully!");

        String insertQuery = "INSERT INTO USERS(name, email) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        int affectedRows = preparedStatement.executeUpdate();
        System.out.println(affectedRows + " were inserted succesfully!");
    }
}
