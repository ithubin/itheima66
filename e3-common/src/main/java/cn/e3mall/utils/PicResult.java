package cn.e3mall.utils;

import java.io.Serializable;

public class PicResult implements Serializable{
	
	/*{
        "error" : 0,
        "url" : "http://www.example.com/path/to/file.ext",
        "message":null
		}*/
	private int error;
	//图片上传成功返回图片存储地址
	private String url;
	//图片上传信息
	private String massage;
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	
	

}
