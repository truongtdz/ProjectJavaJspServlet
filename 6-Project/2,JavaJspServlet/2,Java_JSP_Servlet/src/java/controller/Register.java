package controller;

import dao.UserDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher dis = request.getRequestDispatcher("register.jsp");
        dis.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        String confirmPassWord = request.getParameter("confirmPassword");
        boolean isValid = true;
        String message = null;
        if(!passWord.equals(confirmPassWord)){
            message = "Mat Khau Khong Trung";
            isValid = false;
        }
        boolean isExistUser = UserDAO.isExistUserName(userName);
        if(isExistUser){
            message = "Tai Khoan Da Ton Tai";
            isValid = false;
        }
        if(!isValid){
            request.setAttribute("okmessage", message);
            RequestDispatcher dis = request.getRequestDispatcher("register.jsp");
            dis.forward(request, response);
        } else {
            User user = new User(userName, passWord);
            if(UserDAO.InsertUser(user)){
                message = "Thanh Cong";
            }
            request.setAttribute("okmessage", message);
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
