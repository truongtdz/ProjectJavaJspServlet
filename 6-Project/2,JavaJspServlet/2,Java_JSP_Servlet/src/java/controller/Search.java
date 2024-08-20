package controller;

import dao.BookDAO;
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

public class Search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // Collect form parameters
        String[] subjects = request.getParameterValues("subjects");
        String classFrom = request.getParameter("classfrom");
        String classTo = request.getParameter("classto");

        // Build SQL WHERE clause
        String where = " WHERE 1 = 1";
        if (classFrom != null && !classFrom.isEmpty()) {
            where += " AND class >= " + classFrom;
        }
        if (classTo != null && !classTo.isEmpty()) {
            where += " AND class <= " + classTo;
        }
        if (subjects != null && subjects.length > 0) {
            String subjectCondition = String.join("','", subjects);
            where += " AND subject IN ('" + subjectCondition + "')";
        }

        // Query books
        ArrayList<Book> books = BookDAO.searchBook(where);

        // Set attributes and forward request
        request.setAttribute("user", user);
        request.setAttribute("books", books);
        RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
        dis.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
