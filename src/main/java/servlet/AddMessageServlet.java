package servlet;

import model.MessageServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddMessageServlet", urlPatterns = {"/add-message"})
public class AddMessageServlet extends HttpServlet {


    public static final String MESSAGE_CONTENT = "content";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        MessageServices messageServices = (MessageServices) getServletContext().getAttribute("messageService");

        if (messageServices == null) {
            messageServices = new MessageServices();
            getServletContext().setAttribute("messageService", messageServices);
        }

        String content = req.getParameter(MESSAGE_CONTENT);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");

        if (content != null && content.length() > 0) {
            messageServices.addMessage(content);
        }

        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}

