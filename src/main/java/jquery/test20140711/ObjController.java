package jquery.test20140711;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/obj")
public class ObjController {
	
	
	@RequestMapping(value = "/putdata", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData getInfo(HttpServletRequest request, HttpServletResponse response, RequestData requestData){
		ResponseData responseData = new ResponseData();
		
		System.out.println(requestData.getName());
		System.out.println(requestData.getAddress());
		
		String mesg = requestData.getName() + " in " + requestData.getAddress();
		
		responseData.setMesg(mesg);
		
		return responseData;
	}
	
	
}
