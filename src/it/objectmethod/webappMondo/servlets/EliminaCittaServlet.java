package it.objectmethod.webappMondo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.webappMondo.dao.IDaoCitta;
import it.objectmethod.webappMondo.dao.impl.DaoCittaImpl;


public class EliminaCittaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IDaoCitta daoCitta= new DaoCittaImpl();
		int idCittaDaEliminare = Integer.parseInt(request.getParameter("idCitta"));
		daoCitta.eliminaCitta(idCittaDaEliminare);

		request.setAttribute("eliminazioneRiuscita", true);
		request.getRequestDispatcher("listaCitta.jsp").forward(request, response);

	}

}
