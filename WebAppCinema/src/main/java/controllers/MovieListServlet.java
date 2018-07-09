package controllers;


import dto.MovieDTO;
import dto.SeanceDTO;
import service.impl.MovieServiceImpl;
import service.impl.SeanceServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

@WebServlet(name = "MovieListServlet", urlPatterns={"/movies"})
public class MovieListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<MovieDTO> movieDTOList = MovieServiceImpl.getInstance().getAll();
        List<SeanceDTO> seanceDTOList = SeanceServiceImpl.getInstance().getAll();
        Calendar c= Calendar.getInstance();

        int year=c.get(c.YEAR);
        int month=c.get(c.MONTH)+1;
        int day=c.get(c.DAY_OF_MONTH);
        String d=new String(year+"-"+month+"-"+day);

        List<SeanceDTO> selectedSeances= new ArrayList<>();


        for (SeanceDTO sd : seanceDTOList)
            if(sd.getSeanceDate().toString().equals(d))
                selectedSeances.add(sd);


        request.setAttribute("selectedSeances", selectedSeances);
        request.setAttribute("movieDTOList", movieDTOList);
        //request.setAttribute("movieDTOList", movieDTOList);
        request.getRequestDispatcher("/allUsers/nowplaying.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
