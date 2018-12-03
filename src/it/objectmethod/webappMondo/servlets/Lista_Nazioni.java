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


public class Lista_Nazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		IDaoNazione daoNazione= new DaoNazioneImpl();
		String continenteSelezionato;
		//IDaoCity daoCity= new DaoCityImpl();
		
//		if (request.getParameter("newcitta")!=null) {
//			newcitta=true;
//			}
//		else {
//			newcitta=false;
//		}
		
		
		
		if (request.getParameter("continente")!=null) {
			continenteSelezionato = request.getParameter("continente");
		}
		else {
			String continenteBySession=(String)session.getAttribute("continenteBySession");
			continenteSelezionato=continenteBySession;
		}
		
		
		
		session.setAttribute("continenteBySession", continenteSelezionato);
		List<Nazione> lista= daoNazione.getAllNationsByContinent(continenteSelezionato);
		//session.setAttribute("listaContinenti", null);
		
		request.setAttribute("listaNazioni", lista);
		
		//session.setAttribute("listaCitta", null);
//		request.setAttribute("newcitta", newcitta);
		session.setAttribute("targetServletBottone", "runNazioni");
//		session.setAttribute("currentNation", null);
//		session.setAttribute("currentList", "");
//		session.setAttribute("currentCityId", 0);
		request.getRequestDispatcher("listaNazioni.jsp").forward(request, response);
		
		
	}

	

}
