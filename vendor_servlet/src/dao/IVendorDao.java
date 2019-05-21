package dao;

import java.util.List;

import pojo.Vendor;

public interface IVendorDao {
	
	List<Vendor> listVendors();
	int deleteVendor(int id);
	int updateVendor(String id,String city,String cell);

}
