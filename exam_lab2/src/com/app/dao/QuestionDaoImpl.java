package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Question_pojo;


@Repository
public class QuestionDaoImpl implements IQuestionDao {
	@Autowired
	private SessionFactory sf;
	

	@Override
	public List<Question_pojo> showQuestion() 
	{
		String jpql="select q from Question_pojo q";
		
		return sf.getCurrentSession().createQuery(jpql, Question_pojo.class).getResultList();
	}


	@Override
	public Question_pojo getPojo(int id) {
		
		Question_pojo s= sf.getCurrentSession().get(Question_pojo.class, id);
	System.out.println(s);
	return s;
	}
	
	
	
	

}
