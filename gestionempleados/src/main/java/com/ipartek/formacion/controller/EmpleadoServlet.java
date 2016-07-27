package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.pojo.Idioma;
import com.ipartek.formacion.service.EmpleadoService;
import com.ipartek.formacion.service.EmpleadoServiceImp;
import com.ipartek.formacion.service.DepartamentoService;
import com.ipartek.formacion.service.DepartamentoServiceImp;
import com.ipartek.formacion.service.Util;

/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id = -1;
	private RequestDispatcher rd = null;
	private EmpleadoService aService = EmpleadoServiceImp.getInstance();
	private DepartamentoService cService = DepartamentoServiceImp.getInstance();
	private List<Empleado> empleados = null;
	private Empleado empleado = null;
	private int operacion = -1;
	private static final Logger log = Logger.getLogger(EmpleadoServlet.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{

			recogerId(request);
			request.setAttribute(Constantes.ATT_LISTADO_DEPARTAMENTOS, cService.getAll());
			if(id < 0){//REDIGIRIMOS PARA UN CREATE
				rd = request.getRequestDispatcher(Constantes.JSP_EMPLEADO);
			}else{//REDIGIMOS PARA UNA UPDATE
				getById(request);
			}

		}catch(Exception e){
			getAll(request);
		}
		rd.forward(request, response);
	}

	private void recogerId(HttpServletRequest request) {
		//if(Util.tryParseInt(request.getParameter(Constantes.PAR_CODIGO))){
		id = Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
		//}

	}

	private void getAll(HttpServletRequest request) {
		empleados = aService.getAll();
		request.setAttribute(Constantes.ATT_LISTADO_EMPLEADOS, empleados);
		rd = request.getRequestDispatcher(Constantes.JSP_LISTADO_EMPLEADOS);
	}

	private void getById(HttpServletRequest request) {
		empleado = aService.getById(id);
		request.setAttribute(Constantes.ATT_EMPLEADO, empleado);
		rd = request.getRequestDispatcher(Constantes.JSP_EMPLEADO);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter(Constantes.PAR_OPERACION);
		try {
			if(Util.tryParseInt(op)){
				operacion = Integer.parseInt(op);
			}

			recogerId(request);
			switch (operacion) {
			case Constantes.OP_CREATE:
				recogerDatosEmpleado(request);
				aService.createEmpleado(empleado);
				break;
			case Constantes.OP_DELETE:
				aService.delete(id);
				break;
			case Constantes.OP_UPDATE:
				recogerDatosEmpleado(request);
				aService.update(empleado);
				break;
			default:
				break;
			}
			getAll(request);
		} catch (NumberFormatException e){

			log.error(e.getMessage());
		} catch(NullPointerException e){

			log.error(e.getMessage());
		} 
		catch(Exception e){
			log.error(e.getMessage());

		}
		rd.forward(request, response);
	}


	private void recogerDatosEmpleado(HttpServletRequest request) {
		empleado = new Empleado();
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		String dni = request.getParameter(Constantes.PAR_DNI);
		String apellidos = request.getParameter(Constantes.PAR_APELLIDOS);
//		String fNacimiento = request.getParameter(Constantes.PAR_APELLIDOS);
//		String fContratacion = request.getParameter(Constantes.PAR_APELLIDOS);
		String nSS = request.getParameter(Constantes.PAR_NSS);
		String cc = request.getParameter(Constantes.PAR_CC);
		String direccion = request.getParameter(Constantes.PAR_DIRECCION);
		String localidad = request.getParameter(Constantes.PAR_LOCALIDAD);
		String codigoPostal = request.getParameter(Constantes.PAR_CODIGOPOSTAL);
		String idDepartamento = request.getParameter(Constantes.PAR_DEPARTAMENTO);

		empleado.setCodigo(id);
		empleado.setNombre(nombre);
		empleado.setApellidos(apellidos);
		empleado.setDni(dni);
		empleado.setnSS(nSS);
		empleado.setCc(Integer.parseInt(cc));
		empleado.setDireccion(direccion);
		empleado.setLocalidad(localidad);
		empleado.setCodigoPostal(Integer.parseInt(codigoPostal));		
		empleado.setTipoDepartamento(Integer.parseInt(idDepartamento));
		
	}

}





