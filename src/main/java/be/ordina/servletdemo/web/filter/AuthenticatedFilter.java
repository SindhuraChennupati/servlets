package be.ordina.servletdemo.web.filter;

import be.ordina.servletdemo.domain.authentication.Authenticator;
import be.ordina.servletdemo.domain.authentication.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stevedezitter on 15/08/15.
 */
@WebFilter("/jsp/*")
public class AuthenticatedFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticatedFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void destroy() {}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        Principal principal = (Principal)request.getSession().getAttribute(Authenticator.SESSION_KEY_PRINCIPAL);
        if(principal == null) {
            LOGGER.debug("Not authenticated, redirecting to login page.");
            ((HttpServletResponse)servletResponse).sendRedirect("/login.jsp");
            return;
        }

        LOGGER.debug("Authenticated user: " + principal.getUsername() + " accessing page: " + request.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}