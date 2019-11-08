package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import filters.TestFilter;
import listeners.TestListener;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(name = "myServlet", urlPatterns = "/myservlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();

		// On utilise les etats pour stocker des informations temporaires car HTTP n'est pas un protocole a etat
		HttpSession session = (HttpSession) request.getSession();

		String first = "John E.";
		String last = "Sampleman";

		session.setAttribute("Firstname", first);
		session.setAttribute("Lastname", last);

//		Map<String, String[]> mapParameters = request.getParameterMap();

		PrintWriter out = response.getWriter();

		out.append("<h1>Hello World!</h1>");
		out.append("<p>ContextPath : " + contextPath + "</p>");
		out.append("<p>ServletPath : " + servletPath + "</p>");
		out.append("<p>PathInfo : " + pathInfo + "</p>");

		Enumeration<String> ee = request.getParameterNames();

		while (ee.hasMoreElements()) {
			String name = (String) ee.nextElement();
			out.append("<p>" + name + ": " + request.getParameter(name) + "</p>");
		}

		out.append("<h2>Header values</h2>");

		Enumeration<String> headerNames = request.getHeaderNames();

		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			String headerValue = request.getHeader(headerName);

			out.append(String.format("<p>Header: %s, valeur: %s", headerName, headerValue));
		}

		Enumeration<String> sessionEE = (Enumeration<String>) session.getAttributeNames();

		out.append("<br>");

		String tmp;
		while (sessionEE.hasMoreElements()) {
			String att = (String) sessionEE.nextElement();
			tmp = (String) session.getAttribute(att);
			out.println(att + "= " + tmp + "<br>");
		}
		
		Cookie cookie = new Cookie("myCookie", "value");
		cookie.setMaxAge(100 * 1000 * 60); //100 seconds
		response.addCookie(cookie);
		
		Cookie[] cookies = request.getCookies();
		
		for (Cookie c : cookies) {
			out.println("name=" + c.getName() + " value=" + c.getValue());
		}
		
		TestListener listener = new TestListener();
		
		TestFilter filter = new TestFilter();

//		Set<Entry<String, String[]>> setParameters = mapParameters.entrySet();
//		
//		for (Entry<String, String[]> entry : setParameters) {
//			out.append("<p>" + entry.getKey() + " : " + Arrays.toString(entry.getValue()) + "</p>");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
