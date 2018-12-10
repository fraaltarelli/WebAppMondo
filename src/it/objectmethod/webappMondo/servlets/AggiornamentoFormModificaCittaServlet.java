package it.objectmethod.webappMondo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.webappMondo.dao.IDaoCitta;
import it.objectmethod.webappMondo.dao.IDaoNazione;
import it.objectmethod.webappMondo.dao.impl.DaoCittaImpl;
import it.objectmethod.webappMondo.dao.impl.DaoNazioneImpl;
import it.objectmethod.webappMondo.model.Citta;
import it.objectmethod.webappMondo.model.Nazione;


public class AggiornamentoFormModificaCittaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Citta> lista = null;
		IDaoCitta daoCitta= new DaoCittaImpl();
		IDaoNazione daoNazione= new DaoNazioneImpl();

		List<Nazione> allNations= daoNazione.allNations();
		int idCittaDaModificare = Integer.parseInt(request.getParameter("idCitta"));
		Citta cittaDaModificare = daoCitta.cittaDaModificare(idCittaDaModificare);

		request.setAttribute("allNations", allNations);
		request.setAttribute("cittaDaModificare", cittaDaModificare);
		request.setAttribute("listaCitta", lista);
		request.getRequestDispatcher("formModificaSalvaCitta.jsp").forward(request, response);

	}

}
