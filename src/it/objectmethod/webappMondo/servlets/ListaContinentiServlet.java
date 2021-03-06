package it.objectmethod.webappMondo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.webappMondo.dao.IDaoNazione;
import it.objectmethod.webappMondo.dao.impl.DaoNazioneImpl;


public class ListaContinentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		IDaoNazione daoNazione= new DaoNazioneImpl();

		
		session.setAttribute("continenteBySession", null);
		List<String> lista= daoNazione.getAllContinents();
		request.setAttribute("listaContinenti", lista);
		request.getRequestDispatcher("continenti.jsp").forward(request, response);

	}


}
