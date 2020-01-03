package xyz.jangle.webapp.autodeploy.service;
/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2020年1月3日 上午9:41:56 
* 类说明 
*/
public interface MavenInvokerService {
	
	/**
	 *  	使用MAVEN进行构建打包
	 * @return
	 */
	String cleanInstall();

}
