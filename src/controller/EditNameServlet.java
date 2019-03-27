package controller;

import dao.UserDAO;
import entity.Account;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editname")
public class EditNameServlet extends HttpServlet {
    HttpSession httpSession;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserService();
        User user;

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            user = new User(id, firstName, lastName);
            userDAO.update(user);
            response.sendRedirect(request.getContextPath() + "/mynotes");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/editname.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        httpSession = request.getSession();
        if (httpSession.getAttribute("id") == null) {
            response.sendRedirect("/login");
        } else {
            UserDAO userDAO = new UserService();
            User user;
            httpSession = request.getSession();
            Account account = (Account) httpSession.getAttribute("id");
            user = userDAO.getById(account.getId());
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/editname.jsp").forward(request, response);
        }
    }
}
