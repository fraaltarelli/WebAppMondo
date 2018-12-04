package it.objectmethod.webappMondo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import it.objectmethod.webappMondo.dao.IDaoCity;
import it.objectmethod.webappMondo.dao.IDaoNazione;
//import it.objectmethod.jdbctutorial3.dao.impl.DaoCityImpl;
import it.objectmethod.webappMondo.dao.impl.DaoNazioneImpl;
//import it.objectmethod.jdbctutorial3.model.City;
import it.objectmethod.webappMondo.model.Nazione;


public class ListaNazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		IDaoNazione daoNazione= new DaoNazioneImpl();
		String continenteSelezionato;
		
		continenteSelezionato = request.getParameter("continente");
		if(continenteSelezionato == null) {
			continenteSelezionato = (String) session.getAttribute("continenteBySession");
		}
		
		session.setAttribute("continenteBySession", continenteSelezionato);
		List<Nazione> lista= daoNazione.getAllNationsByContinent(continenteSelezionato);
		request.setAttribute("listaNazioni", lista);
		request.getRequestDispatcher("listaNazioni.jsp").forward(request, response);
		
		
	}

	

}
