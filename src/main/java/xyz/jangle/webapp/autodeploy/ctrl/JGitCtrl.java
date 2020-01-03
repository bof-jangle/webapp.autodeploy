package xyz.jangle.webapp.autodeploy.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.jangle.webapp.autodeploy.service.JGitService;

/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2020年1月3日 上午10:13:53 
* 类说明 
*/
@Controller
public class JGitCtrl {
	@Autowired
	private JGitService jGitService;
	
	@RequestMapping("/gitClone.ctrl")
	@ResponseBody
	public Map<String, Object> gitClone(){
		HashMap<String,Object> map = new HashMap<String, Object>();
		try {
			jGitService.gitClone();
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", e.toString());
			return map;
		}
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping("/gitPull.ctrl")
	@ResponseBody
	public Map<String, Object> gitPull(){
		HashMap<String,Object> map = new HashMap<String, Object>();
		try {
			jGitService.gitPull();
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", e.toString());
			return map;
		}
		map.put("result", "success");
		return map;
	}

}
