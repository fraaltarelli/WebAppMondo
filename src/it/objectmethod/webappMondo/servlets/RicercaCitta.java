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


public class RicercaCitta extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDaoCitta daoCitta= new DaoCittaImpl();
		String cercacitta= request.getParameter("cercacitta");
		List<Citta> lista= daoCitta.cercaCitta(cercacitta);
		request.setAttribute("listaCitta", lista);
		request.getRequestDispatcher("listaCitta.jsp").forward(request, response);
		
	}

}