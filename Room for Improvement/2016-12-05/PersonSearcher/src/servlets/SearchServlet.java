package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import person.Person;

@WebServlet(name="SearchServlet", urlPatterns={"/search"})
public class SearchServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchCriteria = req.getParameter("search");
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		
		if(session != null){
			ArrayList<Person> personList = person.Splitter.createPersonList("C:\\Workspace\\person_reader\\names.txt");
			ArrayList<Person> resultList = new ArrayList<>();
			for (Person p : personList) {
				if(p.getName().startsWith(searchCriteria)){
					resultList.add(p);
				}
			}
			
			for (Person p : resultList) {
				out.println(p + "<br>");
			}
		}
	}
}
