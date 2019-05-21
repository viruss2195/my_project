package servs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VendorDaoImpl;
import pojo.Vendor;

/**
 * Servlet implementation class UpdateVendor
 */
@WebServlet("/update")
public class UpdateVendor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession hs = request.getSession();

			VendorDaoImpl dao = (VendorDaoImpl) hs.getAttribute("dao_inst");
			String id = request.getParameter("upd_vendor");

			hs.setAttribute("vid", id);

			pw.print("<form action=\"update_serv\" method=\"get\">");
			pw.print("<table style='background-color: cyan; margin: auto'>");

			pw.print("<tr><td>" + "NAME" + "</td><td>  " + "<input type='text' name='name' value=''/>  </td></tr>"
					+ "<tr><td>  " + "CITY" + "<input type='text' name='city' value=''/>" + "  </td></tr>"
					+ "<tr><td>  " + "CELL NO:" + "  </td><td> "
					+ "<input type='text' name='cellno' value=''/> </td></tr>"
					+ "<tr><td><input type='submit' name='upd_vendor' value='" + id
					+ "' formaction=''/>  UPDATE </td></tr></table>" + "</form>");

			/*
			 * RequestDispatcher r = request.getRequestDispatcher("update_serv");
			 * r.forward(request, response);
			 */

		}
	}

}
