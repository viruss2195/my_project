package pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {

	private int id;
	private String name;
	private String email;
	private String city;
	private String cell_no;
	private Double reg_amt;
	private LocalDate reg_date;
	private String role;

	public Vendor(int id, String name, String email, String city, String cell_no, Double reg_amt, LocalDate reg_date,
			String role) {
		super();
		this.id = id;
		this.reg_date = reg_date;
		this.name = name;
		this.email = email;
		this.city = city;
		this.cell_no = cell_no;
		this.reg_amt = reg_amt;
		this.role = role;
	}

	public Vendor() {

	}

	public LocalDate getReg_date() {
		return reg_date;
	}

	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
	}

	@Id
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCell_no() {
		return cell_no;
	}

	public void setCell_no(String cell_no) {
		this.cell_no = cell_no;
	}

	public Double getReg_amt() {
		return reg_amt;
	}

	public void setReg_amt(Double reg_amt) {
		this.reg_amt = reg_amt;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", cell_no=" + cell_no
				+ ", reg_amt=" + reg_amt + ", reg_date=" + reg_date + ", role=" + role + "]";
	}

}
