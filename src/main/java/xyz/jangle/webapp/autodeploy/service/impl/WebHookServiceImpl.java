package xyz.jangle.webapp.autodeploy.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import xyz.jangle.webapp.autodeploy.service.JGitService;
import xyz.jangle.webapp.autodeploy.service.MavenInvokerService;
import xyz.jangle.webapp.autodeploy.service.WebHookService;

/**
 * 	通过@EnableAsync + @Async 实现异步执行方法。
 * 
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2020年1月3日 下午4:01:21 类说明
 */
@Service
@EnableAsync
public class WebHookServiceImpl implements WebHookService {

	protected Logger logger = Logger.getLogger(getClass());
	@Autowired
	private JGitService jGitService;
	@Autowired
	private MavenInvokerService mavenInvokerService;

	@Override
	@Async
	public void doHook() {
		/*
		 * 用于第一次对项目进行clone try { jGitService.gitClone(); } catch (Exception e) {
		 * logger.error("已经存在git目录", e); }
		 */
		try {
			logger.info("开始进行pull...");
			jGitService.gitPull();
			logger.info("完成pull，进行maven构建打包");
			mavenInvokerService.cleanInstall();
			logger.info("完成构建与打包");
		} catch (Exception e) {
			logger.error("pull时异常", e);
		}

	}

}
