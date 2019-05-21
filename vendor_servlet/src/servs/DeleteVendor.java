package servs;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class DeleteVendor
 */
@WebServlet("/delete")
public class DeleteVendor extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private VendorDaoImpl dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteVendor() {
        
        
    }
   
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		VendorDaoImpl dao=(VendorDaoImpl)hs.getAttribute("dao_inst");
		
		
		
		String v_id=request.getParameter("del_vendor");
		System.out.println(v_id);
		int i=dao.deleteVendor(Integer.parseInt(v_id));
		if(i!=0) {
		response.sendRedirect("list");
		}
		
		
		
	}

	

}
