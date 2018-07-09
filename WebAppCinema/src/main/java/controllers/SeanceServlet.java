package controllers;


import dto.PlaceDTO;
import dto.SeanceDTO;
import service.impl.PlaceServiceImpl;
import service.impl.SeanceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SeanceServlet", urlPatterns={"/seance"})
public class SeanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<PlaceDTO> placeDTOList = PlaceServiceImpl.getInstance().getBySeance(Integer.parseInt(request.getParameter("id")));
String hall=placeDTOList.get(0).getSeance().getHall().getColor().name();
int movie_id=placeDTOList.get(0).getSeance().getMovie().getId();

        request.setAttribute("hall", hall);
        request.setAttribute("movie_id", movie_id);

        request.setAttribute("placeDTOList", placeDTOList);
        request.getRequestDispatcher("/allUsers/seance.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}