package com.ipartek.formacion.controller;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DepartamentosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Properties props = null;

	/**
	 * @Override
	 * @throws ServletException
	 *             excepcion
	 */
	@Override
	public void init() throws ServletException {
		props = (Properties) getServletContext().getAttribute("properties");

		super.init();
	}

	/**
	 * @Override
	 */
	@Override
	public void destroy() {
		props = null;
		super.destroy();
	}

}
