package com.xiaotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaotao.common.pojo.PictureResult;
import com.xiaotao.service.PictureService;
import com.xiaotao.utils.JsonUtils;

@Controller
public class PictureController {
	
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {
		PictureResult result = pictureService.uploadPicture(uploadFile);
		//把java对象手转换成json数据
		String json = JsonUtils.objectToJson(result);
		return json;
	}

}
