package filter;


import dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "AdminFilter", urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
//&& (userDTO.getRole().name().equals("ADMIN"))
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        if ((userDTO != null)&& (userDTO.getRole().name().equals("ADMIN")) ) {
            chain.doFilter(req, resp);
        } else {
            request.getSession().setAttribute("url", request.getRequestURI());
            request.getSession().setAttribute("message", "You have to be admin");
            response.sendRedirect(request.getContextPath() + "/allUsers/login.jsp");
        }
    }
    public void init(FilterConfig config) throws ServletException {

    }

}
