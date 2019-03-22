package controller;

import dao.PlaceDAO;
import dao.UserDAO;
import entity.Account;
import entity.Place;
import entity.User;
import service.PlaceService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mynotes")
public class MyNotesServlet extends HttpServlet {
    HttpSession httpSession;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        httpSession = request.getSession();
        if(httpSession.getAttribute("id")==null){
            response.sendRedirect("/login");
        }else {
            PlaceDAO placeDAO = new PlaceService();
            UserDAO userDAO = new UserService();
            List<Place> places;

            httpSession = request.getSession();
            Account account = (Account) httpSession.getAttribute("id");
            places = placeDAO.getAll(account.getId());
            request.setAttribute("places", places);


            User user = userDAO.getById(account.getId());
            request.setAttribute("userName", user);
            getServletContext().getRequestDispatcher("/mynotes.jsp").forward(request, response);
        }
    }
}
