package com.xiaotao.service.impl;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xiaotao.common.pojo.PictureResult;
import com.xiaotao.service.PictureService;
import com.xiaotao.utils.FastDFSClient;

@Service
public class PictureServiceImpl implements PictureService {
	@Value("${IMAGE_SERVER_BASE_URL}")
	private String IMAGE_SERVER_BASE_URL;
	
	
	@Override
	public PictureResult uploadPicture(MultipartFile file) {
				
		PictureResult result = new PictureResult();
		
		if (file.isEmpty()) {
			
			result.setError(1);
			result.setMessage("图片不存在");
			return result;
		}
		//上传到图片服务器
				try {
					//取图片扩展名
					String originalFilename = file.getOriginalFilename();
					//取扩展名不要“.”
					String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
					FastDFSClient client = new FastDFSClient("classpath:properties/client.conf");
					String url = client.uploadFile(file.getBytes(), extName);
					url = IMAGE_SERVER_BASE_URL + url;
					//把url响应给客户端
					result.setError(0);
					result.setUrl(url);
				} catch (Exception e) {
					e.printStackTrace();
					result.setError(1);
					result.setMessage("图片上传失败");
				}
				return result;
			}


}
