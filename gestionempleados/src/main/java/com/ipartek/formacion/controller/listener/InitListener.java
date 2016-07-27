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

public class InitListener implements ServletContextListener, ServletContextAttributeListener {
	private final static Logger LOG = Logger.getLogger(InitListener.class);
	private final static String PATH_LOG4J ="WEB-INF/conf/log4j.properties";
	public final static String PROPS_NAME="properties";
	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		loadLog4j(sce);
		loadProperties(sce);
		
	}

	private void loadProperties(ServletContextEvent sce) {
	    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
		  InputStream input=classLoader.getResourceAsStream("constantes.properties");
		    Properties props=new Properties();
		    try {
	        props.load(input);
	        LOG.trace("PROPERTIES CARGADAS");
	      } catch (IOException e) {
	        LOG.error("no se han encontrado las properties");
	      }
		     sce.getServletContext().setAttribute(PROPS_NAME,props);
		
	}

	private void loadLog4j(ServletContextEvent sce) {
		String ruta = sce.getServletContext().getRealPath("/");

		

		try{
			PropertyConfigurator.configure(ruta+PATH_LOG4J);
			LOG.info("LOG CARGADO");
		}catch(Exception e){
		  LOG.error("LOG error");
		}


		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
