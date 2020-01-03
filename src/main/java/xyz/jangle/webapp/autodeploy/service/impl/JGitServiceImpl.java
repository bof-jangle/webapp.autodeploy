package xyz.jangle.webapp.autodeploy.service.impl;

import java.io.File;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.stereotype.Service;

import xyz.jangle.webapp.autodeploy.service.JGitService;
import xyz.jangle.webapp.autodeploy.utils.AdUtils;

/**
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2020年1月2日 下午3:54:10 类说明
 */
@Service
public class JGitServiceImpl implements JGitService {

	public String remotePath = "https://github.com/bof-jangle/webapp.git";// 远程库路径
//	public String localPath = "D:/d/g4";// 下载已有仓库到本地路径
	public String localPath = AdUtils.gitWorkspace+"/webapp";// 下载已有仓库到本地路径
//    public String initPath = "D:\\test\\";//本地路径新建

	public static final String username = "274676957@qq.com";
	public static final String password = "github66";

	@Override
	public void gitClone() throws Exception {
		// 设置远程服务器上的用户名和密码
		UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new UsernamePasswordCredentialsProvider(
				username, password);
		// 克隆代码库命令
		CloneCommand cloneCommand = Git.cloneRepository();

		Git git = cloneCommand.setURI(remotePath) // 设置远程URI
				.setBranch("master") // 设置clone下来的分支
				.setDirectory(new File(localPath)) // 设置下载存放路径
				.setCredentialsProvider(usernamePasswordCredentialsProvider) // 设置权限验证
				.call();
		System.out.print(git.tag());
	}

	@Override
	public void gitPull() throws Exception {

		UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new UsernamePasswordCredentialsProvider(
				username, password);
		// git仓库地址
		Git git = new Git(new FileRepository(localPath + "/.git"));
		git.pull().setRemoteBranchName("master").setCredentialsProvider(usernamePasswordCredentialsProvider).call();
		git.close();
	}

//	public static void main(String[] args) {
//		try {
//			new JGitService3().testClone();
//			new JGitServiceImpl().testPull();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (GitAPIException e) {
//			e.printStackTrace();
//		}
//	}

}
