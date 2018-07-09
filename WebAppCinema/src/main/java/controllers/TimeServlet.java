package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "time", urlPatterns = {"/time"})
public class TimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDateTime ldt = LocalDateTime.now();
        String pattern = "dd.MM.yyyy HH:mm:ss";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        String time = ldt.format(format);
        StringBuilder sb = new StringBuilder();
        String lastTime = "-";
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("lastTime")){
                lastTime =  URLDecoder.decode(cookie.getValue(), "UTF-8");
            }
        }
        sb.append("<html>");
        sb.append("<head>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h2>");
        sb.append("now time: ").append(time);
        sb.append("<br/>");
        sb.append("last time: ").append(lastTime);
        sb.append("</h2>");
        sb.append("</body>");
        sb.append("</html>");
        Cookie cookie = new Cookie("lastTime", URLEncoder.encode(time, "UTF-8"));
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.setContentType("text/html");
        Writer writer = response.getWriter();
        writer.write(sb.toString());
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
