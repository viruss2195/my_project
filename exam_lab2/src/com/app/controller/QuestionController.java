package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Question_pojo;
import com.app.service.IQuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
@Autowired
private IQuestionService service;
private int marks=0;

private List<Question_pojo> list=new ArrayList<Question_pojo>();



public QuestionController() {
	System.out.println("in Question controller");
}



@GetMapping
public Question_pojo listQuestion(){
	System.out.println("listing questions");
	list =service.listAllQuestion();
	Random rd=new Random();
	
	Question_pojo q= list.get(rd.nextInt(list.size()));
	q.setAns(null);
	return q;
	}




@PostMapping("/{qid}/{ans}/")
public int answerRecieved(@PathVariable int qid ,@PathVariable String ans,HttpSession hs ) {
		
		System.out.println("ans received");
		
		
		if(service.getAnswer(qid).equals(ans)){
			marks+=1;
			hs.setAttribute("tot_marks", marks);
			
	return marks;	
	}
			return 0;
}



}

