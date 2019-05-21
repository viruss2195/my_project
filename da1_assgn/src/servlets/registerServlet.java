package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import dao.BookShopDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = (request.getParameter("id"));
		String name = request.getParameter("book_name");
		String auth_name = request.getParameter("auth_name");
		String price = request.getParameter("price");
		String dop = request.getParameter("date_of_pub");
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			BookShopDaoImpl dao = new BookShopDaoImpl();
			boolean b = dao.registration((Integer.parseInt(id)), name, auth_name, (Double.parseDouble(price)),
					Date.valueOf(dop));
			if (b == true)

			{
				pw.print("<h3>Registration un successfull!!!!!</h3>");
				pw.print("<a href='login.html'>Proceed to login</a>");
			}
			else 
			{
				pw.print("<h3>Registration successfull</h3>");
				pw.print("<a href='register.html'>Proceed to login</a>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
