package controllers;


import dao.impl.UserDaoImpl;
import dto.UserDTO;
import model.Role;
import model.User;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewAccountServlet", urlPatterns={"/newaccount"})
public class NewAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int age =Integer.parseInt(request.getParameter("age"));
        boolean f= false;
    try {
        UserDTO user = UserServiceImpl.getInstance().getByLogin(login);
    }catch(Exception e)
    {
        f=true;
    }
    if(f==true) {
        UserDTO userDTO = new UserDTO(name, surname, email, login, password, Role.VISITOR, age);
        UserServiceImpl.getInstance().save(userDTO);
        request.getSession().setAttribute("user", userDTO);
        response.sendRedirect(request.getContextPath() + "/allUsers/myaccount.jsp");
    }
    else {
        String warn = new String("please, choose another login");
        request.setAttribute("warn", warn);
        response.sendRedirect(request.getContextPath() + "/allUsers/createaccount.jsp");
    }





    }
}