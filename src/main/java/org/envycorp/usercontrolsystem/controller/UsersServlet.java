package org.envycorp.usercontrolsystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.envycorp.usercontrolsystem.enums.Positions;
import org.envycorp.usercontrolsystem.model.User;
import org.envycorp.usercontrolsystem.storage_util.InMemoryRepository;

import java.io.IOException;

@WebServlet(value = "/users/*")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("positions", Positions.values());

        session.setAttribute("users", InMemoryRepository.getInstance().getAllUsers());

        req.getRequestDispatcher("/admin-dashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = req.getPathInfo();
        switch (path) {
            case "/create-form" -> resp.sendRedirect("/user-form.jsp?action=create");
            case "/edit-form" -> {
                session.setAttribute("editingUser", InMemoryRepository.getInstance().getUserById(Integer.parseInt(req.getParameter("id"))));
                resp.sendRedirect("/user-form.jsp?action=edit");
            }
            case "/create" -> {
                User newUser = new User(
                        req.getParameter("firstName"),
                        req.getParameter("surname"),
                        req.getParameter("position"),
                        req.getParameter("email"),
                        req.getParameter("password")
                );
                InMemoryRepository.getInstance().addUser(newUser);
                resp.sendRedirect("/users");
            }
            case "/edit" -> {
                User editingUser = InMemoryRepository.getInstance().getUserById(Integer.parseInt(req.getParameter("id")));
                if (editingUser != null) {
                    editingUser.changeUserParams(
                            req.getParameter("firstName"),
                            req.getParameter("surname"),
                            req.getParameter("position"),
                            req.getParameter("email"),
                            req.getParameter("password")
                    );
                }
                resp.sendRedirect("/users");
            }
            case "/delete" -> {
                InMemoryRepository.getInstance().deleteUserById(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("/users");
            }
            case "/logout" -> {
                session.invalidate();
                resp.sendRedirect("/login.jsp");
            }
        }
    }
}
