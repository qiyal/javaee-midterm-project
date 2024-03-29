package iitu.javaee.javaee_endterm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionValidationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession(true);
        HttpServletResponse response = ((HttpServletResponse) servletResponse);
        HttpServletRequest request = ((HttpServletRequest) servletRequest);

        if (session.getAttribute("IS_AUTH") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String path = request.getContextPath() + "/login";
            response.sendRedirect(path);
        }
    }
}
