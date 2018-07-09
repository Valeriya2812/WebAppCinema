package controllers;


import dto.MovieDTO;
import dto.SeanceDTO;
import model.Movie;
import service.impl.MovieServiceImpl;
import service.impl.SeanceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "MovieManagerServlet", urlPatterns={"/admin/moviemanager"})
public class MovieManagerServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SeanceDTO> seanceDTOList= SeanceServiceImpl.getInstance().getAll();
        List<MovieDTO> movieDTOList= MovieServiceImpl.getInstance().getAll();
        List<SeanceDTO> selectedSeances=new ArrayList<>();

        List<MovieDTO> selectedMovies=new ArrayList<>();
        List<MovieDTO> restMovies=new ArrayList<>();
        Set<Date> dateSet=new TreeSet<>();

        Set<Integer> movieIdSet=new TreeSet<>();

        Calendar c= Calendar.getInstance();
        Calendar c1=Calendar.getInstance();



        Pattern pattern;
        Matcher matcher;
        String str;
        int year_s=0, month_s=0, day_s=0;
        for (SeanceDTO sd : seanceDTOList)
        {   str=sd.getSeanceDate().toString();
            pattern = Pattern.compile("(\\d+)(-)(\\d+)(-)(\\d+)");
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                matcher = pattern.matcher(str);
                while (matcher.find()) {
                    year_s = Integer.parseInt(matcher.group(1));
                }

                matcher = pattern.matcher(str);
                while (matcher.find()) {
                    month_s = Integer.parseInt(matcher.group(3));
                }


                matcher = pattern.matcher(str);
                while (matcher.find()) {
                    day_s = Integer.parseInt(matcher.group(5));
                }}
            c1.set(year_s, (month_s-1), day_s);
            if(c.before(c1)) {
              dateSet.add(sd.getSeanceDate());
                selectedSeances.add(sd);
                movieIdSet.add(sd.getMovie().getId());
            }
            if(c.equals(c1)) {
                dateSet.add(sd.getSeanceDate());
                selectedSeances.add(sd);
                movieIdSet.add(sd.getMovie().getId());
            }
        }

        List<Integer> movieIdList=new ArrayList<>(movieIdSet);

        boolean f=false;

        for(MovieDTO m: movieDTOList)
        {  f=false;
        {for (Integer id : movieIdList)
        {if(m.getId().equals(id)) {
                selectedMovies.add(m);
                f=true;
                break;
            }
        }if(f==false){
            restMovies.add(m);
        }}
        }
        List<Date> selectedDates=new ArrayList<>(dateSet);

        request.setAttribute("selectedDates",  selectedDates);
        request.setAttribute("selectedSeances",  selectedSeances);
        request.setAttribute("selectedMovies",   selectedMovies);
        request.setAttribute("restMovies",   restMovies);
        request.getRequestDispatcher("/admin/manager.jsp").forward(request,response);
      //  response.sendRedirect(request.getContextPath() + "/admin/manager.jsp");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
