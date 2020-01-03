package xyz.jangle.webapp.autodeploy.service.impl;

import java.io.File;
import java.util.Collections;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.springframework.stereotype.Service;

import xyz.jangle.webapp.autodeploy.service.MavenInvokerService;
import xyz.jangle.webapp.autodeploy.utils.AdUtils;

/**
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2020年1月3日 上午8:55:24 类说明
 */
@Service
public class MavenInvokerServiceImpl implements MavenInvokerService {

	/** pom.xml路径 */
//	public static final String pomPath = "D:/d/g4/pom.xml";
	public static final String pomPath = AdUtils.gitWorkspace+"/webapp/pom.xml";

	/** maven命令  */
	public static final String cmd = "clean install -Pproduct -Dmaven.test.skip=true";

	/** maven目录  */
//	public static final String mavenHome = "D:/apache-maven-3.5.3";
	public static final String mavenHome = "/opt/maven-3.5.4";

	@Override
	public String cleanInstall() {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(new File(pomPath));
		request.setGoals(Collections.singletonList(cmd));
		Invoker invoker = new DefaultInvoker();
		invoker.setMavenHome(new File(mavenHome));
		try {
			if (invoker.execute(request).getExitCode() == 0) {
				return "success";
			} else {
				return "error";
			}
		} catch (MavenInvocationException e) {
			e.printStackTrace();
		}
		return "error";
	}

	public static void main(String[] args) {

//		InvocationRequest request = new DefaultInvocationRequest();
//		request.setPomFile(new File("D:/d/g4/pom.xml"));
//		request.setGoals(Collections.singletonList("clean install -Pproduct -Dmaven.test.skip=true"));
//		Invoker invoker = new DefaultInvoker();
//		invoker.setMavenHome(new File("D:/apache-maven-3.5.3"));
//		try {
//			if (invoker.execute(request).getExitCode() == 0) {
//				System.out.println("success");
//			} else {
//				System.err.println("error");
//			}
//		} catch (MavenInvocationException e) {
//			e.printStackTrace();
//		}
	}

}
