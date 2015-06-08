package hibernate.controller;

import hibernate.service.DemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	
	
	@RequestMapping("/hibernate/demo")
	@ResponseBody
	public void demo(){
		demoService.demo();
	}
}
