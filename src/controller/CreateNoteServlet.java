package controller;

import dao.PlaceDAO;
import entity.Account;
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
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@WebServlet("/create")
@MultipartConfig
public class CreateNoteServlet extends HttpServlet {
    public static final int MEMORY_THRESHOLD = 1024 * 1024 * 10; //10MB
    private final static String UPLOAD_DIRECTORY = ("/resources/image/");
    HttpSession httpSession;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlaceDAO placeDAO = new PlaceService();

        try {
            String title = null;
            String country = null;
            String description = null;
            String image = null;
            if (!ServletFileUpload.isMultipartContent(request)) {
                return;
            }
            FileItemFactory itemFactory = new DiskFileItemFactory();
            ((DiskFileItemFactory) itemFactory).setSizeThreshold(MEMORY_THRESHOLD);
            ServletFileUpload upload = new ServletFileUpload(itemFactory);

            try {
                List<FileItem> items = upload.parseRequest(request);
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()) {
                        if (item.getFieldName().equals("title")) {
                            title = item.getString();
                        } else if (item.getFieldName().equals("country")) {
                            country = item.getString();
                        } else if (item.getFieldName().equals("description")) {
                            description = item.getString();
                        }
                    } else {
                        image = processUploadedFile(item);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            httpSession = request.getSession();
            Account account = (Account) httpSession.getAttribute("id");
            placeDAO.insert(new Place(title, country, description, image), account.getId());
            Thread.sleep(5000);
            response.sendRedirect(request.getContextPath() + "/mynotes");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        httpSession = request.getSession();
        if (httpSession.getAttribute("id") == null) {
            response.sendRedirect("/login");
        } else {
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }

    private String processUploadedFile(FileItem item) throws Exception {
        File uploadFile = null;
        String way = null;

        if (!item.getName().isEmpty()) {
            do {
                way = UPLOAD_DIRECTORY + "img" + new Random().nextInt() + item.getName();
                String path = getServletContext().getRealPath(way);
                uploadFile = new File(path);
            } while (uploadFile.exists());
            item.write(uploadFile);
        } else {
            way = "resources/image/no-photo-available.jpg";
        }
        return way;
    }
}
