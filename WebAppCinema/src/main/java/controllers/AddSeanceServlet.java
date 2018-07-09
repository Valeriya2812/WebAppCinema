package controllers;


import dto.HallDTO;
import dto.MovieDTO;
import dto.SeanceDTO;
import service.impl.HallServiceImpl;
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


@WebServlet(name = "AddSeanceServlet", urlPatterns={"/admin/addseance"})
public class AddSeanceServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDTO movieDTO = MovieServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
     //  List<HallDTO> hallDTOList= HallServiceImpl.getInstance().getAll();
        List<SeanceDTO> seanceDTOList= SeanceServiceImpl.getInstance().getByMovie(movieDTO.getId());

        List<Date> selectedDates;


        Set<Date> dateSet=new TreeSet<>();
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
                if(c.before(c1))
                    dateSet.add(sd.getSeanceDate());
                //selectedSeances.add(sd);
                if(c.equals(c1))
                    dateSet.add(sd.getSeanceDate());
                //todaySeanceDto.add(sd);

            }


        selectedDates=new ArrayList<>(dateSet);
        request.setAttribute("seanceDTOList",  seanceDTOList);
        request.setAttribute("selectedDates",  selectedDates);
        request.setAttribute("movieDTO", movieDTO);

        request.getRequestDispatcher("/admin/addseance.jsp").forward(request,response);
  //      response.sendRedirect(request.getContextPath() + "/admin/addseance.jsp");


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}