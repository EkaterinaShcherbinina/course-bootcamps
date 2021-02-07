package com.shcherbinina.servlets;

import com.shcherbinina.entity.User;
import com.shcherbinina.validation.UserValidation;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(email, password);
        if (UserValidation.validate(user)) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/servlet_project/login-success.jsp");
        }
        else {
            req.setAttribute("error", "Unknown user, please try again");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
