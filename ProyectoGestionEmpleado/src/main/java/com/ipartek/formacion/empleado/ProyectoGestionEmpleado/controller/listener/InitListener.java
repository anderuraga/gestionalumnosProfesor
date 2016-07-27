package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.controller.listener;

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
	
	private final static Logger log = Logger.getLogger(InitListener.class);
	private final static String PATH_LOG4J ="WEB-INF/conf/log4j.properties";

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
    	
    }
    
    private void loadLog4j(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		String ruta = sce.getServletContext().getRealPath("/");
		PropertyConfigurator.configure(ruta + PATH_LOG4J);
		try {
			PropertyConfigurator.configure(ruta + PATH_LOG4J);
			//if(LogManager.exists("PANTALLA")!=null)
			//{
				log.info("Log Cargado");
			//}
		} catch (Exception e) {
			// TODO: handle exception
				log.error("Error al cargar el log de log4j");
		}
	}
	
}
