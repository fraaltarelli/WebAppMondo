package it.objectmethod.webappMondo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.webappMondo.dao.IDaoCitta;
import it.objectmethod.webappMondo.dao.impl.DaoCittaImpl;
import it.objectmethod.webappMondo.model.Citta;


public class CercaCitta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//int currentCityId;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		IDaoCitta daoCitta= new DaoCittaImpl();
		String cercacitta= request.getParameter("cercacitta");
//		if (request.getParameter("creacitta")!=null) {
//			currentCityId=0;
//			}
		List<Citta> lista= daoCitta.cercaCitta(cercacitta);
		request.setAttribute("cittaCercate", lista);
//		session.setAttribute("currentCityId", currentCityId);
//		session.setAttribute("currentList", "CercaCitta");
		//session.setAttribute("currentServlet", "CercaCitta");
		request.getRequestDispatcher("cittaCercate.jsp").forward(request, response);
		
	}

}
