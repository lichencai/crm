package springFrameWork.myspringMVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.LastModified;


/**
 * 凡是实现了HandlerAdapter这个接口的类都可以作为Spring的HandlerAdapter
 * spring在进入特定的处理类的时候，先执行spring中所指定的HandlerAdapter,并且通过HandlerAdapter的handle方法进行操作特定的处理类
 * HandlerAdapter主要是处理实现Controller借口的实现类handleRequest调用其中的 方法
 */
public class MyHandlerAdapter implements HandlerAdapter{

	/**
	 * 此处要判断是否是参数Object handler有实现Controller这个接口，只有返回true的时候，才可以使用，否则会抛出异常
	 */
	public boolean supports(Object handler) {
		// TODO Auto-generated method stub
		System.out.println("supports");
		System.out.println(handler);
		return (handler instanceof Controller);
	}

	/**
	 * 其中参数Object handler就是自己实现要处理请求的类
	 */
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("handle");
		// return null;
		return ((Controller) handler).handleRequest(request, response);
	}

	public long getLastModified(HttpServletRequest request, Object handler) {
		// TODO Auto-generated method stub
		System.out.println("getLastModified");
		
		if (handler instanceof LastModified) {
			return ((LastModified) handler).getLastModified(request);
		}
		return -1L;
	}

}
