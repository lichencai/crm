package exceptionDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.Logger; 

@Controller
public class ControllerDemo {
	
	private static Logger logger = Logger.getLogger(ControllerDemo.class);
	
	@RequestMapping(value = {"/test"})
	public void test() throws Exception{
		
		logger.debug("test...");
		
		throw new Exception("==exception==");
	}
	
	@RequestMapping(value = {"/before"})
	public ModelAndView before(){
		ModelAndView mav = new ModelAndView("exceptionDemo/test");
		return mav;
	}
	
	
	
}
