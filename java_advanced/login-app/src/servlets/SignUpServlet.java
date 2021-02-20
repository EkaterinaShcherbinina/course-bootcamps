package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnection.DBConnection;
import entity.User;
import utils.Utils;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/Register.html");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(request.getParameter("uname"), request.getParameter("password"),
				request.getParameter("email"), request.getParameter("sq"), request.getParameter("sa"));

		if (isUserExist(user)) {
			Utils.printResponseMessage(response, "User is already exist");
		} else {
			if (addNewUser(user))
				Utils.printResponseMessage(response, "User is successfully added");
			else
				Utils.printResponseMessage(response, "Something was wrong. Please try again!");
		}
	}

	private boolean addNewUser(User user) {
		boolean result = false;
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users"
						+ " (username, email, password, sequrityquest, sequrityans) VALUES " + "(?, ?, ?, ?, ?);")) {
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getSeqQuestion());
			preparedStatement.setString(5, user.getSeqAnswer());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			DBConnection.printSQLException(e);
		}
		return result;
	}

	private boolean isUserExist(User user) {
		boolean status = false;
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from users where email = ?")) {
			preparedStatement.setString(1, user.getUserName());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			DBConnection.printSQLException(e);
		}
		return status;
	}
}
