package com.ipartek.formacion.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	private EmpleadoService eService = EmpleadoServiceImp.getInstance();
	private DepartamentoService dService = DepartamentoServiceImp.getInstance();
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
			request.setAttribute(Constantes.ATT_LISTADO_DEPARTAMENTOS, dService.getAll());
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
		id = Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
		
	}

	private void getAll(HttpServletRequest request) {
		empleados = eService.getAll();
		request.setAttribute(Constantes.ATT_LISTADO_EMPLEADOS, empleados);
		rd = request.getRequestDispatcher(Constantes.JSP_LISTADO_EMPLEADOS);
	}

	private void getById(HttpServletRequest request) {
		empleado = eService.getById(id);
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
				eService.createEmpleado(empleado);
				break;
			case Constantes.OP_DELETE:
				eService.delete(id);
				break;
			case Constantes.OP_UPDATE:
				recogerDatosEmpleado(request);
				eService.update(empleado);
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
		String diaN = request.getParameter(Constantes.PAR_DIA_NAC);
		String mesN = request.getParameter(Constantes.PAR_MES_NAC);
		String anyoN = request.getParameter(Constantes.PAR_ANYO_NAC);
		String diaC = request.getParameter(Constantes.PAR_DIA_CON);
		String mesC = request.getParameter(Constantes.PAR_MES_CON);
		String anyoC = request.getParameter(Constantes.PAR_ANYO_CON);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String fNac = "diaN/mesN/anyoN";
		String fCont = "diaC/mesC/anyoC";
		Date fNacimiento = null;
		Date fContratacion = null;
		
		try {
			 fNacimiento = formatter.parse(fNac);
			 fContratacion = formatter.parse(fCont);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		empleado.setfNacimiento(fNacimiento);
		empleado.setfContratación(fContratacion);
		
	}

}





