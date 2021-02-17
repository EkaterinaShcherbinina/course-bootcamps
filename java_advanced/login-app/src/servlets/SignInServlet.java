package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnection.DBConnection;

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignInServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");

		if (checkUser(email, password)) {
			printResponse(response, "You was logged successfully");
		} else
			printResponse(response, "Invalid email or password");
	}

	private boolean checkUser(String email, String password) {
		boolean res = false;
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection
						.prepareStatement("select from users where email = ? and password = ?")) {
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			res = rs.next();

		} catch (SQLException e) {
			DBConnection.printSQLException(e);
		}
		return res;
	}

	private void printResponse(HttpServletResponse response, String message) {
		try (PrintWriter writer = response.getWriter()) {
			writer.println("<p><span style=\"color:red\">" + message + "</span></p>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
