package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.utils.FastDFSClient;
import cn.e3mall.utils.JsonUtils;
import cn.e3mall.utils.PicResult;

@Controller
public class UploadController {
	
	//注入图片服务器地址常量信息
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	/**
	 * 需求:上传图片
	 * 请求:/pic/upload
	 * 参数:uploadFile
	 * 返回值:
	 * //成功时
		{
        "error" : 0,
        "url" : "http://www.example.com/path/to/file.ext",
        "message":null
		}
		//失败时
		{
        "error" : 1,
        "url":null,
        "message" : "错误信息"
		}
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadPic(MultipartFile uploadFile){
		
		try {
			
			//获取文件名称
			String originalFilename = uploadFile.getOriginalFilename();
			//截取扩展名
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			
			//创建fastDFS工具类对象
			FastDFSClient fs = new FastDFSClient("classpath:client.conf");
			//上传成功 返回图片存储地址(虚拟磁盘地址) /group1/M00/00/00/wKgZhVYibZWAGBImAAIeJ5_DVCc105.jpg
			String url = fs.uploadFile(uploadFile.getBytes(), extName);
			
			//把服务器ip和虚拟磁盘路径进行组合,组合绝对路径地址
			url = IMAGE_SERVER_URL+url;
			
			//上传图片成功
			//创建图片上传返回值对象PicResult
			PicResult result = new PicResult();
			result.setError(0);
			result.setUrl(url);
			
			//把对象转换成json字符串
			String picJson = JsonUtils.objectToJson(result);
			
			return picJson;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//上传失败
			//创建图片上传返回值对象PicResult
			PicResult result = new PicResult();
			result.setError(1);
			result.setMassage("上传失败");
			
			//把对象转换成json字符串
			String picJson = JsonUtils.objectToJson(result);
			
			return picJson;
			
			
		}
	}

}
