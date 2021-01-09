package web;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.ListService;
import service.serviceimpl.ListServiceimpl;
import task01.User;

/**
 * Servlet implementation class UserServletUpdate02
 */
@WebServlet("/userServletUpdate02")
public class UserServletUpdate02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletUpdate02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		int id = Integer.parseInt(request.getParameter("id"));//類型不同
//	
//		String name = request.getParameter("name");
//		
//		String gender = request.getParameter("sex");
//		
//		int age = Integer.parseInt(request.getParameter("age"));//类型不同
//		String address = request.getParameter("address");
//		String qq = request.getParameter("qq");
//		String email = request.getParameter("email");
		
		Map<String,String[]> map = request.getParameterMap();
		System.out.println(map);
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		ListService update = new ListServiceimpl();
		update.update2(user);
		
		response.sendRedirect(request.getContextPath()+"/userServletQuery");
		
		
		
		
	}

	private int parseInt(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
