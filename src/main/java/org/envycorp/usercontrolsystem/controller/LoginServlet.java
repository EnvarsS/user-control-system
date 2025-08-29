package org.envycorp.usercontrolsystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.envycorp.usercontrolsystem.enums.Positions;
import org.envycorp.usercontrolsystem.model.User;
import org.envycorp.usercontrolsystem.storage_util.InMemoryRepository;

import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User loggingInUser = InMemoryRepository.getInstance().isUserAuthenticated(email, password);
        if(loggingInUser == null) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        req.getSession().setAttribute("user", loggingInUser);

        if(loggingInUser.getPosition().equals(Positions.Admin.toString()))
            resp.sendRedirect("/users");
        else
            req.getRequestDispatcher("/user-profile.jsp").forward(req, resp);
    }
}
