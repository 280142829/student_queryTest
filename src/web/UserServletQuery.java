package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ListService;
import service.serviceimpl.ListServiceimpl;
import task01.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServletQuery")
public class UserServletQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServletQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用service的查询所有信息方法
		request.setCharacterEncoding("utf-8");
		//若获取值不为null则返回改字符串，若为null则返回一个空字符串
		String name =request.getParameter("name")!=null?request.getParameter("name"):"";
		String address = request.getParameter("address")!=null?request.getParameter("address"):"";
		String email =request.getParameter("email")!=null?request.getParameter("email"):"";
		ListService lfa = new ListServiceimpl();
		List<User> list = null;
		int ye = -1;
		if (request.getParameter("ye") != null && request.getParameter("ye").length() > 0) {
			ye = Integer.parseInt(request.getParameter("ye"));
		}

		if (ye == -1) {//若没有ye传进来
			ye=1;
			list = lfa.findAll(1, name, address, email);
		} else {//若有ye传进来
			list = lfa.findAll(ye, name, address, email);
		}
		// 获取页面数与数据条数
		int datasNumber = lfa.getDatasNumber(name, address, email);
		request.setAttribute("datasNumber", datasNumber);
		int pagesNumber = 0;
		if (datasNumber % 3 == 0) {
			pagesNumber = datasNumber / 3;
		} else if (datasNumber % 3 != 0) {
			pagesNumber = datasNumber / 3 + 1;
		}
		request.setAttribute("pagesNumber", pagesNumber);
		request.setAttribute("list", list);

		request.setAttribute("currentPage", ye);
		System.out.println("currentPage:" + ye);
		
		//传入name，address，email
		request.setAttribute("name", name);
		request.setAttribute("address", address);
		request.setAttribute("email", email);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
