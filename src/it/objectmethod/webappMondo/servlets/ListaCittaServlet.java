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


public class ListaCittaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		IDaoCitta daoCitta= new DaoCittaImpl();
		String nomeDaSalvare, distrettoDaSalvare;
		String countrycode=null;
		int popolazioneDaSalvare;
		List<Citta> lista;

		if(request.getParameter("codiceNazioneSelezionata")!=null) {
			countrycode = request.getParameter("codiceNazioneSelezionata");
		}
		else {
			countrycode = (String)session.getAttribute("countryCode");
		}



		if(request.getParameter("salvaCitta")!=null) {
			nomeDaSalvare = (String)request.getParameter("nomecittainserito");
			distrettoDaSalvare = (String)request.getParameter("nomedistrettoinserito");
			popolazioneDaSalvare = Integer.parseInt(request.getParameter("popolazioneinserita"));
			daoCitta.modificaCitta((int)session.getAttribute("idCittaDaModificare"), nomeDaSalvare, distrettoDaSalvare, popolazioneDaSalvare);
		}
		lista= daoCitta.getAllCitiesByNation(countrycode);


		session.setAttribute("countryCode", countrycode);
		session.setAttribute("tastoIndietro", true);
		session.setAttribute("tipoDiListaCitta", "listaCitta");
		request.setAttribute("listaCitta", lista);
		request.getRequestDispatcher("listaCitta.jsp").forward(request, response);

	}



}
