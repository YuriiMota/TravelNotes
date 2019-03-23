package controller;

import dao.PlaceDAO;
import entity.Place;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.PlaceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static controller.UploadPicServlet.MEMORY_THRESHOLD;

@WebServlet("/edit")
@MultipartConfig
public class EditServlet extends HttpServlet {
    private final static String UPLOAD_DIRECTORY = ("/resources/image/");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Place places;
        PlaceDAO placeDAO = new PlaceService();
        try {
            int id = 0;
            String title = null;
            String country = null;
            String description = null;
            String image = null;
            if (!ServletFileUpload.isMultipartContent(request)) {

                return;
            }
            FileItemFactory itemfactory = new DiskFileItemFactory();
            ((DiskFileItemFactory) itemfactory).setSizeThreshold(MEMORY_THRESHOLD);
            ServletFileUpload upload = new ServletFileUpload(itemfactory);

            try {
                List<FileItem> items = upload.parseRequest(request);
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()) {
                        if (item.getFieldName().equals("id")) {
                            id = Integer.parseInt(item.getString());
                        } else if (item.getFieldName().equals("title")) {
                            title = item.getString();
                        } else if (item.getFieldName().equals("country")) {
                            country = item.getString();
                        } else if (item.getFieldName().equals("description")) {
                            description = item.getString();
                        }
                    } else {
                        if (item.getSize() > 1) {
                            image = processUploadedFile(item);
                        }
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            try {
                places = placeDAO.getById(id);
                places.setTitle(title);
                places.setDescription(description);
                places.setCountry(country);
                if (image != null) {
                    places.setImage(image);
                }
                System.out.println(places);
                placeDAO.update(places);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(5000);
            response.sendRedirect(request.getContextPath() + "/view?id=" + id);

        } catch (Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("id") == null) {
            response.sendRedirect("/login");
        } else {
            PlaceDAO placeDAO = new PlaceService();
            Place places = placeDAO.getById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("place", places);

            getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
        }
    }

    private String processUploadedFile(FileItem item) throws Exception {
        File uploadFile = null;
        String way = null;
        //выбираем файлу имя пока не найдём свободное
        System.out.println("Name=" + item.getName());

        do {
            way = UPLOAD_DIRECTORY + "img" + new Random().nextInt() + item.getName();
            System.out.println(way);
            String path = getServletContext().getRealPath(way);
            System.out.println(path);
            uploadFile = new File(path);
        } while (uploadFile.exists());
        item.write(uploadFile);

        return way;
    }
}
