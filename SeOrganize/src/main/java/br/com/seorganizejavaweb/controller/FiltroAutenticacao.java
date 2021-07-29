package br.com.seorganizejavaweb.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class FiltroAutenticacao
 */
public class FiltroAutenticacao implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAutenticacao() {
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
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest.getRequestURI();
		
		HttpSession sessao = httpServletRequest.getSession();
		
		chain.doFilter(request, response);
		
		//if(sessao.getAttribute("usuarioAutenticado")!=null || url.lastIndexOf("login.html")>-1 || url.lastIndexOf("AutenticadorController.do")>-1 || url.lastIndexOf("frmusuariocad.jsp")>-1) {
		/*if(url.lastIndexOf("cadUsuario")>-1 || url.lastIndexOf("login.html")>-1) {
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse) response).sendRedirect("login.html");
		}*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
