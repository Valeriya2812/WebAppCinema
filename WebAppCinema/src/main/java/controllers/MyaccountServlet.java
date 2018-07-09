package controllers;


import dto.PlaceDTO;
import dto.UserDTO;
import service.impl.PlaceServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyaccountServlet", urlPatterns={"/myaccount"})
public class MyaccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO userDTO= (UserDTO) request.getSession().getAttribute("user");
        List<PlaceDTO> placeDTOList = PlaceServiceImpl.getInstance().getByUser(userDTO.getId());

        request.setAttribute("placeDTOList", placeDTOList);
        request.getRequestDispatcher("/allUsers/myaccount.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
