package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filter01
 */
@WebFilter("/*")
public class Filter01 implements Filter {

    /**
     * Default constructor. 
     */
    public Filter01() {
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
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String address = httpRequest.getRequestURI();
		HttpSession session = httpRequest.getSession();
		if (address.contains("/checkCodeServlet") 
				|| address.contains("/login.jsp")
				|| address.contains("/userServletlogin")
				|| address.contains("/js/")
				|| address.contains("/css/")
				|| address.contains("/fonts/")) {
			
			chain.doFilter(request, response);
			
		} else {
			if (session.getAttribute("loginSuc") != null) {
				System.out.println("之前");
				chain.doFilter(request, response);
				System.out.println("之后");
			} else {
				request.getRequestDispatcher("/login.jsp").forward(httpRequest, (HttpServletResponse) response);
			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
