package controller;

import dao.PlaceDAO;
import entity.Place;
import service.PlaceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Place places;
        PlaceDAO placeDAO= new PlaceService();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String country = request.getParameter("country");
            String description = request.getParameter("description");
            String image = request.getParameter("image");
           places=new Place(id,title,country,description,image);

            placeDAO.update(places);
            response.sendRedirect(request.getContextPath()+"/mynotes");

        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlaceDAO placeDAO= new PlaceService();
        Place places=placeDAO.getById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("place", places);

        getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
    }
}
