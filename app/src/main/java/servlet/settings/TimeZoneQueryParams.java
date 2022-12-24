package servlet.settings;

//import servlet.TimezoneValidateFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


public class TimeZoneQueryParams {
    public String parseQueryParams(HttpServletRequest request) {
        return request.getParameter("timezone")
                .replace(" ", "+").toUpperCase();
    }
}
