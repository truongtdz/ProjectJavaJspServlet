package controller;

import dao.BookDAO;
import dao.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;
import model.User;

public class UpdateUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher dis = request.getRequestDispatcher("updateuser.jsp");
        dis.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String firstName = (String) request.getParameter("firstname");
        String lastName = (String) request.getParameter("lastname");
        UserDAO.UpdateUser(user.getUserName(), firstName, lastName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        ArrayList<Book> books = BookDAO.bookList();
        request.setAttribute("user", user);
        request.setAttribute("books", books);
        RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
        dis.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
