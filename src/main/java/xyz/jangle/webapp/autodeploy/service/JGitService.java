package xyz.jangle.webapp.autodeploy.service;
/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2020年1月3日 上午9:41:03 
* 类说明 
*/
public interface JGitService {
	
	/**
	 * clone code
	 * @throws Exception 
	 */
	void gitClone() throws Exception;
	
	/**
	 * pull code
	 * @throws Exception 
	 */
	void gitPull() throws Exception;
	

}
