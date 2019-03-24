package controller;

import dao.AccountDAO;

import service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private AccountDAO accountDAO = new AccountService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Md5Apache md5Apache = new Md5Apache();
        try {
            String email = request.getParameter("email");
            String psw = request.getParameter("password");
            psw = md5Apache.encryptText(psw);
            if (registeredLogin(email, psw)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("id", accountDAO.getByLogin(email, psw));

                response.sendRedirect("/mynotes");
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean registeredLogin(String login, String password) {
        boolean isRegistered = true;
        if (accountDAO.getByLogin(login, password) == null) {
            return false;
        } else {
            return isRegistered;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
        requestDispatcher.forward(request, response);
    }
}
