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
import it.objectmethod.webappMondo.dao.impl.DaoCittaImpl;
import it.objectmethod.webappMondo.model.Citta;


public class EliminaCittaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Citta> lista = null;
		HttpSession session = request.getSession();
		IDaoCitta daoCitta= new DaoCittaImpl();
		int idCittaDaEliminare = Integer.parseInt(request.getParameter("idCitta"));
		daoCitta.eliminaCitta(idCittaDaEliminare);
		if((String)session.getAttribute("tipoDiListaCitta") == "listaCitta") {
			lista= daoCitta.getAllCitiesByNation((String)session.getAttribute("countryCode"));
		}
		if ((String)session.getAttribute("tipoDiListaCitta") == "ricercaCitta"){
			lista= daoCitta.cercaCitta((String)session.getAttribute("cercaCitta"));
		}
		
		request.setAttribute("listaCitta", lista);
		request.getRequestDispatcher("listaCitta.jsp").forward(request, response);
		
	}

}
