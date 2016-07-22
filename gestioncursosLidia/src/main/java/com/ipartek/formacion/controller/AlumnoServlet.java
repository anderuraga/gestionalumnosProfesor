package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.exception.AlumnoError;
import com.ipartek.formacion.controller.listener.InitListener;
import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.Idioma;
import com.ipartek.formacion.pojo.exception.CandidatoException;
import com.ipartek.formacion.service.AlumnoService;
import com.ipartek.formacion.service.AlumnoServiceImp;
import com.ipartek.formacion.service.CursoService;
import com.ipartek.formacion.service.CursoServiceImp;
import com.ipartek.formacion.service.Util;

/**
 * Servlet implementation class AlumnoServlet
 */
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private int id = -1;
	 private RequestDispatcher rd = null;
	 private AlumnoService aService = AlumnoServiceImp.getInstance();
	 private CursoService cService = new CursoServiceImp();
	 private List<Alumno> alumnos = null;
	 private Alumno alumno = null;   
	 private int operacion = -1;
	 //añadir los log
	 private final static Logger log=Logger.getLogger(InitListener.class);
	 private final static String PATH_LOG4J="WEB-INF/conf/log4j.properties";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			recogerId(request);
			request.setAttribute(Constantes.ATT_LISTADO_CURSOS, cService.getAll());//cada vez q el flujo de la navegac lleve a la pág alumno, lista disponible d cursos
			if(id < 0){//REDIGIRIMOS PARA UN CREATE
				rd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
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
		alumnos = aService.getAll();
		request.setAttribute(Constantes.ATT_LISTADO_ALUMNOS, alumnos);
		rd = request.getRequestDispatcher(Constantes.JSP_LISTADO_ALUMNOS);
	}

	private void getById(HttpServletRequest request) {
		alumno = aService.getById(id);
		request.setAttribute(Constantes.ATT_ALUMNO, alumno);
		rd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter(Constantes.PAR_OPERACION);
		try {
			if(Util.tryParseInt(op)){
				operacion = Integer.parseInt(op);
			}//añadir else??
			
			recogerId(request);
			switch (operacion) {
			case Constantes.OP_CREATE:
				recogerDatosAlumno(request);
				aService.createAlumno(alumno);
				break;
			case Constantes.OP_DELETE:
				aService.delete(id);
				break;
			case Constantes.OP_UPDATE:
				recogerDatosAlumno(request);
				aService.update(alumno);
				break;
			default:
				break;
			}
			getAll(request);
		} catch (NumberFormatException e){
			
		} catch(NullPointerException e){
			
		} catch(CandidatoException e){
			try {
				AlumnoError alumnoError = new AlumnoError();
				alumnoError = recogerDatosError(request);
				alumnoError.setMensaje(e.getMessage());
				request.setAttribute(Constantes.ATT_ALUMNO, alumnoError);
				rd = request.getRequestDispatcher(Constantes.JSP_ALUMNO);
			} catch (CandidatoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		catch(Exception e){
			
			
		}
		rd.forward(request, response);
	}

	private AlumnoError recogerDatosError(HttpServletRequest request) throws CandidatoException {
		AlumnoError alError = new AlumnoError();
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		String dni = request.getParameter(Constantes.PAR_DNI);
		String apellidos = request.getParameter(Constantes.PAR_APELLIDOS);
		alError.setCodigo(id);
		alError.setNombre(nombre);
		alError.setDni(dni);
		alError.setApellidos(apellidos);
		return alError;
	}

	private void recogerDatosAlumno(HttpServletRequest request) throws CandidatoException {
		alumno = new Alumno();
		String nombre = request.getParameter(Constantes.PAR_NOMBRE);
		String dni = request.getParameter(Constantes.PAR_DNI);
		String apellidos = request.getParameter(Constantes.PAR_APELLIDOS);
		String[] idiomas = request.getParameterValues(Constantes.PAR_IDIOMA);//añadir lista enumeration de idiomas
		List<Idioma> idi = Util.parseIdioma(idiomas);//clase util parseos
		//recoger fecha
		String idCurso = request.getParameter(Constantes.PAR_CURSO);
		String genero = request.getParameter(Constantes.PAR_GENERO);
		//añadir email y teléf
		String email=request.getParameter(Constantes.PAR_EMAIL);
		String telefono=request.getParameter(Constantes.PAR_TELEFONO);
		Curso curso = new Curso();
		curso.setCodigo(Integer.parseInt(idCurso));
		alumno.setCodigo(id);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);
		alumno.setDni(dni);
		//añadir género,curso e idioma
		alumno.setIdiomas(idi);
		alumno.setCurso(curso);
		alumno.setGenero(Util.parseGenero(genero));
		//añadir email y telef
		alumno.setEmail(email);
		alumno.setTelefono(telefono);
	    
	}

}

