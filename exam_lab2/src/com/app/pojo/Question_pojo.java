package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question_pojo {
	
	private Integer qid;
	private String questions;
	private String opt_a,opt_b,opt_c,opt_d;
	private String ans;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	
	
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String question) {
		this.questions = question;
	}
	
	
	public String getOpt_a() {
		return opt_a;
	}
	public void setOpt_a(String opt_a) {
		this.opt_a = opt_a;
	}
	
	
	public String getOpt_b() {
		return opt_b;
	}
	public void setOpt_b(String opt_b) {
		this.opt_b = opt_b;
	}
	
	
	public String getOpt_c() {
		return opt_c;
	}
	
	
	public void setOpt_c(String opt_c) {
		this.opt_c = opt_c;
	}
	public String getOpt_d() {
		return opt_d;
	}
	
	
	public String getAns() {
		return ans;
	}
	
	
	public void setAns(String ans) {
		this.ans = ans;
	}
	public void setOpt_d(String opt_d) {
		this.opt_d = opt_d;
	}
	@Override
	public String toString() {
		return "Question_pojo [qid=" + qid + ", question=" + questions + ", opt_a=" + opt_a + ", opt_b=" + opt_b
				+ ", opt_c=" + opt_c + ", opt_d=" + opt_d + ", ans=" + ans + "]";
	}
	

}
