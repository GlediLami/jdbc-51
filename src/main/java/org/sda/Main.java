package org.sda;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/sda";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected succesfully!");

        Statement statement = connection.createStatement();

        //int affectedRows = statement.executeUpdate("UPDATE students set department = 'Math' WHERE student_name = 'Gledis'");
        //int affectedRows = statement.executeUpdate("insert into students values ('Sergio', 'IT');");
        int affectedRows = statement.executeUpdate("delete from students where department = 'Math'");

        System.out.println("Rows affected from update operation: "  + affectedRows);

        ResultSet rs = statement.executeQuery("SELECT * FROM students");

        // [ResultSetElement: {student_name = "Gledis", department = "IT"}, ResultSetElement: {"Ben", } ]

        while (rs.next()){
           String name = rs.getString("student_name");
           String department = rs.getString("department");
           System.out.println("Student name: " + name + ", department: " + department);
        }
    }
}