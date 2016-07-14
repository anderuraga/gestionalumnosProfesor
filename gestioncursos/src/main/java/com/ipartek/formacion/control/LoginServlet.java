package com.ipartek.formacion.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Mensaje;
import com.ipartek.formacion.pojo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;
	private HttpSession session = null;
	private static final Logger log = Logger.getLogger(LoginServlet.class);
	private Usuario user = null;
	private String nUsuario = "";
	private String passWord = "";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (cargarCookies(request)){
			cargarDatosCookies();

		}else{
			if(request.getParameter(Constantes.PAR_USER)!=null){
				cargarParametros(request);

			}
		}
		if(user!=null && "urko".equals(user.getUser())&&"urko".equals(user.getPass())){
			String[] checkboxes = request.getParameterValues(Constantes.PAR_REMEMBER);
			if(checkboxes!=null && checkboxes.length==1){
				generarCookies(response);
			}
			procesarLogin(request);
			rd.forward(request, response);
		}else{
			if(user!=null && "urko".equals(user.getUser())&&"urko".equals(user.getPass())){
				Mensaje mensaje = new Mensaje();
				mensaje.setMsg("Usuario y/o contraseña incorrectos");
				mensaje.setType(Mensaje.MSG_TYPE_ERROR);
				session.setAttribute(Constantes.ATT_MENSAJE, mensaje);
			}
			response.sendRedirect(Constantes.JSP_HOME);
		}

	}
	private void generarCookies(HttpServletResponse response) {
		Cookie cookieNombre = new Cookie("usuario",user.getUser());
		Cookie cookiePass = new Cookie("password",user.getPass());

		cookieNombre.setMaxAge(24*60*60);
		cookiePass.setMaxAge(60*24*60);
		response.addCookie(cookiePass);
		response.addCookie(cookieNombre);
	}


	private void procesarLogin(HttpServletRequest request) {
		createSession(request);
		rd = request.getRequestDispatcher(Constantes.SERVLET_CURSOS);

		//request.setAttribute(Constantes.ATT_MENSAJE, mensaje);



	}

	private void cargarDatosCookies() {
		log.trace(nUsuario+" "+passWord);
		user = new Usuario();
		user.setUser(nUsuario);
		user.setPass(passWord);
		user.setNick("Stukov");
	}

	private void cargarParametros(HttpServletRequest request) {
		user = new Usuario();
		user.setUser(request.getParameter(Constantes.PAR_USER));
		user.setPass(request.getParameter(Constantes.PAR_PASSWORD));
		user.setNick("Stukov");
		//session.setAttribute(Constantes.ATT_USUARIO, usuario);
		//	rd = request.getRequestDispatcher(Constantes.SERVLET_CURSOS);
	}

	private boolean cargarCookies(HttpServletRequest request) {
		boolean cargado = false;

		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie: cookies){
				if(cookie.getName().equals("usuario")){
					nUsuario = cookie.getValue();
				}else{
					if(cookie.getName().equals("password")){
						passWord = cookie.getValue();
					}
				}
			}
			if(!"".equals(nUsuario)&&!"".equals(passWord)){
				cargado = true;
			}
		}
		return cargado;
	}
	private void createSession(HttpServletRequest request){
		session = request.getSession(true);
		/*
		 * getSession(true) ---> Si la session no existe te la crea
		 * getSession(false) --> Te coge la session activa si no existe es null
		 *
		 */
		session.setMaxInactiveInterval(60*60*15);
	}
}
