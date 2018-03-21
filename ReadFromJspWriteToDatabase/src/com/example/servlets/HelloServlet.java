package com.example.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.beans.Person;
import com.example.service.PersonService;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonService personService=new PersonService();
		String username = request.getParameter("username");
		String phoneString = request.getParameter("phone");
		int phone=Integer.valueOf(phoneString);
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		String password = request.getParameter("password");
		{
			Person person=new Person();
			person.setUsername(username);
			person.setPhone(phone);
			person.setAddress(address);
			person.setCountry(country);
			person.setPassword(password);
			System.out.println("***Saving to database started***");
			personService.persist(person);
			System.out.println("***Successfully saved to database***");
			System.out.println("***Reading from database***");
			//aþaðýdaki metot ReadFromDatabaseServlet'e taþýndý.
			
//			List<Person> persons = personService.findAll();
//			for (Person person_ : persons) {
//				System.out.println("-"+person_);
//			}
//			request.setAttribute("persons", persons);
		}
//		request.getRequestDispatcher("/ReadFromDatabaseServlet").forward(request, response);
		//servlet'e yönlendirmek için requestDispatcher yerine sendRedirect kullanýlýr.
		System.out.println("sending redirect");
		response.sendRedirect("/ReadFromJspWriteToDatabase/ReadFromDatabaseServlet");
//		request.getRequestDispatcher("/hosgeldin.jsp").forward(request, response);
//		System.exit(0);
	}

}
