package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.Exam03From;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;
	
	@ModelAttribute
	public Exam03From setUpForm() {
		return new Exam03From();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/totalMoney")
	public String total(Exam03From from) {
		Integer total = from.getProduct1() + from.getProduct2() + from.getProduct3();
		application.setAttribute("total", total);
		
		Integer taxTotal = (int) (total * 1.08);
		application.setAttribute("taxTotal", taxTotal);
		
		return "exam03-result";
	}

}
