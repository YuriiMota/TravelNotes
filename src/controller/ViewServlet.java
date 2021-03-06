package controller;

import dao.PlaceDAO;
import entity.Place;
import service.PlaceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/view")
@MultipartConfig
public class ViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("id") == null) {
            response.sendRedirect("/login");
        } else {
            PlaceDAO placeDAO = new PlaceService();
            Place places = placeDAO.getById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("place", places);
            getServletContext().getRequestDispatcher("/view.jsp")
                    .forward(request, response);
        }
    }
}
