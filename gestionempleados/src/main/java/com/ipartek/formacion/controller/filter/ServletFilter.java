package com.ipartek.formacion.controller.filter;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class ServletFilter
 */
public class ServletFilter implements Filter {
  private static final Logger LOG = Logger.getLogger(ServletFilter.class);
  private Properties props = null;

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
    props = null;
  }

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest auxRequest = (HttpServletRequest) request;
    HttpServletResponse auxResponse = (HttpServletResponse) response;
    auxRequest.setCharacterEncoding("UTF-8");
    String uri = auxRequest.getRequestURI();
    if (checkSession(auxRequest) || uri.contains(props.getProperty("loginServlet"))) {
      chain.doFilter(request, response);
    } else {
      LOG.info("No hay sesion activa. Redireccionando a index");
      auxResponse.sendRedirect("index.jsp");
    }
  }

  private boolean checkSession(HttpServletRequest request) {
    boolean existe = false;
    HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute(props.getProperty("attUsuario")) != null) {
      existe = true;
    }
    return existe;
  }

  /**
   * @see Filter#init(FilterConfig)
   */
  public void init(FilterConfig fConfig) throws ServletException {
    props = (Properties) fConfig.getServletContext().getAttribute("constantes");
  }

}
