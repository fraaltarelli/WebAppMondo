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


public class ListaContinentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		IDaoNazione daoNazione= new DaoNazioneImpl();
		String nomeDaSalvare, distrettoDaSalvare, nazioneSelezionata;
		int popolazioneDaSalvare;
		IDaoCitta daoCitta= new DaoCittaImpl();

		if(session.getAttribute("nuovaCitta")!=null) { 
			if((boolean)session.getAttribute("nuovaCitta")==true) {
				nazioneSelezionata = (String)request.getParameter("nazioneselezionata");
				nomeDaSalvare = (String)request.getParameter("nomecittainserito");
				distrettoDaSalvare = (String)request.getParameter("nomedistrettoinserito");
				popolazioneDaSalvare = Integer.parseInt(request.getParameter("popolazioneinserita"));
				daoCitta.inserisciCitta(nazioneSelezionata,nomeDaSalvare, distrettoDaSalvare, popolazioneDaSalvare);
			}
		}


		session.setAttribute("continenteBySession", null);
		List<String> lista= daoNazione.getAllContinents();
		request.setAttribute("listaContinenti", lista);
		request.getRequestDispatcher("continenti.jsp").forward(request, response);
		session.setAttribute("nuovaCitta", false);


	}



}
