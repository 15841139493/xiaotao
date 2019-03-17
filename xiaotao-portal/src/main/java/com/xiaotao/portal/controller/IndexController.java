package com.xiaotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaotao.portal.service.ContentService;

@Controller
public class IndexController {

	@Autowired
	private ContentService contentservice;
	
	
		@RequestMapping("/index")
		public String showIndex(Model model) {
			String json = contentservice.getAd1List();
			
			model.addAttribute("ad1",json);
			return "index";
		}
	}

