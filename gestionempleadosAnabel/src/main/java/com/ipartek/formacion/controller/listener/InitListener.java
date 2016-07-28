package com.ipartek.formacion.controller.listener;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener, ServletContextAttributeListener {

  // ES EN EL INITLISTENER DONDE SE CARGAN TANTO EL LOG4J.PROPERTIES COMO EL CONSTANTES.PROPERTIES,
  // AL INICIALIZAR EL SERVICIO
  private static Logger LOG = Logger.getLogger(InitListener.class);
  private final static String PATH_LOG4J = "WEB-INF/conf/log4j.properties";
  private final static String PROP_NAME = "properties";

  /**
   * Default constructor.
   */
  public InitListener() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
   */
  public void attributeAdded(ServletContextAttributeEvent scab) {
    // TODO Auto-generated method stub
  }

  /**
   * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
   */
  public void attributeRemoved(ServletContextAttributeEvent scab) {
    // TODO Auto-generated method stub
  }

  /**
   * @see ServletContextListener#contextDestroyed(ServletContextEvent)
   */
  public void contextDestroyed(ServletContextEvent sce) {
    // TODO Auto-generated method stub
  }

  /**
   * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
   */
  public void attributeReplaced(ServletContextAttributeEvent scab) {
    // TODO Auto-generated method stub
  }

  /**
   * @see ServletContextListener#contextInitialized(ServletContextEvent)
   */
  public void contextInitialized(ServletContextEvent sce) {
    this.loadLog4j(sce);
    this.loadConstantes(sce);
  }

  private void loadConstantes(ServletContextEvent sce) {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    InputStream input = classLoader.getResourceAsStream("constantes.properties");
    Properties props = new Properties();
    try {
      props.load(input);
    } catch (Exception e) {
      LOG.error("No se ha cargado el archivo constantes");
    }
    sce.getServletContext().setAttribute(PROP_NAME, props);

  }

  private void loadLog4j(ServletContextEvent sce) {

    String ruta = sce.getServletContext().getRealPath("/");
    PropertyConfigurator.configure(ruta + this.PATH_LOG4J);
  }

}
