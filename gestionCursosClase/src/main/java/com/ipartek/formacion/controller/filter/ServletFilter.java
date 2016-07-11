package com.ipartek.formacion.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;

import com.ipartek.formacion.controller.Constantes;

/**
 * Servlet Filter implementation class ServletFilter
 */
public class ServletFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ServletFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		String uri = req.getServletPath(); //devuelve la ruta donde esta el contexto de la aplicacion (en el servidor)

		if(!uri.contains(Constantes.SERVLET_ALUMNOS))
		{
			if(checkSession(req))//sesion valida, continuar hacia delante
			{
				chain.doFilter(request, response);
			}
			else
			{
				//sin sesion valida por lo que se se redirige a la pagina inicial
				
				res.sendRedirect("index.jsp");
			}
		}
		else
		{
			
		}
		// pass the request along the filter chain
		//chain.doFilter(request, response);
		
	}

	private boolean checkSession(HttpServletRequest req) {
		// TODO Auto-generated method stub
		boolean correcto = false; 
		
		/*La url no da la ip
		 * URI = http://localhost:8080/gestioncursos
		 * URL = gestioncursos
		 */
		HttpSession session = req.getSession(false); //false para que no cree la sesion si esta no existe
		
		if(session !=null && session.getAttribute(Constantes.ATT_USUARIO)!=null)
		{
			correcto = true;	
			
		}
		
		return correcto;
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
