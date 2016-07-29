package com.ipartek.formacion.controller;

/**
 * Servlet de Empleado
 */

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.listener.InitListener;
import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.service.EmpleadoService;
import com.ipartek.formacion.service.EmpleadoServiceImp;

/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(EmpleadoServlet.class);
	
	private RequestDispatcher rwd = null;
	private int id = -1;
	private Properties props = null;
	private static EmpleadoService eService = new EmpleadoServiceImp().getInstance();
	private Empleado empleado = null;
	private List<Empleado> empleados = null;
	private int operacion = -1;	

	@Override
	public void destroy() {
		props = null;
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		props = (Properties) getServletContext().getAttribute(InitListener.PROPS_NAME);
		super.init();
	}

	private void recogerId(HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter(props.getProperty("parCodigo")));
		LOG.trace("codigo del empleado: " + id);
	}
    
    private void getAll(HttpServletRequest request) {
		empleados = eService.getAll();
		request.setAttribute(props.getProperty("listadoEmpleados"), empleados);
		rwd = request.getRequestDispatcher(props.getProperty("JSPlistadoEmpleados"));
	}

	private void getById(HttpServletRequest request) {
		empleado = eService.getById(id);
		request.setAttribute(props.getProperty("attEmpleado"), empleado);
		rwd = request.getRequestDispatcher(props.getProperty("JSPempleado"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//request.setAttribute(Constantes.ATT_LISTADO_CURSOS, cService.getAll());
			recogerId(request);
			
			if(id < 0){
				// Se redirige para realizar un CREATE
				rwd = request.getRequestDispatcher(props.getProperty("JSPempleado"));
			} else{
				// Se redirige para realizar un UPDATE
				getById(request);
			}
		} catch(Exception e){
			// Visualizamos todos
			getAll(request);
		}

		rwd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter(props.getProperty("parOperacion"));
		
		try {
			operacion = Integer.parseInt(op);

			recogerId(request);
			
			switch(operacion){
				case 0:
					// CREATE
					recogerDatosEmpleado(request);
					eService.insert(empleado);
					break;
					
				case 1:
					// READ
					break;
					
				case 2:
					// UPDATE
					recogerDatosEmpleado(request);
					eService.update(empleado);
					break;
				
				case 3:
					// DELETE
					eService.delete(id);
					break;

				default:
					break;
			}
			getAll(request);
		} catch(NumberFormatException e){
			LOG.error("Error NumberFormatException: " + e.getMessage());
		} catch (NullPointerException e) {
			LOG.error("Error NullPointerException: " + e.getMessage());
		} catch (Exception e) {
			LOG.error("Error Exception: " + e.getMessage());
		}
		rwd.forward(request, response);
	}
	
	private Date formatearFecha(String dia, String mes, String anno){
		String fecha = dia + "/" + mes + "/" + anno;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;

		try {
			date = formatter.parse(fecha);
		} catch (ParseException e) {
			// LOG DE ERRORES
			LOG.error(e.getMessage());
		}
		
		return date;
	}

	private void recogerDatosEmpleado(HttpServletRequest request) {
		empleado = new Empleado();
		
		empleado.setCodigo(id);
		
		int codigoDepartamento = Integer.parseInt(request.getParameter(props.getProperty("parCodigoDepartamento")));
		empleado.setCodigoDepartamento(codigoDepartamento);
		
		String nombre = request.getParameter(props.getProperty("parNombre"));
		empleado.setNombre(nombre);
		
		String apellidos = request.getParameter(props.getProperty("parApellidos"));
		empleado.setApellidos(apellidos);
		
		String dni = request.getParameter(props.getProperty("parDni"));
		empleado.setDni(dni);
		
		String dia = request.getParameter(props.getProperty("parDiaNacimiento"));
		String mes = request.getParameter(props.getProperty("parMesNacimiento"));
		String anno = request.getParameter(props.getProperty("parAnnoNacimiento"));
		Date fechaNacimiento = formatearFecha(dia, mes, anno);
		empleado.setFechaNacimiento(fechaNacimiento);
		
		dia = request.getParameter(props.getProperty("parDiaContratacion"));
		mes = request.getParameter(props.getProperty("parMesContratacion"));
		anno = request.getParameter(props.getProperty("parAnnoContratacion"));
		Date fechaContratacion = formatearFecha(dia, mes, anno);
		empleado.setFechaNacimiento(fechaContratacion);
		
		int numeroSS = Integer.parseInt(request.getParameter(props.getProperty("numeroSS")));
		empleado.setNumeroSS(numeroSS);
		
		String direccion = request.getParameter(props.getProperty("direccion"));
		empleado.setDireccion(direccion);
		
		String localidad = request.getParameter(props.getProperty("localidad"));
		empleado.setLocalidad(localidad);
		
		int codigoPostal = Integer.parseInt(request.getParameter(props.getProperty("codigoPostal")));
		empleado.setCodigoPostal(codigoPostal);
	}

}
