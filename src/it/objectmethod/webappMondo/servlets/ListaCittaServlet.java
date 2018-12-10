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


public class ListaCittaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDaoCitta daoCitta= new DaoCittaImpl();

		String countrycode = request.getParameter("codiceNazioneSelezionata");
		String nomeNazioneSelezionata=(String)request.getParameter("nomeNazioneSelezionata");
		List<Citta> lista= daoCitta.getAllCitiesByNation(countrycode);

		request.setAttribute("nomeNazioneSelezionata", nomeNazioneSelezionata);
		request.setAttribute("listaCitta", lista);
		request.getRequestDispatcher("listaCitta.jsp").forward(request, response);

	}



}
