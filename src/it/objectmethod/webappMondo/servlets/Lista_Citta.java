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
import it.objectmethod.webappMondo.dao.IDaoNazione;
import it.objectmethod.webappMondo.dao.impl.DaoCittaImpl;
import it.objectmethod.webappMondo.dao.impl.DaoNazioneImpl;
import it.objectmethod.webappMondo.model.Citta;


public class Lista_Citta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
//   String countryCodeSalvato;
//   String currentNation, nomeNazioneSelezionata;
//   boolean newcitta;
//   int currentCityId;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		IDaoCitta daoCitta= new DaoCittaImpl();
		String countrycode;
//		IDaoNation daoNation= new DaoNationImpl();
//		currentCityId=0;
//		
//		if (request.getParameter("newcitta")!=null) {
//			newcitta=true;
//			}
//		else {
//			newcitta=false;
//		}
//		
		
		if(request.getParameter("codiceNazioneSelezionata")!= null) {
		countrycode= request.getParameter("codiceNazioneSelezionata");
//		countryCodeSalvato =countrycode;
		}
		else {
			countrycode= null;
		}
		
		
		
//		if(request.getParameter("nomeNazioneSelezionata")!= null) {
//			currentNation= request.getParameter("nomeNazioneSelezionata");
//			nomeNazioneSelezionata =currentNation;
//			}
//			else {
//				currentNation= null;
//			}
//		
//		
//		if(request.getParameter("idcitta")!=null) {
//		currentCityId= Integer.parseInt(request.getParameter("idcitta"));
//		
//		}
		
//		List<City> lista= daoCitta.getAllCitiesByNation(countryCodeSalvato);
		List<Citta> lista= daoCitta.getAllCitiesByNation(countrycode);
//		session.setAttribute("listaNazioni", null);
//		session.setAttribute("currentNation", nomeNazioneSelezionata);
//		session.setAttribute("currentCityId", currentCityId);
//		request.setAttribute("newcitta", newcitta);
//		session.setAttribute("currentList", "Citta");
		session.setAttribute("targetServletBottone", "runCitta");
//		session.setAttribute("countryCodeSalvato", countryCodeSalvato);
		request.setAttribute("listaCitta", lista);
		request.getRequestDispatcher("listaCitta.jsp").forward(request, response);
		
	}

	

}
