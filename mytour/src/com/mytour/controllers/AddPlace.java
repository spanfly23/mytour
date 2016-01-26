package com.mytour.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mytour.models.Place;
import com.mytour.models.USState;

/**
 * Servlet implementation class AddPlace
 */
@WebServlet("/AddPlace")
public class AddPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlace() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
//		out.println("<html><body>");
//		out.println("<h2> asdfsdf </h2>");
//		out.println("</body></html>");
		request.setAttribute("place_name", "");
		//request.setAttribute("last_name", "");
		//request.setAttribute("dob", "");
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_place.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setAttribute("errors", false);

		Place p = new Place();

		String placeName = request.getParameter("place-name");
		System.out.println("placeName: " + placeName);

		if (placeName.length() == 0) {
			System.out.println("empty place name error");

			request.setAttribute("errors", true);
			request.setAttribute("placename_error", true);
			request.setAttribute("place_name", "");

		} else {
			p.setPlaceName(placeName);
			request.setAttribute("place_name", placeName);
		}

		String state = request.getParameter("state-name");
		System.out.println("state: " + state);
		p.setUsStateName(USState.valueOf(state));

		if ((Boolean) request.getAttribute("errors")) {

			RequestDispatcher view = request
					.getRequestDispatcher("WEB-INF/views/add_place.jsp");

			view.forward(request, response);

		} else {

			ServletContext sc = this.getServletContext();

			synchronized (this) {
				ArrayList<Place> pList = (ArrayList<Place>) sc.getAttribute("places");

				pList.add(p);

				sc.setAttribute("places", pList);
			}

			response.sendRedirect("");

		}
	}

}
