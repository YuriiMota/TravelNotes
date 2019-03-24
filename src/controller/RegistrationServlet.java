package controller;

import dao.AccountDAO;
import dao.UserDAO;
import entity.Account;
import entity.User;
import service.AccountService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final int MAX_PASS_LENGTH = 7;
    private AccountDAO accountDAO = new AccountService();
    private UserDAO userDAO = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("registration.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Md5Apache md5Apache = new Md5Apache();
        try {
            String email = req.getParameter("email");
            String psw = req.getParameter("password");
            if (checkValidations(email, psw)) {
                psw = md5Apache.encryptText(psw);
                if (availableLogin(email)) {
                    Account account = new Account(email, psw);
                    accountDAO.insert(account);
                    userDAO.insert(new User("Unknown", "Person"), accountDAO.getByLogin(email).getId());
                    resp.sendRedirect(req.getContextPath() + "/login");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/registration");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/registration");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean availableLogin(String login) {
        boolean isAvailable = false;
        if (accountDAO.getByLogin(login) == null) {
            return true;
        } else {
            return isAvailable;
        }
    }

    private boolean checkValidations(String email, String password) {
        boolean iSValid = false;
        if ((email.length() > MAX_PASS_LENGTH) && (password.length() > MAX_PASS_LENGTH)) {
            iSValid = true;
        }
        return iSValid;
    }
}
