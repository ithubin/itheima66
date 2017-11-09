package cn.e3.fastfs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.utils.FastDFSClient;

public class MyFastDFS {

	/**
	 * 需求:使用fastDFS client 测试文件上传
	 * 
	 * @throws Exception
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void uploadPicWithFastDFSCLient() throws Exception {
		// 指定客户端配置文件地址
		String conf = "E:\\hubin\\javaee66\\itheima66\\"
				+ "e3-manager-web\\src\\main\\resources\\client.conf";
		// 指定上传文件地址
		String pic = "E:\\image\\Penguins.jpg";

		// 加载客户端配置文件,连接远程fastDFS图片服务器
		ClientGlobal.init(conf);

		// 创建调度服务器客户端对象
		TrackerClient tClient = new TrackerClient();
		// 从tracker客户端对象中获取tracker服务调度对象
		TrackerServer trackerServer = tClient.getConnection();

		StorageServer storageServer = null;
		// 创建存储stotage客户端对象
		StorageClient sClient = new StorageClient(trackerServer, storageServer);

		// 上传图片
		String[] urls = sClient.upload_file(pic, "jpg", null);

		for (String url : urls) {

			System.out.println(url);

		}

	}

	/**
	 * 需求:使用fastDFS图片上传测试工具类
	 * @throws Exception 
	 */
	@Test
	public void uploadPicWithFastCLient() throws Exception {
		// 指定客户端配置文件地址
		String conf = "E:\\hubin\\javaee66\\itheima66\\"
				+ "e3-manager-web\\src\\main\\resources\\client.conf";
		// 指定上传文件地址
		String pic = "E:\\image\\Chrysanthemum.jpg";
		
		//创建工具类对象
		FastDFSClient fs = new FastDFSClient(conf);
		
		//直接上传
		String url = fs.uploadFile(pic);
		
		System.out.println(url);
		
	}

}
