package controllers;


import dto.HallDTO;
import dto.MovieDTO;
import dto.PlaceDTO;
import dto.SeanceDTO;
import mapper.BeanMapper;
import model.Hall;
import model.Movie;
import model.Place;
import model.Seance;
import service.impl.HallServiceImpl;
import service.impl.MovieServiceImpl;
import service.impl.PlaceServiceImpl;
import service.impl.SeanceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Date;
import java.sql.Time;

@WebServlet(name = "CreateSeanceServlet", urlPatterns={"/admin/createseance"})
public class CreateSeanceServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BeanMapper beanMapper=null;
        String date=request.getParameter("seanceDate");

        int year_s=0, month_s=0, day_s=0, hours=0, min=0;
        Calendar c= Calendar.getInstance();
        Calendar c1=Calendar.getInstance();
        Pattern  pattern = Pattern.compile("(\\d+)(.)(\\d+)(.)(\\d+)");
        Matcher matcher = pattern.matcher(date);
        if (matcher.find()) {
            matcher = pattern.matcher(date);
            while (matcher.find()) {
                year_s = Integer.parseInt(matcher.group(1));
            }

            matcher = pattern.matcher(date);
            while (matcher.find()) {
                month_s = Integer.parseInt(matcher.group(3));
            }


            matcher = pattern.matcher(date);
            while (matcher.find()) {
                day_s = Integer.parseInt(matcher.group(5));
            }}
        c1.set(year_s, (month_s-1), day_s);
        if(c.before(c1))
        {
            String time=request.getParameter("seanceTime");
              pattern = Pattern.compile("(\\d+)(.)(\\d+)");
            matcher = pattern.matcher(time);
            if (matcher.find()) {
                matcher = pattern.matcher(time);
                while (matcher.find()) {
                   hours = Integer.parseInt(matcher.group(1));
                }

                matcher = pattern.matcher(time);
                while (matcher.find()) {
                    min = Integer.parseInt(matcher.group(3));
                }
            }
            Date seanceDate=new Date(c1.getTimeInMillis());
            long t=((hours-2)*60*60+min*60)*1000;
            Time seanceTime=new Time(t);

            int price=Integer.parseInt(request.getParameter("price"));
            MovieDTO movieDTO = MovieServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id_movie")));
            HallDTO hallDTO = HallServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("selectedHall")));

            Movie movie = beanMapper.singleMapper(movieDTO, Movie.class);
            Hall hall = beanMapper.singleMapper(hallDTO, Hall.class);

           SeanceDTO seanceDTO = new SeanceDTO(movie, hall, seanceDate, seanceTime, price);
            SeanceServiceImpl.getInstance().save(seanceDTO);

            Seance seance=beanMapper.singleMapper(seanceDTO, Seance.class);


            List<SeanceDTO> seanceDTOList = SeanceServiceImpl.getInstance().getByMovie(movieDTO.getId());
            for(SeanceDTO s:seanceDTOList)
                if((s.getSeanceDate().toString().compareTo(seanceDTO.getSeanceDate().toString())==0)&&(s.getSeanceTime().toString().compareTo(seanceDTO.getSeanceTime().toString())==0)
                        &&(s.getHall().getId().intValue()==seanceDTO.getHall().getId().intValue()))
                {
                    seance.setId(s.getId());
                    break;
                }
            List<PlaceDTO> placeDTOList= new ArrayList<>();
            for(int row=0; row<hall.getCountOfRows(); row++)
                for(int col=0; col<hall.getCountOfColumns(); col++)
                    placeDTOList.add(new PlaceDTO(seance, row, col, true));
//if(seance.getId()!=null)
          //  seance.setId(100);
    for (PlaceDTO m : placeDTOList) {
        PlaceServiceImpl.getInstance().save(m);
    }


            request.getRequestDispatcher("/admin/moviemanager").forward(request,response);

          //  response.sendRedirect(request.getContextPath() + "/admin/moviemanager");

        }
        else {

            response.sendRedirect(request.getContextPath() + "/admin/moviemanager");
        }


    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
