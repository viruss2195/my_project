package pojo;

import java.sql.Date;

public class BookShop {
	private int id;
	private String book_name;
	private String author;
	private Double price;
	private Date date_of_pub;
	public BookShop(int id, String book_name,String author, Double price, Date date_of_pub) {
		super();
		this.id = id;
		this.book_name=book_name;
		this.author = author;
		this.price = price;
		this.date_of_pub = date_of_pub;
	}
	public BookShop() {
		// TODO Auto-generated constructor stub
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getDate_of_pub() {
		return date_of_pub;
	}
	public void setDate_of_pub(Date date_of_pub) {
		this.date_of_pub = date_of_pub;
	}
	@Override
	public String toString() {
		return "BookShop [id=" + id + ", author=" + author + ", price=" + price + ", date_of_pub=" + date_of_pub + "]";
	}
	

}
