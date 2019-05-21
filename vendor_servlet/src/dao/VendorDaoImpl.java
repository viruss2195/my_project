package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DButils.ConnectionDB;
import pojo.Vendor;

public class VendorDaoImpl implements IVendorDao {
	Connection cn;
	PreparedStatement pst1,pst2,pst3;

	public VendorDaoImpl() throws Exception {
		cn = ConnectionDB.fetchConnection();
		pst1 = cn.prepareStatement("select * from vendors");
		pst2=cn.prepareStatement("delete from vendors where id=?");
		pst3=cn.prepareStatement("update vendors set city=?,cell_no=? where id=?");
		System.out.println("dao init");

	}


	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		/*
		 * if (pst3 != null) pst3.close(); if (pst4 != null) pst4.close();
		 */
		if (cn != null)
			cn.close();
	}
	
	@Override
	public int updateVendor(String id,String city,String cell) {
		
		try {
			
			pst3.setString(1,city );
			pst3.setString(2, cell);
			pst3.setString(3, id);
			return pst3.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	
	public int deleteVendor(int id)   {
		
		try {
				pst2.setString(1, Integer.toString(id));
				
				return (pst2.executeUpdate());	

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return 0;
		
	}
@Override
public List<Vendor> listVendors() {

		ArrayList<Vendor> list_ven = new ArrayList<>();

		try (ResultSet rst = pst1.executeQuery()) {

			while (rst.next()) 
				list_ven.add(new Vendor(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getDouble(6), rst.getDate(7), rst.getString(8)));
				return list_ven;

			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
