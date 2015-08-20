package be.ordina.servletdemo.web.listener; /**
 * Created by stevedezitter on 15/08/15.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class ServletDemoListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServletDemoListener.class);

    // Public constructor is required by servlet spec
    public ServletDemoListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
        LOGGER.debug("ServletDemo contextInitialized Listener method");
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        LOGGER.debug("ServletDemo contextDestroyed Listener method");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
        LOGGER.debug("ServletDemo sessionCreated Listener method");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
        LOGGER.debug("ServletDemo sessionDestroyed Listener method");
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
        LOGGER.debug("ServletDemo attribute added: " + sbe.getName());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        LOGGER.debug("ServletDemo attribute removed: " + sbe.getName());
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
        LOGGER.debug("ServletDemo contextDestroyed Listener method");
    }
}
