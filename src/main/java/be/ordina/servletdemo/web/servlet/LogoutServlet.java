package be.ordina.servletdemo.web.servlet;

import be.ordina.servletdemo.domain.authentication.Authenticator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stevedezitter on 15/08/15.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute(Authenticator.SESSION_KEY_PRINCIPAL);

        response.sendRedirect("/index.jsp");
    }
}
