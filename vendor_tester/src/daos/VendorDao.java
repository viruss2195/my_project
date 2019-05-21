package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Vendor;

public class VendorDao implements IVendorDao {

	@Override
	public List<Vendor> populateVendor() {
		Session hibses=utils.HibernateUtils.getSf().getCurrentSession();
		Transaction tx=hibses.beginTransaction();
		List<Vendor>list=null;
		try {
			String jpql="select v from Vendor v";
			list=hibses.createQuery(jpql).getResultList();
			
			tx.commit();
			
		}catch (RuntimeException e){
			
			if(tx != null)
				tx.rollback();
		throw e;
		}
		return list;
		
	}

}
