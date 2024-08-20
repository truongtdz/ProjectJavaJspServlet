package controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import dao.UserDAO;
import javax.servlet.http.HttpSession;
import utils.CheckString;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
        dis.forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            String userName = (String)request.getParameter("username");
            String passWord = (String)request.getParameter("password");               
            User user = UserDAO.getUser(userName, passWord);
            String message = null;
            boolean status = true;
            if(!CheckString.CheckString(userName) || !CheckString.CheckString(passWord)){
                message = "Nhap Day Du Thong Tin";
                status = false;
            }
            if(user == null) {
                message = "Dang Nhap That Bai";
                status = false;  
            }
            if(status){

                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("./home");
            } else {
                request.setAttribute("message", message);
                RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                dis.forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
