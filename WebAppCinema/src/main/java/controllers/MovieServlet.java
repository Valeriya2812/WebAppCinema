package controllers;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dto.MovieDTO;
import dto.SeanceDTO;
import service.impl.MovieServiceImpl;
import service.impl.SeanceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
@WebServlet(name = "MovieServlet", urlPatterns={"/movie"})
public class MovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MovieDTO movieDTO = MovieServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
        List<SeanceDTO> seanceDTOList = SeanceServiceImpl.getInstance().getAll();
        int id_date=Integer.parseInt(request.getParameter("id_date"));
        List<Date> selectedDates;
        List<SeanceDTO> selectedSeances= new ArrayList<>();

        Set<Date> dateSet=new TreeSet<>();
        Calendar c= Calendar.getInstance();
        Calendar c1=Calendar.getInstance();

        int year=c.get(c.YEAR);
        int month=c.get(c.MONTH)+1;
        int day=c.get(c.DAY_OF_MONTH);
        String d=new String(year+"-"+month+"-"+day);


        Pattern pattern;
        Matcher matcher;
        String str;
        int year_s=0, month_s=0, day_s=0;
        for (SeanceDTO sd : seanceDTOList)
            if(sd.getMovie().equals(movieDTO))
            { str=sd.getSeanceDate().toString();
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
        String da;
        selectedDates=new ArrayList<>(dateSet);
      if(id_date!=0){da=request.getParameter("selectDate");

      int count=0;
      for(Date dt :selectedDates)
      {
          if(dt.toString().equals(da))
          {  if(count==0)
              break;
              selectedDates.add(selectedDates.get(0));
              selectedDates.set(0, dt);
              selectedDates.remove(count);
              break;
          }count++;
      }

      }
      else da=d;
        for (SeanceDTO sd : seanceDTOList)
        {
            if((sd.getSeanceDate().toString().equals(da))&&(sd.getMovie().equals(movieDTO)))
                selectedSeances.add(sd);
        }



      //  request.setAttribute("seanceDTOList", movieDTO);
        request.setAttribute("movieDTO", movieDTO);
        request.setAttribute("selectedSeances", selectedSeances);
        request.setAttribute("selectedDates", selectedDates);
        request.getRequestDispatcher("/allUsers/movie.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
