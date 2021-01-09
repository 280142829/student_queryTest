package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import task01.User;

/**
 * Servlet implementation class UserServletUpdateReset
 */
@WebServlet("/UserServletUpdateReset")
public class UserServletUpdateReset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletUpdateReset() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userupdate");
		User user2 = new User();
		user2.setId(user.getId());
		user2.setAddress(user.getAddress());
		user2.setName(user.getName());
		
		System.out.println("÷ÿ÷√∫Ûµƒuser"+user2);
		session.setAttribute("userupdate", user2);
		response.sendRedirect(request.getContextPath()+"/update02.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
