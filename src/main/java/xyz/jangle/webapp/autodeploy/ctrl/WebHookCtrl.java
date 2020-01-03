package xyz.jangle.webapp.autodeploy.ctrl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.webapp.autodeploy.service.WebHookService;

/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2020年1月3日 上午10:37:07 
* 类说明 
*/
@Controller
public class WebHookCtrl {
	
	protected Logger logger = Logger.getLogger(getClass());
	@Autowired
	private WebHookService webHookService;

	@RequestMapping("webHook.ctrl")
	@ResponseBody
	public void webHook() {
		webHookService.doHook();
	}
}
