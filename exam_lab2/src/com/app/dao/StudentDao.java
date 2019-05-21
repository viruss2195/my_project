package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Student_pojo;

@Repository
public class StudentDao implements IStudentDao {
	@Autowired
	SessionFactory sf;
	
	@Override
	public String examStudentEntry(Student_pojo s) {
		sf.getCurrentSession().save(s);
		return "inserted the Student";
	}

	@Override
	public Student_pojo validateStudentDao(String uname) {
		
		
		
		return sf.getCurrentSession().get(Student_pojo.class,uname );
		
	}

	
}
