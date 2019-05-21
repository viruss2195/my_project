package daoVendor;

import static utils.HibernateUtils.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Vendor;

public class VendorDao implements IVendorDao {
	
	 public VendorDao() {
		System.out.println("hello i am dao");
	}

	@Override
	public List<Vendor> listVendors() {
		System.out.println("in list vendors");
		List<Vendor> ls = new ArrayList<Vendor>();
		String hpql = "select v from Vendor v";
		System.out.println("before session");

		Session hs = getSf().getCurrentSession();
		System.out.println("after session");
		Transaction tx = hs.beginTransaction();
		try {
			ls = hs.createQuery(hpql, Vendor.class).getResultList();
			System.out.println("before commit");
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("error in listing" + e);
		}

		return ls;
	}

	@Override
	public String registerVendor(Vendor v) {
		String mesg = "Not registerd";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			hs.save(v);
			tx.commit();
			mesg = "ho gaya add lagta hai";
		} catch (Exception e) {
			System.out.println("error in committing" + e);
			if (tx != null)
				tx.rollback();
			
		}

		return mesg;
	}

	@Override
	public String updateVendor(int vendorId, String city, String phone) {
		String mesg = "Not updated";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		Vendor v = null;
		try {
			v = hs.get(Vendor.class, vendorId);
			v.setCity(city);
			v.setCell_no(phone);
			/* hs.update(v); */

			 tx.commit(); 
			mesg = "ho gaya add lagta hai";
		} catch (Exception e) {
			System.out.println("error in registering" + e);
			if (tx != null)
				tx.rollback();
			
		}
		return mesg;
	}

}
