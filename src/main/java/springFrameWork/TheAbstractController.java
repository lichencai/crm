package springFrameWork;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.InternalResourceView;

public class TheAbstractController extends AbstractController {
	private String param;
	private String viewPage;

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
		System.out.println(param);
	}

	public String getViewPage() {
		return viewPage;
	}

	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView modelAndview = new ModelAndView();
		View view = new InternalResourceView(getViewPage());
		modelAndview.addObject("param", this.getParam());
		modelAndview.setView(view);
		return modelAndview;
	}

}
