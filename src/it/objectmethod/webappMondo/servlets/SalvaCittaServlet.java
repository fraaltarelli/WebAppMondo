package it.objectmethod.webappMondo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.webappMondo.dao.IDaoCitta;
import it.objectmethod.webappMondo.dao.impl.DaoCittaImpl;
import it.objectmethod.webappMondo.model.Citta;


public class SalvaCittaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDaoCitta daoCitta= new DaoCittaImpl();

		int idCittaDaModificare= Integer.parseInt(request.getParameter("id"));
		String countryCode = (String)request.getParameter("countryCode");
		String nomeDaSalvare = (String)request.getParameter("nomecittainserito");
		String distrettoDaSalvare = (String)request.getParameter("nomedistrettoinserito");
		int popolazioneDaSalvare = Integer.parseInt(request.getParameter("popolazioneinserita"));
		
		Citta cittaDaSalvare= new Citta();
		cittaDaSalvare.setId(idCittaDaModificare);
		cittaDaSalvare.setNomeCitta(nomeDaSalvare);
		cittaDaSalvare.setDistretto(distrettoDaSalvare);
		cittaDaSalvare.setPopolazione(popolazioneDaSalvare);
		cittaDaSalvare.setCountryCode(countryCode);
		
		if(idCittaDaModificare!=0) {
			daoCitta.aggiornaCitta(cittaDaSalvare);
		}
		else {

			daoCitta.inserisciCitta(cittaDaSalvare);
		}

		request.setAttribute("salvataggioRiuscito", true);
		request.getRequestDispatcher("salvaCitta.jsp").forward(request, response);

	}

}
