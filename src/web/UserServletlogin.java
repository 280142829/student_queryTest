package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dao.daoimpl.Daoimpl;
import service.ListService;
import service.serviceimpl.ListServiceimpl;

/**
 * Servlet implementation class UserServletlogin
 */
@WebServlet("/userServletlogin")
public class UserServletlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String managename= request.getParameter("user");
		String managepassword = request.getParameter("password");
		String verifycode = request.getParameter("verifycode");
		
		ListService login = new ListServiceimpl();
		
		HttpSession session= request.getSession();
	
		String CHECKCODE_SERVER = (String) session.getAttribute("CHECKCODE_SERVER");
		System.out.println("---------"+session.getAttribute("CHECKCODE_SERVER"));
		boolean flag =false;
		String loginSuc = null;
		if(CHECKCODE_SERVER.equalsIgnoreCase(verifycode)) {//驗證碼正確
			flag = login.findManage(managename, managepassword);
			
				if(flag) {
					loginSuc = "sucsess";
					session.setAttribute("loginSuc", loginSuc);
					request.setAttribute("managename", managename);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					
					
				}else {
					
					request.setAttribute("erro", "用户名或密码错误");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}else {
				
				request.setAttribute("erro", "验证码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
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
