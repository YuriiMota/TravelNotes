package controller;

import dao.PlaceDAO;
import service.PlaceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PlaceDAO placeDAO = new PlaceService();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            placeDAO.delete(id);
            response.sendRedirect(request.getContextPath() + "/mynotes");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/mynotes").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("id") == null) {
            response.sendRedirect("/login");
        }
    }
}
