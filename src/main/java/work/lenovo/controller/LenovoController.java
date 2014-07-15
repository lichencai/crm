package work.lenovo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import work.lenovo.request.LenovoRequest;
import work.lenovo.response.LenovoResponse;

@Controller
public class LenovoController {
	
	@RequestMapping("/lenovo/getlist")
	@ResponseBody
	public LenovoResponse getlist(LenovoRequest request){
		int page = request.getPage();
		System.out.println(page);
		LenovoResponse res = new LenovoResponse();
		res.setName("lenovo");
		return res;
	}
	
}
