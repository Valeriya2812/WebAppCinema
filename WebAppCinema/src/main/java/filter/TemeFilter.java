package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by dmitr on 21.03.2017.
 */
@WebFilter(filterName = "TemeFilter", urlPatterns = "/time")
public class TemeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("TemeFilter before servlet");
        chain.doFilter(req, resp);
        System.out.println("TemeFilter after servlet");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
