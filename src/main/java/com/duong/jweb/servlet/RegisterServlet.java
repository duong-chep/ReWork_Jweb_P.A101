package com.duong.jweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duong.jweb.dao.MemberDao;
import com.duong.jweb.dao.impl.MemberImpl;
import com.duong.jweb.services.MemberService;
import com.duong.jweb.utils.ConstraintUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String rePassword = request.getParameter("rePassword");
		MemberService service = new MemberService();
		int resultCode = service.addMember(userName, email, password, rePassword);
		if(resultCode == ConstraintUtils.SUCCESS) {
			response.sendRedirect(request.getContextPath()+"/login");
		}else {
			request.setAttribute(ConstraintUtils.MESSAGE, "add fail!");
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerPage.jsp").forward(request, response);
		}
	}

}
