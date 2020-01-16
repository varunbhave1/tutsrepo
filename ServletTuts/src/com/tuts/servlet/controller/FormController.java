package com.tuts.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.function.BiConsumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormController
 */
@WebServlet("/formcontroller")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Map<String, String[]> paraMap = request.getParameterMap();
		
		
		out.print("<h4>Information submitted by user : </h4>");
		BiConsumer<String,String[]> action = new BiConsumer<String, String[]>() {
			
			@Override
			public void accept(String t, String[] u) {
			
				switch(t) {
				
				case "name":
					out.print("Name : "+u[0]+"<br/>");
					break;
				case "gender":
					out.print("Gender : "+u[0]+"<br/>");
					break;
				case "country":
					out.print("Country : "+u[0]+"<br/>");
					break;
				case "language":
					String selected="";
					if(u!=null && u.length>0) {
						selected = String.join(",", u);
						out.print("Languages Known : "+selected+"<br/>");
					}else {
						out.print("Known languages not selected !"+"<br/>");
					}
				
				}//switch end	
			}
		};
		
		paraMap.forEach(action );
		
	}

}
