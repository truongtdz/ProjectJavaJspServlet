
package controller;

import dao.BookDAO;
import dao.CartDAO;
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

public class SelectBuyOrDelete extends HttpServlet {

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
        processRequest(request, response);
        String[] listBook = request.getParameterValues("listbook");
        String select = request.getParameter("select");
        String where = "Where";
        if (listBook != null && listBook.length > 0) {
            String idBookList = String.join("','", listBook);
            where += " id_book IN ('" + idBookList + "') ";
        }
        if(select.equals("1")){
            CartDAO.SelectBuy(where);
        } else CartDAO.DeleteCart(where);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        ArrayList<Book> books = BookDAO.bookList();
        request.setAttribute("books", books);
        RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
        dis.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
