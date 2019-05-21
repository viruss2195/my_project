package testers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import daos.VendorDao;
import pojo.Vendor;

public class testerVendorList {

	public static void main(String[] args) {
		try (SessionFactory hf = utils.HibernateUtils.getSf()) {
			VendorDao dao = new VendorDao();
			List<Vendor> list = dao.populateVendor();
			System.out.println("Vendors Are as follows");
			for (Vendor v : list)
				System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
