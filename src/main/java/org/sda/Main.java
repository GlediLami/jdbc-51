package org.sda;

import java.sql.*;
import java.util.Arrays;

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
//        int affectedRows = statement.executeUpdate("delete from students where department = 'Math'");

//        System.out.println("Rows affected from update operation: "  + affectedRows);
//
//        statement.addBatch("insert into students values ('Adam', 'IT', 25), ('Gledis', 'IT', 25)");
//        statement.addBatch("insert into students values ('Tom', 'Physics', 30)");
        int[] result = statement.executeBatch();

        System.out.println("RESULT: " + Arrays.toString(result));



        String student = "'OR 1 = 1";
        // SELECT * FROM students where student_name = ''OR 1 = 1
        ResultSet rs = statement.executeQuery("SELECT * FROM students where student_name = '" + student +"");

        // [ResultSetElement: {student_name = "Gledis", department = "IT"}, ResultSetElement: {"Ben", } ]

        while (rs.next()){
           String name = rs.getString("student_name");
           String department = rs.getString("department");
           int age = rs.getInt("student_age");
           System.out.println("Student name: " + name + ", department: " + department + ", age: " + age);
        }

        connection.close();
        rs.close();
        statement.close();
    }
}