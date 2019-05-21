package beans;

import java.util.List;

import daoVendor.VendorDao;
import pojo.Vendor;

public class VendorBean {
	private int vid;

	private Vendor ven;
	private List<Vendor> vendorList;
	private VendorDao dao;
	
	
	
	public VendorBean(){
		System.out.println("inside vendor bean initlsng dao");
		System.out.println("hello");
		dao=new VendorDao();
		System.out.println(" dao complete");
	}

	public List<Vendor> getVendorList() {
		return dao.listVendors();
	}
	
	

	public void setVendorList(List<Vendor> vendorList) {
		this.vendorList = vendorList;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	
	public Vendor getVen() {
		return ven;
	}

	public void setVen(Vendor ven) {
		this.ven = ven;
	}


	

	public VendorDao getDao() {
		return dao;
	}

	public void setDao(VendorDao dao) {
		this.dao = dao;
	}

	

}
