package com.tuts.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/controller")
public class DemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param = request.getParameter("page");
		if(param.equals("login")) {
			getServletContext().getRequestDispatcher("/app/login.jsp").forward(request, response);
		}else if(param.equals("signup")) {
			getServletContext().getRequestDispatcher("/app/signup.jsp").forward(request, response);
		}else if(param.equals("about")) {
			getServletContext().getRequestDispatcher("/app/about.jsp").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/app/notfound.jsp").forward(request, response);
		}
		
		
	}

}
