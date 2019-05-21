package com.app.dao;

import java.util.List;

import com.app.pojo.Question_pojo;

public interface IQuestionDao {

	
	public List<Question_pojo> showQuestion();
	public Question_pojo getPojo(int id);
}
