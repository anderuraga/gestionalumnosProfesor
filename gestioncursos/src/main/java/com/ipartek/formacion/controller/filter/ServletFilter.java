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
		HttpServletRequest req = (HttpServletRequest) request; //NO ES LO MISMO HttpServletRequest  QUE  ServletRequest, POR ESO EL CASTIN
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		if(checkSession(req)){ //si existe una sesion (ha hecho login)
			chain.doFilter(request, response); //si todo va bien hace esto
		}else{ //no tiene una sesion válida
			res.sendRedirect("index.jsp");
		}
		
		
		
	}

	private boolean checkSession(HttpServletRequest req) {
		
		boolean correcto = false;
		
		HttpSession session = req.getSession(false); 
		if(session != null && session.getAttribute(Constantes.ATT_USUARIO) != null){
			
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
