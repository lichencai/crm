package exceptionDemo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dubbo.demo.DemoService;

@Controller
public class ControllerDemo {
	
	private static Logger logger = Logger.getLogger(ControllerDemo.class);
	
	@Autowired
	private DemoService demoService;
	
	
	@RequestMapping(value = {"/test"})
	public void test() throws Exception{
		
		logger.debug("test...");
		
		throw new Exception("==exception==");
	}
	
	@RequestMapping(value = {"/before"})
	public ModelAndView before(){
		ModelAndView mav = new ModelAndView("exceptionDemo/test");
		
		String s = demoService.sayHello("leo");
		System.out.println(s);
		
		return mav;
	}
	
	
	
}
