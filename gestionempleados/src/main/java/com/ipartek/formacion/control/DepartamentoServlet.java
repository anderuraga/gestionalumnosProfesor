package com.ipartek.formacion.control;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Departamento;
import com.ipartek.formacion.service.DepartamentoService;
import com.ipartek.formacion.service.DepartamentoServiceImp;

/**
 * Servlet implementation class DepartamentoServlet
 */
public class DepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id = -1;
	private RequestDispatcher rd = null;
	private DepartamentoService dService = DepartamentoServiceImp.getInstance();
	private List<Departamento> departamentos = null;
	private Departamento departamento = null;
	private int operacion = -1;
	private final static Logger LOG = Logger.getLogger(DepartamentoServlet.class);
	private Properties props = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartamentoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			// request.setAttribute(Constantes.ATT_LISTADO_CURSOS,
			// cService.getAll());
			recogerId(request);

			if (id < 0) {// REDIGIRIMOS PARA UN CREATE

				rd = request.getRequestDispatcher("${properties.JSPdepartamento}");
			} else {// REDIGIMOS PARA UNA UPDATE
				getById(request);
			}

		} catch (Exception e) {
			LOG.fatal(e.getMessage());
			getAll(request);
		}
		rd.forward(request, response);
	}

	private void getAll(HttpServletRequest request) {
		departamentos = dService.getAll();
		request.setAttribute(props.getProperty("${properties.listadoDepartamento}"), departamentos);
		rd = request.getRequestDispatcher(props.getProperty("${properties.JSPlistadoDepartamentos}"));

	}

	private void recogerId(HttpServletRequest request) {
		// if (Util.tryParseInt(request.getParameter(Constantes.PAR_CODIGO))){
		id = Integer.parseInt(request.getParameter(props.getProperty("parCodigo")));
		// }

	}

	private void getById(HttpServletRequest request) {
		departamento = dService.getById(id);
		request.setAttribute(props.getProperty("attDepartamento"), departamento);
		rd = request.getRequestDispatcher(props.getProperty("JSPdepartamento"));

	}

	private void recogerDatos(HttpServletRequest request) {
		departamento = new Departamento();
		recogerId(request);
		departamento.setCodigo(id);
		String nombre = request.getParameter(props.getProperty("parNombre"));
		departamento.setNombre(nombre);
		String descripcion = request.getParameter(props.getProperty("parDescripcion"));
		departamento.setDescripcion(descripcion);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter(props.getProperty("parOperacion"));
		try {

			operacion = Integer.parseInt(op);

			switch (operacion) {
			case 0:
				recogerDatos(request);
				dService.createDepartamento(departamento);
				break;
			case 3:
				recogerId(request);
				dService.delete(id);
				break;
			case 2:
				recogerDatos(request);
				dService.update(departamento);
				break;
			}
		} catch (NumberFormatException e) {
			LOG.error("Alguien toquetea los datos del form en el get" + e.getMessage());
		}

		getAll(request);
		rd.forward(request, response);
	}

}
