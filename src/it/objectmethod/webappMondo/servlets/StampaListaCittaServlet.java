package it.objectmethod.webappMondo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.webappMondo.dao.IDaoCitta;
import it.objectmethod.webappMondo.dao.impl.DaoCittaImpl;
import it.objectmethod.webappMondo.model.Citta;


public class StampaListaCittaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Citta> lista=null;
		String countryCode = (String)request.getAttribute("countryCode");
		IDaoCitta daoCitta= new DaoCittaImpl();
		if(request.getParameter("cercaCitta")=="") {
		lista= daoCitta.getAllCitiesByNation(countryCode);
		}
		else {
			 lista= daoCitta.cercaCitta(request.getParameter("cercaCitta"));
		}
		
		request.setAttribute("listaCitta", lista);
		request.getRequestDispatcher("listaCitta.jsp").forward(request, response);

	}

}
