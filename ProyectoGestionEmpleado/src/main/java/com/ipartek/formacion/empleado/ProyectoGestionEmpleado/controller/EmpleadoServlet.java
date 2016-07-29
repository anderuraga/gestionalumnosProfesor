package com.ipartek.formacion.empleado.ProyectoGestionEmpleado.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.dbms.dao.exception.EmpleadoDAOImpException;
import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.pojo.Empleado;
import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.service.EmpleadoService;
import com.ipartek.formacion.empleado.ProyectoGestionEmpleado.service.EmpleadoServiceImp;

/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher rwd;
	private static final Logger LOG = Logger.getLogger(EmpleadoServlet.class);
	private Properties properties = null;
	
	private static EmpleadoService eService = EmpleadoServiceImp.getInstance();
	
	private List<Empleado> empleados = null;
	private Empleado empleado = null;
       
	
	
    @Override
	public void destroy() {
    	properties = null;
    	super.destroy();
	}

	@Override
	public void init() throws ServletException {
		properties = (Properties) getServletContext().getAttribute("properties");
		super.init();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		cargarEmpleados(request);
		rwd.forward(request, response);
	}
	
	private void cargarEmpleados(HttpServletRequest request)
	{
		empleados = eService.getAll();
		request.setAttribute(properties.getProperty("listadoEmpleado"), empleados);
		rwd = request.getRequestDispatcher(properties.getProperty("jspListaEmpleados"));
	}
	
	private void cargarEmpleado(HttpServletRequest request){
		
		int id = Integer.parseInt(request.getParameter(properties.getProperty("parCodigo")));
		try {
			empleado = eService.getById(id);
		} catch (EmpleadoDAOImpException e) {
			e.printStackTrace();
		}
		request.setAttribute(properties.getProperty("empleado"), empleado);
		rwd = request.getRequestDispatcher(properties.getProperty("jspEmpleado"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("update")==null)
		{
			cargarEmpleado(request);
		}
		else {
			
			recogerDatos(request);
			eService.update(empleado);
			LOG.info("UPDATE " + empleado.getCodigo());
		}
		rwd.forward(request, response);
		
	}
	
	private void recogerDatos(HttpServletRequest request){
		empleado = new Empleado();
		Date fechaNac = null;
		Date fechaContra = null;
		int id = Integer.parseInt(request.getParameter(properties.getProperty("parCodigo")));
		int cp = Integer.parseInt(request.getParameter(properties.getProperty("parCP")));
		DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
		/*try {
			fechaNac = df.parse(request.getParameter(properties.getProperty("parFechaNac")));
			fechaContra = df.parse(request.getParameter(properties.getProperty("parFechaContra")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        empleado.setCodigo(id);
		empleado.setNombre(request.getParameter(properties.getProperty("parNombre")));
		LOG.info("NOMBRE" + request.getParameter(properties.getProperty("parNombre")));
		empleado.setApellidos(request.getParameter(properties.getProperty("parApellidos")));
		empleado.setFechaNacimiento(fechaNac);
		empleado.setFechaContratacion(fechaContra);
		empleado.setNumeroSS(request.getParameter(properties.getProperty("parSeguridadS")));
		empleado.setCuentaCorriente(request.getParameter(properties.getProperty("parCuenta")));
		empleado.setDireccion(request.getParameter(properties.getProperty("parDir")));
		empleado.setLocalidad(request.getParameter(properties.getProperty("parLoc")));
		empleado.setCodigoPostal(cp);
		empleado.setDni(request.getParameter(properties.getProperty("parDNI")));
		empleado.setDepartamento(request.getParameter(properties.getProperty("parDpto")));
	}

}
