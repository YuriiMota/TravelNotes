package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/upload")

public class UploadPicServlet extends HttpServlet {
    private final static String UPLOAD_DIRECTORY = ("/resources/image/");
    public static final int MEMORY_THRESHOLD = 1024 * 1024 * 10; //10MB

    public static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
    public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!ServletFileUpload.isMultipartContent(request)) {

            return;
        }
        FileItemFactory itemfactory = new DiskFileItemFactory();
        ((DiskFileItemFactory) itemfactory).setSizeThreshold(MEMORY_THRESHOLD);
        ServletFileUpload upload = new ServletFileUpload(itemfactory);
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                File uploadDir = new File(getServletContext().getRealPath(UPLOAD_DIRECTORY));
                System.out.println(uploadDir);
                File file = File.createTempFile("img", ".jpg", uploadDir);
                item.write(file);
                request.setAttribute("message", "File has uploaded successfully!");
                String fileName = file.getName();
                String filePath = UPLOAD_DIRECTORY + fileName;
                System.out.println(fileName);
                System.out.println(filePath);
                request.setAttribute("uploadImage", filePath);
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            request.setAttribute("message", "There was an error: " + ex.getMessage());
        }

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);

       /* if (ServletFileUpload.isMultipartContent(request)) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);
            String uploadPath = UPLOAD_DIRECTORY ;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                List<FileItem> formItems = upload.parseRequest(request);

                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (!item.isFormField()) {
                            String fileName = new File(item.getName()).getName();
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            item.write(storeFile);
                            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
                        }
                    }
                }
            } catch (Exception ex) {
                request.setAttribute("message", "There was an error: " + ex.getMessage());
            }
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("id") == null) {
            response.sendRedirect("/login");
        } else {
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}
