package servlet;

import servlet.settings.TimeZoneQueryParams;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/time")
public class TimezoneValidateFilter extends HttpFilter {
    private final TimeZoneQueryParams queryParams = new TimeZoneQueryParams();

    protected void doFilter(HttpServletRequest req,
                            HttpServletResponse resp,
                            FilterChain chain) throws ServletException, IOException {

        if (queryParams.parseQueryParams(req).contains("UTC")) {
            chain.doFilter(req, resp);
        } else {
            resp.setStatus(400);
            resp.setContentType("application/json");
            resp.getWriter().write("Invalid timezone!");
            resp.getWriter().close();
        }
    }
}
