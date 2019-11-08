package servlets;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

/**
 * 
 * Servlet implementation class DBConnectionServlet
 * 
 */

@WebServlet("/DBConnectionServlet")

public class DBConnectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 * 
	 */

	public DBConnectionServlet() {

		super();

	}

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();

		// out.println("<HTML><HEAD><TITLE>My Servlet</TITLE>"+"</HEAD><BODY>");

		Connection conn = null;

		String userName = "root";

		String password = "toor";

		String url = "jdbc:mysql://localhost:3306/world";

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		try {

			conn = (Connection) DriverManager.getConnection(url, userName, password);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		try (PreparedStatement ps = ((java.sql.Connection) conn)
				.prepareStatement("select * from country where Name like ?")) {

			ps.setString(1, "S%");

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					String code = rs.getString("Code");

					String nameVal = rs.getString("Name");

					out.println("<p>" + nameVal + "  ( " + code + " )<p>");

				}

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		// out.println("</BODY></HTML>");

	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub

		doGet(request, response);

	}

}
