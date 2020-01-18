package com.tuts.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.function.BiConsumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */
@WebServlet(description = "dummy servlet class", urlPatterns = { "/Demo" })
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Demo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> queryParamMap = request.getParameterMap();
		response.getWriter().print("<h4>Query Parameters : </h4>");
		
		if(request.getParameterMap().size()==0) {
			response.getWriter().print("No query parameters found !");
		}else {
			
			BiConsumer<String,String[]> action = new BiConsumer<String, String[]>() {
				
				@Override
				public void accept(String t, String[] u) {
					
					String valStr="";
					if(u.length==1) {
						try {
							response.getWriter().print("Key : "+t+" (Value)=> "+u[0]);
							response.getWriter().print("</br>");
						} catch (IOException e) {
							System.out.println("Could not write query parameter to response object.");
						}
					}else if(u.length>1) {
						for(int k=0;k<u.length;k++) {
							valStr = valStr+";"+u[k];
						}
						try {
							response.getWriter().print("Key : "+t+" (Values)=> "+valStr);
							response.getWriter().print("</br>");
						} catch (IOException e) {
							System.out.println("Could not write query parameter to response object.");
						}
					}
				}
			};

			queryParamMap.forEach(action);
			
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
