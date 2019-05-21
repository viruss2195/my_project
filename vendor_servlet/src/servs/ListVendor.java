package servs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VendorDaoImpl;
import pojo.Vendor;

/**
 * Servlet implementation class ListVendor
 */
@WebServlet("/list")
public class ListVendor extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VendorDaoImpl dao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	public void init() throws ServletException {
		try {
			dao = new VendorDaoImpl();
		} catch (Exception e) {

			throw new ServletException("err in init", e);
		}

	}

	@Override
	public void destroy() {
		System.out.println("dao destroyed...");
		if (dao != null)
			try {
				dao.cleanUp();
			} catch (Exception e) {
				throw new RuntimeException("err in destroy", e);
			}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {

			HttpSession hs = request.getSession();
			hs.setAttribute("dao_inst", dao);
			List<Vendor> vlist= dao.listVendors();
			hs.setAttribute("v_list", vlist);
			
			
			pw.print("<h2> list all vendors </h2>");
			 pw.print("<form action=\"delete\" method=\"get\">"); 
			pw.print("<table style='background-color: cyan; margin: auto'>");
			for (Vendor v :vlist) {

				pw.print("<tr><td>" + v.getName() + "</td><td>  " + v.getEmail() + "  </td>" + "<td>  " + v.getCity()
						+ "  </td>" + "<td>  " + v.getCell_no() + "  </td>"
						+ "<td><input type='submit' name='upd_vendor' value='"+v.getId()+"' formaction='update'/>  UPDATE </td>"
						+ "  <td><input type='submit' name='del_vendor' value='"+v.getId()+"' />  DELETE  </td> "
						+ "</tr>");

			}
			
			pw.print("</table>");
			pw.print("</form>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
