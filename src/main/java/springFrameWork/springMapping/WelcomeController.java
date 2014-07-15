package springFrameWork.springMapping;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


/**
 * 测试org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping
 */
public class WelcomeController extends MultiActionController {
	
	public void test(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println("ok");
        }catch(Exception e) {
            out.println("not ok");
        }finally {
            out.close();
        }
    }
	
	
}
