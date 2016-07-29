package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Empleado;
import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.service.EmpleadoService;
import com.ipartek.formacion.service.EmpleadoServiceImp;
import com.ipartek.formacion.service.DepartamentoService;
import com.ipartek.formacion.service.DepartamentoServiceImp;


/**
 * Servlet implementation class DepartamentoServlet
 */
public class DepartamentoServlet extends HttpServlet {
	private final static Logger LOG = Logger.getLogger(DepartamentoServlet.class);
	private static final long serialVersionUID = 1L;
	private int id = -1;
	private int operacion = -1;
	private RequestDispatcher rd = null;
	private DepartamentoService dService = DepartamentoServiceImp.getInstance();
	private EmpleadoService eService = EmpleadoServiceImp.getInstance();
	private List<Departamento> departamentos = null;
	private Departamento departamento = null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			recogerId(request);
			request.setAttribute(Constantes.ATT_LISTADO_EMPLEADOS, eService.getAll());
			if(id<0){
				rd = request.getRequestDispatcher(Constantes.JSP_DEPARTAMENTO);
			}else{
				getById(request);
			}

		} catch(Exception e){
			getAll(request);
			
		}
		rd.forward(request, response);

	}

	private void getById(HttpServletRequest request) {

		departamento = dService.getById(id);
		System.out.println(departamento.getCodigo());
		request.setAttribute(Constantes.ATT_DEPARTAMENTO, departamento);
		rd = request.getRequestDispatcher(Constantes.JSP_DEPARTAMENTO);
	}

	private void getAll(HttpServletRequest request) {

		departamentos = dService.getAll();
		request.setAttribute(Constantes.ATT_LISTADO_DEPARTAMENTOS, departamentos);
		rd = request.getRequestDispatcher(Constantes.JSP_LISTADO_DEPARTAMENTOS);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Procesaremos el DELETE, UPDATE y CREATE
		//1º recoger datos del objeto departamento
		String op = request.getParameter(Constantes.PAR_OPERACION);
		try{

			operacion = Integer.parseInt(op);

			switch(operacion){
			case Constantes.OP_CREATE:
				recogerDatos(request);
				dService.createDepartamento(departamento);
				break;
			case Constantes.OP_DELETE:
				recogerId(request);
				dService.delete(id);
				break;
			case Constantes.OP_UPDATE:
				recogerDatos(request);
				dService.update(departamento);
				break;
			}
		} catch (NumberFormatException e){
			LOG.error(e.getMessage());
			
		}

		getAll(request);
		rd.forward(request, response);
	}

	private void recogerId(HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));

	}

	private void recogerDatos(HttpServletRequest request) {
		departamento = new Departamento();
		recogerId(request);
		departamento.setCodigo(id);
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		String descripcion = request.getParameter(Constantes.PAR_DESCRIPCION);
		String[] codEmpleados = request.getParameterValues(Constantes.PAR_LISTADO_EMPLEADOS);
		
		departamento.setNombre(nombre);
		departamento.setDescripcion(descripcion);
		List<Empleado> empleados = getEmpleados(codEmpleados);
	}


	private List<Empleado> getEmpleados(String[] codEmpleados) {
		List<Empleado> empleados =  new ArrayList<Empleado>();
		for (String codEmpleado : codEmpleados) {
			Empleado empleado = null;
			int codigo = Integer.parseInt(codEmpleado);
			empleado = eService.getById(codigo);
			empleados.add(empleado);
		}
		return empleados;
	}

}
