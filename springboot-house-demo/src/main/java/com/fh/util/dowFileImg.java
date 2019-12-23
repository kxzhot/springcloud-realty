package com.fh.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class dowFileImg implements GloableBl {

	//单个上传

	public static Map<String, Object>  getFilePath(HttpServletRequest req, MultipartFile multipartFile ){
		String filePath="";
		//获取上传文件的名字
		String originalFilename = multipartFile.getOriginalFilename();
		//获取名字的后缀
		String suffix = originalFilename.substring(originalFilename.indexOf("."));
		//文件的新名字
		String newFileName=UUID.randomUUID().toString()+suffix;
		//获取一个相对路径
		filePath = FTP_REALPATH+"/"+newFileName;
		//创建一个新文件夹
		File file = new File(req.getRealPath(FTP_REALPATH));
		if(!file.exists()){
			file.mkdirs();
		}
		//创建一个文件流
		FileInputStream fis = null;
		//创建一个客户端
		FTPClient ftpClient = new FTPClient();
		//上传文件
		File tfile = new File(req.getRealPath(FTP_REALPATH),newFileName);
		try {
			//将文件上传到本地服务器
			multipartFile.transferTo(tfile);

			//通过ip地址进行连接  魔法数字
			ftpClient.connect(FTP_IP);
			boolean login = ftpClient.login(FTP_USER,FTP_PWD);
			System.out.println(login+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			if (login){
				//切换工作目录
				boolean  status= ftpClient.changeWorkingDirectory(FTP_REALPATH);
				//判断如果没有，创建文件
				if (status==false){
					ftpClient.makeDirectory(FTP_REALPATH);
				}
				//转换字符集编码
				ftpClient.setControlEncoding("utf-8");
				//创建缓冲区
				ftpClient.setBufferSize(2048);
				//更改二进制流的编码
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				//创建文件上传的流
				fis = new FileInputStream(tfile);
				//进行上传
				ftpClient.storeFile(tfile.getName(), fis);
				//删除本地的文件
				tfile.delete();
			}else{
				System.out.println("没有连接上");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				fis.close();
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("imgName", originalFilename);
		map.put("imgPath", filePath);
		return map;
	}

}
