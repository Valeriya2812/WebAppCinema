package controllers;


import dto.MovieDTO;

import service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewMovieServlet", urlPatterns={"/admin/newmovie"})
public class NewMovie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String director = request.getParameter(" director");
        String starring = request.getParameter("starring");
        int duration =Integer.parseInt(request.getParameter("duration"));
        int minAge =Integer.parseInt(request.getParameter("minAge"));
        MovieDTO movieDTO = new MovieDTO(title, description, duration, director, starring, minAge);
        MovieServiceImpl.getInstance().save(movieDTO);

      //  request.setAttribute("movieDTO", movieDTO);

        request.getRequestDispatcher("/admin/moviemanager").forward(request, response);
     //   response.sendRedirect(request.getContextPath() + "/admin/moviemanager");


}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
