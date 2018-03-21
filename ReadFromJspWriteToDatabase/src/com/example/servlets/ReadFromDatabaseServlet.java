package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.beans.Person;
import com.example.service.PersonService;

/**
 * Servlet implementation class ReadFromDatabaseServlet
 */
@WebServlet("/ReadFromDatabaseServlet")
public class ReadFromDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadFromDatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonService personService=new PersonService();
		System.out.println("im in another servlet");
		PrintWriter writer = response.getWriter();
		writer.println("Hello World!!!");
		
		List<Person> persons = personService.findAll();
		for (Person person_ : persons) {
			System.out.println("-"+person_);
		}
		request.setAttribute("persons", persons);
		request.getRequestDispatcher("/jsps/hosgeldin.jsp").forward(request, response);
		System.out.println("***Transaction Complete!***");
//		System.exit(0);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("im in another servlet");
		doGet(request, response);
	}

}
