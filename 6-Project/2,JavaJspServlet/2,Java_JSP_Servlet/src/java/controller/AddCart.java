
package controller;

import dao.BookDAO;
import dao.OrderDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;
import model.Order;
import model.User;

public class AddCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Book> books = BookDAO.bookList();
        Book book = BookDAO.searchInforBook(request.getParameter("idbook"));
        if(user == null){
            response.sendRedirect("login.jsp");
        } else {
            Order order = new Order();
            order.setIdUser(user.getId_user());
            order.setIdBook(book.getId_book());
            order.setBookQuantity(1);
            order.setTotalPrice(book.getPrice());
            order.setDescribes("Add To Cart");
            order.setStatusBuy(0);
            String messageOrder = null;
            if(OrderDAO.InsertOrder(order)){
                messageOrder = "Add Success";
                request.setAttribute("messageOrder", messageOrder);
                request.setAttribute("books", books);
                request.setAttribute("user", user);
                RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
                dis.forward(request, response);
            } else{
                messageOrder = "Add Fail";
                request.setAttribute("messageOrder", messageOrder);
                request.setAttribute("books", books);
                request.setAttribute("user", user);
                RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
                dis.forward(request, response);
            }
            
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
