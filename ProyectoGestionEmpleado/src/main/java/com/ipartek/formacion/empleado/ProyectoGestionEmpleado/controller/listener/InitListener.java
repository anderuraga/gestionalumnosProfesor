package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.controller.listener;

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
	
	private final static Logger LOG = Logger.getLogger(InitListener.class);
	private final static String PATH_LOG4J ="WEB-INF/conf/log4j.properties";
	private final static String NAME_PROPERTIES = "properties";

    /**
     * Default constructor. 
     */
    public InitListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scab)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scab)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scab)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	loadLog4j(sce);
    	loadProperties(sce);
    	
    }
    
    private void loadLog4j(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		String ruta = sce.getServletContext().getRealPath("/");
		PropertyConfigurator.configure(ruta + PATH_LOG4J);
		try {
			PropertyConfigurator.configure(ruta + PATH_LOG4J);
			//if(LogManager.exists("PANTALLA")!=null)
			//{
				LOG.info("Log Cargado");
			//}
		} catch (Exception e) {
			// TODO: handle exception
				LOG.error("Error al cargar el log de log4j");
		}
	}
	
    private void loadProperties(ServletContextEvent sce) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("constantes.properties");
        Properties properties = new Properties();
        try {
          properties.load(input);
          LOG.info("Archivo constantes cargado");
        } catch (Exception e) {
          LOG.error("No se ha cargado el archivo constantes");
        }
        sce.getServletContext().setAttribute(NAME_PROPERTIES, properties);
      }
}
