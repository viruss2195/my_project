package com.app.service;

import java.util.List;

import com.app.pojo.Question_pojo;

public interface IQuestionService {

		List<Question_pojo> listAllQuestion();
		public String getAnswer(int id) ;
		
}
