package controller;

import dao.PlaceDAO;
import entity.Account;
import entity.Place;
import service.PlaceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/create")
public class CreateNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlaceDAO placeDAO = new PlaceService();

        try {
            String title = request.getParameter("title");
            String country = request.getParameter("country");
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            HttpSession httpSession=request.getSession();
            Account account = (Account)httpSession.getAttribute("id");
            //if (image.isEmpty()){
            //    placeDAO.insert(new Place(title,country,description),account.getId());
            //}else{
                placeDAO.insert(new Place(title,country,description,image),account.getId());
            //}

            response.sendRedirect(request.getContextPath()+"/mynotes");

        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }
}
