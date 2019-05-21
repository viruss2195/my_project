package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStudentDao;
import com.app.pojo.Student_pojo;

@Service
@Transactional
public class StudentService implements IStudentService {

	@Autowired
	private IStudentDao dao;
	
	
	public Student_pojo validateStudent(String sid) {
		
		return dao.validateStudentDao(sid);
		
	}

}
