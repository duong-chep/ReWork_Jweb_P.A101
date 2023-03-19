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
import com.duong.jweb.entities.Member;
import com.duong.jweb.utils.ConstraintUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		MemberDao dao = new MemberImpl();
		Member member = dao.getMember(email, password);
		if(member != null) {
			request.getSession().setAttribute(ConstraintUtils.MEMBER_LOGINED, member);
			response.sendRedirect(request.getContextPath()+"/editProfile");
			return;
		}
		else {
			request.setAttribute(ConstraintUtils.MESSAGE, "username or password invalid");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginPage.jsp");
			dispatcher.forward(request, response);
		}
	}

}
