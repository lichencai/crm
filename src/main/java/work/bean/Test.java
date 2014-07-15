package work.bean;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Test {
	
	public void getRequest(){
		HttpServletRequest request =  
				((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		System.out.println(request.getContextPath());
	}
	
}
