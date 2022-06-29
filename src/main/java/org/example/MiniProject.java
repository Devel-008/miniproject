package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class MiniProject {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

            Class.forName("org.postgresql.Driver");
           Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/students", "postgres", "isha@123");
            if(conn.isClosed())
            {
                System.out.println("NOT CONNECTED");
            }
        System.out.println("HELLO!!");
    }
    public void insert()
    {

    }
}
