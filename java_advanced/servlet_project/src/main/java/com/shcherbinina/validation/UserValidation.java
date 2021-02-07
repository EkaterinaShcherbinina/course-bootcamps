package com.shcherbinina.validation;

import com.shcherbinina.entity.User;

import java.io.FileNotFoundException;
import java.sql.*;

public class UserValidation {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/login_app?useSSL=false";
    private static final String USER = "postgres";
    private static final String PASSWORD = "5533";
    private static final String DB_DRIBER = "org.postgresql.Driver";

    public static boolean validate(User user) throws FileNotFoundException {
        boolean status = false;
        try {
            Class.forName(DB_DRIBER);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        try (Connection connection = DriverManager
                .getConnection(DB_URL, USER, PASSWORD);

             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from users where email = ? and password = ? ")) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }

    private static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
