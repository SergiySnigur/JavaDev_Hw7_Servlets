package servlet.settings;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


public class TimeZoneQueryParams {
    public String parseQueryParams(HttpServletRequest request) {
        if (request.getParameterMap().containsKey("timezone")) {
            return (request.getParameter("timezone").replace(" ", "+").length() < 1) ?
                    "UTC" : request.getParameter("timezone").replace(" ", "+").toUpperCase();
        }
        return "UTC";
    }
}
