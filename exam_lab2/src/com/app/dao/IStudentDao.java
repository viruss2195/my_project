package com.app.dao;

import com.app.pojo.Student_pojo;

public interface IStudentDao {

	

	
	public String examStudentEntry(Student_pojo s);
	public Student_pojo validateStudentDao(String uname);

}
