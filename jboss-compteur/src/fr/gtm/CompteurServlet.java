package fr.gtm;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CompteurServlet")
public class CompteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CompteurServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Compteur compteur = (Compteur) session.getAttribute("compteur");
//		if(compteur == null) {
//			try {
//			InitialContext ctx = new InitialContext();
//			compteur = (Compteur) ctx.lookup("java:app/jboss-compteur/Compteur");
//			session.setAttribute("compteur", compteur);
//			}
//			catch (NamingException e) {
//				e.printStackTrace();
//			}
//		}
		compteur.incrementer();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/compteur.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}