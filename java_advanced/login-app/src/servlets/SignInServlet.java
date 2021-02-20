package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbConnection.DBConnection;
import utils.Utils;

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignInServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/Login.html");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");

		if(email != null && password != null) {
			try {
				signIn(request, response, email, password);
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		} else if(email != null) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			String path = request.getContextPath() + "/ChallengePassword.html";
            response.sendRedirect(path);
		} else if(password != null) {
			HttpSession session = request.getSession();
			String emailSessionn = (String) session.getAttribute("email");
			try {
				signIn(request, response, emailSessionn, password);
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		} else {
			Utils.printResponseMessage(response, "Invalid email or password");
		}
	}

	private void signIn(HttpServletRequest request, HttpServletResponse response,
			String email, String password) throws IOException {
		if (checkUser(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			if (isAdminRole(email)) {
				String path = request.getContextPath() + "/Register.html";
	            response.sendRedirect(path);
			} else {
				String path = request.getContextPath() + "/StudentPortal";
	            response.sendRedirect(path);
			}
		} else
			Utils.printResponseMessage(response, "Invalid email or password");
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

	private boolean isAdminRole(String email) {
		boolean res = false;
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection
						.prepareStatement("select role from users where email = ?")) {
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String role = rs.getString("role");
				res = "admin".equals(role);
			}
		} catch (SQLException e) {
			DBConnection.printSQLException(e);
		}
		return res;
	}
}
