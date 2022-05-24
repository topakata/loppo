package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Cat;
import repository.Repository;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Repository collection;
	
	public void init(ServletConfig config) throws ServletException {	
		collection = Repository.getInstance();	 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String personalName = request.getParameter("personal-name");
		String catName = request.getParameter("cat-name");
		String breed = request.getParameter("breed");
		String description = request.getParameter("description");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(personalName == null || personalName.isEmpty()
				|| catName == null || catName.isEmpty()
				|| breed == null || breed.isEmpty()
				|| description == null || description.isEmpty()) {
			out.print("<p>Не сте въвели всички полета!</p>");	
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		} else {
			Cat cat = new Cat(personalName, catName, breed, description);
			
			if (collection.getCatByCatName(catName) == null) {
				collection.addCat(cat);
				Cookie cookie = new Cookie("cookie", "cook");
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
				response.sendRedirect("login");
				/*RequestDispatcher rd = request.getRequestDispatcher("/ListOfCats.jsp");
				rd.include(request, response);*/
			} else {
				out.print("<p>Тази котка е вече регистрирана!</p>");	
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
			}
		}
	
	}

}
