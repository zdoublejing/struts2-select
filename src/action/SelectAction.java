package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
 
public class SelectAction extends ActionSupport{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> searchEngine;
 
	private String yourSearchEngine;
	private String yourMonth;
	private String test;
 
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getYourMonth() {
		return yourMonth;
	}
 
	public void setYourMonth(String yourMonth) {
		this.yourMonth = yourMonth;
	}
 
	public List<String> getSearchEngine() {
		return searchEngine;
	}
 
	public void setSearchEngine(List<String> searchEngine) {
		this.searchEngine = searchEngine;
	}
 
	public String getYourSearchEngine() {
		return yourSearchEngine;
	}
 
	public void setYourSearchEngine(String yourSearchEngine) {
		this.yourSearchEngine = yourSearchEngine;
	}
 
	public String getDefaultSearchEngine() { //这里不需要私有成员都可以将值传人s:select,非常神奇。。。get+大写Abc--〉小写abc
		return "google.com";
	}
 
	public SelectAction(){
		searchEngine = new ArrayList<String>();
		searchEngine.add("google.com");
		searchEngine.add("bing.com");
		searchEngine.add("yahoo.com");
		searchEngine.add("baidu.com");
	}
 
	public String execute() {	        	
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("yourSearchEngine", yourSearchEngine);
		this.setTest("123456");
		request.getSession().setAttribute("test", test);	
		return SUCCESS;
	}
 
	public String display() {

		return NONE;
	}
}