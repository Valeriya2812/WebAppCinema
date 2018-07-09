package controllers;


import dto.UserDTO;
import model.Role;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserDTO userDTO = UserServiceImpl.getInstance().getByLogin(login);



        if(userDTO != null && userDTO.getPassword().equals(password)){
       // if(password.equals("1234")){
      request.getSession().setAttribute("user", userDTO);
      //response.sendRedirect(request.getSession().getAttribute("url").toString());
            if(userDTO.getRole().name().compareTo("ADMIN")==0) {
                response.sendRedirect(request.getContextPath() + "/admin/adminaccount.jsp");

            }else{
                request.getRequestDispatcher("/allUsers/myaccount").forward(request, response);

            }}else{
            response.sendRedirect(request.getContextPath() + "/allUsers/login.jsp");
         //request.getSession().setAttribute("message", "Wrong users name or password");
         //  response.sendRedirect(request.getContextPath() + "/index.jsp");
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
