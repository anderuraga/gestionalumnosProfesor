package com.ipartek.formacion.control;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.pojo.Mensaje;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	HttpSession session = null;
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;
	private final static Logger LOG = Logger.getLogger(LoginServlet.class);
	private Properties props = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {

		Empleado empleado = null;

		String user = request.getParameter(props.getProperty("parNombre"));
		String pass = request.getParameter(props.getProperty("parPassword"));
		String idioma = request.getParameter(props.getProperty("parIdiomas"));

		if ("password".equals(pass) && "Josu@josu.es".equals(user)) {

			createSession(request);
			empleado = new Empleado();
			empleado.setSessionId(session.getId());
			// empleado.setIdiomas(Idioma.CASTELLANO);
			session.setAttribute(props.getProperty("attEmpleado"), empleado);
			rd = request.getRequestDispatcher(props.getProperty("JSPempleado"));
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				LOG.error(e.getMessage());
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
		} else {
			createSession(request);
			// rd = request.getRequestDispatcher("index.jsp");
			Mensaje mensaje = new Mensaje();
			mensaje.setMsg("Usuario y/o contraseña incorrecta");
			mensaje.setType(Mensaje.MSG_TYPE_ERROR);
			// request.setAttribute(Constantes.ATT_MENSAJE,mensaje);
			session.setAttribute(props.getProperty("mensaje"), mensaje);
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
		}

	}

	@Override
	public void destroy() {
		props = null;
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		props = (Properties) getServletContext().getAttribute("properties");
		super.init();
	}

	private void createSession(HttpServletRequest request) {
		session = request.getSession(true);
		/*
		 * getSession(True) Si la sesion no existe la crea, si existe te la coge
		 * getSession(false) Te coge la session activa, no crea una nueva. Si no
		 * existe sigues sin session
		 */
		int duracion = 60 * 60 * 15;
		session.setMaxInactiveInterval(duracion);// en milisegundos, 15
													// minutos. Es un
													// autologout

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

}
