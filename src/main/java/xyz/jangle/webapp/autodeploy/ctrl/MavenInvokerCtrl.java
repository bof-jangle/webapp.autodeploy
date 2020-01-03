package xyz.jangle.webapp.autodeploy.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.webapp.autodeploy.service.MavenInvokerService;

/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2020年1月3日 上午10:20:23 
* 类说明 
*/
@Controller
public class MavenInvokerCtrl {
	
	@Autowired
	private MavenInvokerService mavenInvokerService;

	@RequestMapping("/cleanInstall.ctrl")
	@ResponseBody
	public Map<String, Object> cleanInstall(){
		HashMap<String,Object> map = new HashMap<String, Object>();
		try {
			mavenInvokerService.cleanInstall();
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", e.toString());
			return map;
		}
		map.put("result", "success");
		return map;
	}
}
