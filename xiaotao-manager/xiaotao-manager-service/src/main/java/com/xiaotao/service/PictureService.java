package com.xiaotao.service;

import org.springframework.web.multipart.MultipartFile;

import com.xiaotao.common.pojo.PictureResult;

public interface PictureService {

	PictureResult uploadPicture(MultipartFile multipartFile);
}
