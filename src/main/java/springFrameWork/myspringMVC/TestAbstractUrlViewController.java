package springFrameWork.myspringMVC;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.AbstractUrlViewController;


/**
 * 将请求的url转成对应的view.如：  。。。。/testAbstractUrlViewController  其中的getViewNameForRequest()返回的Stirng 对象，为urlView
 * 则其对应的view为urlView
 */
public class TestAbstractUrlViewController extends AbstractUrlViewController{

	@Override
	protected String getViewNameForRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "urlView";
	}

}
