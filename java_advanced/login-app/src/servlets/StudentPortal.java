package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbConnection.DBConnection;
import entity.User;

public class StudentPortal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentPortal() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        User user = getUserByEmail(email);       
        try {
        	writer.println("<h1>Welcome To Student Portal</h1></br>"); 	
            writer.println("<h2>Name: " + user.getUserName() + "</br> Email: " + user.getEmail() + "</br>"
            		+ "Role: " + user.getRole() +"</h2>");
        	writer.println("<form action = \"StudentPortal\" method = \"post\"><br /><br />");
            writer.println("<input type = \"submit\" value = \"Logout\" />");
            writer.println("</form>");
        } finally {
            writer.close();  
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("email");
		session.removeAttribute("password");
		String path = request.getContextPath() + "/Login.html";
        response.sendRedirect(path);
	}
	
	private User getUserByEmail(String email) {
		User user = new User();
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from users where email = ?")) {
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				user.setUserName(rs.getString("username"));
				user.setEmail(email);
				user.setRole("role");
			}
		} catch (SQLException e) {
			DBConnection.printSQLException(e);
		}
		return user;
	}

}
