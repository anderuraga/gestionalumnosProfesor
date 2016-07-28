package com.ipartek.formacion.controller;

import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.ipartek.formacion.service.DepartamentoService;
import com.ipartek.formacion.service.DepartamentoServiceImp;
import com.ipartek.formacion.service.EmpleadoService;
import com.ipartek.formacion.service.EmpleadoServiceImp;

public class EmpleadosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Properties props = null;
	private static EmpleadoService eService = EmpleadoServiceImp.getInstance;
	private static DepartamentoService dService = DepartamentoServiceImp.getInstance;

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
