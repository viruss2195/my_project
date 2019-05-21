package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.QuestionDaoImpl;
import com.app.pojo.Question_pojo;

@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	private QuestionDaoImpl dao;
	@Override
	public List<Question_pojo> listAllQuestion() {
		
		return dao.showQuestion() ;
	
	}
	
	@Override
	public String getAnswer(int id) {
		
		Question_pojo q=dao.getPojo(id);
		 
		 return q.getAns();
		
	}

}
