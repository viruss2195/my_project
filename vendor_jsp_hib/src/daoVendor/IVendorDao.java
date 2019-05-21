package daoVendor;

import java.util.List;

import pojo.Vendor;

public interface IVendorDao {
	
	List<Vendor> listVendors();
	String registerVendor(Vendor v);
	String updateVendor(int vendorId,String city,String phone);

}
