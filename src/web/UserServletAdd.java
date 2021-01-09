package web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ListService;
import service.serviceimpl.ListServiceimpl;

import task01.User;

/**
 * Servlet implementation class UserServletAdd
 */
@WebServlet("/UserServletAdd")
public class UserServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));//类型不同
		String address = request.getParameter("address");
		String qq = request.getParameter("qq");
		String email = request.getParameter("email");
		User user = new User( name,  sex,  age,  address,  qq,  email);
		ListService add = new ListServiceimpl();
		boolean flag = add.add(user);
		if(flag) {
			
			response.sendRedirect(request.getContextPath()+"/userServletQuery");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
