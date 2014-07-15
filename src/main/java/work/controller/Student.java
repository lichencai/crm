package work.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import work.bean.Test;

@Controller
public class Student {
	
	@RequestMapping(value = "/list")
	public ModelAndView getInfo(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/StudentList");
		System.out.println(request.getContextPath());
		return mav;
	}
	
	@RequestMapping(value = "/getRequest")
	public void getRequest(HttpServletRequest request, HttpServletResponse response){
		Test test = new Test();
		test.getRequest();
	}
	
	@RequestMapping(value = "/main")
	public void main(HttpServletRequest request, HttpServletResponse response){
		System.out.println("=========================");
	}
	
}
