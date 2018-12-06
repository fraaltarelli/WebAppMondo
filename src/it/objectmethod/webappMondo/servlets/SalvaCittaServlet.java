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


public class SalvaCittaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Citta> lista = null;
		HttpSession session = request.getSession();
		IDaoNazione daoNazione = new DaoNazioneImpl();
		IDaoCitta daoCitta= new DaoCittaImpl();
		int idCittaDaModificare=0;
		Citta cittaDaModificare = null;

		List<String> allnationnames= daoNazione.allNationNames();

		if (request.getParameter("idCitta")!=null) {
			idCittaDaModificare = Integer.parseInt(request.getParameter("idCitta"));
			cittaDaModificare = daoCitta.cittaDaModificare(idCittaDaModificare);
			session.setAttribute("nuovaCitta", false);
		}
		else {
			session.setAttribute("nuovaCitta", true);
		}


		if((String)session.getAttribute("tipoDiListaCitta") == "listaCitta") {
			request.setAttribute("targetServletDaSalvaCitta", "runCitta");
		}
		if ((String)session.getAttribute("tipoDiListaCitta") == "ricercaCitta"){
			request.setAttribute("targetServletDaSalvaCitta", "cittaCercate");

		}
		if((boolean)session.getAttribute("nuovaCitta")==true) {
			request.setAttribute("targetServletDaSalvaCitta", "runContinenti");
		}


		request.setAttribute("allnations", allnationnames);
		request.setAttribute("cittaDaModificare", cittaDaModificare);
		session.setAttribute("idCittaDaModificare", idCittaDaModificare);
		request.setAttribute("listaCitta", lista);
		request.getRequestDispatcher("salvaCitta.jsp").forward(request, response);

	}

}
