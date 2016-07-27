package com.ipartek.formacion.controller.listener;

import java.io.IOException;
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
	private final static String PATH_LOG4J = "WEB-INF/conf/log4j.properties";
	public final static String PROP_NAME = "properties";

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		loadLog4j(sce);
		loadProperties(sce);
	}

	private void loadProperties(ServletContextEvent sce) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream input = classloader.getResourceAsStream("constantes.properties");
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			LOG.error("No se han cargado las properties");
		}
		sce.getServletContext().setAttribute(PROP_NAME, prop);

	}

	private void loadLog4j(ServletContextEvent sce) {
		String ruta = sce.getServletContext().getRealPath("/");

		try {
			PropertyConfigurator.configure(ruta + PATH_LOG4J);
			LOG.info("LOG CARGADO");
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
