package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DButils.ConnectionDB;

public class BookShopDaoImpl implements IBookShopDao{
	private Connection cn;
	private PreparedStatement pst1;
	public BookShopDaoImpl() throws Exception {
		this.cn=ConnectionDB.fetchConnection();
		this.pst1=cn.prepareStatement("Insert into book_details values(?,?,?,?,?)");
		System.out.println("dao created");
	}
	@Override
	public boolean registration(int id, String book_name, String author, Double price, Date date_of_pub) throws Exception {
		pst1.setInt(1, id);
		pst1.setString(2, book_name);
		pst1.setString(3, author);
		pst1.setDouble(4, price);
		pst1.setDate(5, date_of_pub);
		if(pst1.executeUpdate()==1)
			{System.out.println("register successfull");
			return true;
			}
		return false;
		
	}
	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
	}

	

}
