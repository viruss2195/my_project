package servs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VendorDaoImpl;

/**
 * Servlet implementation class UpdatingServletVendor
 */
@WebServlet("/update_serv")
public class UpdatingServletVendor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside updating");
		HttpSession hs = request.getSession();
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String cell = request.getParameter("cellno");
		String id = (String)hs.getAttribute("vid");
		System.out.println(name + city + cell + id);

		VendorDaoImpl dao = (VendorDaoImpl) hs.getAttribute("dao_inst");
		System.out.println("after dao");
		/* dao.updateVendor(id, city, cell); */
		int i = dao.updateVendor(id, city, cell);
		System.out.println("updated vendor");

		if (i != 0)
			response.sendRedirect("list");

	}

}
