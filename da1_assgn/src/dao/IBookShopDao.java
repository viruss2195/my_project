package dao;

import java.sql.Date;

public interface IBookShopDao {
	boolean registration(int id, String book_name,String author, Double price, Date date_of_pub)throws Exception;
}
