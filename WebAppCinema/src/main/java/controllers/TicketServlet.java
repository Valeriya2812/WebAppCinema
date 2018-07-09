package controllers;


import dto.PlaceDTO;
import dto.UserDTO;
import mapper.BeanMapper;
import model.User;
import service.impl.PlaceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TicketServlet", urlPatterns={"/ticket"})
public class TicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlaceDTO placeDTO= PlaceServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));

        UserDTO userDTO= (UserDTO) request.getSession().getAttribute("user");

        request.getSession().setAttribute("userDTO", userDTO);
        request.getSession().setAttribute("place", placeDTO);
        request.getRequestDispatcher("/allUsers/ticket.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}



