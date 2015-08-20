package be.ordina.servletdemo.web.servlet;

import be.ordina.servletdemo.domain.authentication.Authenticator;
import be.ordina.servletdemo.domain.authentication.Principal;
import be.ordina.servletdemo.exception.AuthenticationFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stevedezitter on 15/08/15.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    private static final String USERNAME_PARAM = "username";
    private static final String PASSWORD_PARAM = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.debug("Entering LoginServlet doPost method");

        String username = request.getParameter(USERNAME_PARAM);
        String password = request.getParameter(PASSWORD_PARAM);

        Authenticator authenticator = new Authenticator(username, password);
        try {
            Principal principal = authenticator.authenticate();
            request.getSession().setAttribute(Authenticator.SESSION_KEY_PRINCIPAL, principal);

            redirectTo(request, response, "/jsp/home.jsp");
        }catch (AuthenticationFailedException authenticationFailedException) {
            LOGGER.debug("Failed Authentication attempt for user: " + username);
            redirectTo(request, response, "/login.jsp");
        }


        LOGGER.debug("Entering LoginServlet doPost method");
    }

    private void redirectTo(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
