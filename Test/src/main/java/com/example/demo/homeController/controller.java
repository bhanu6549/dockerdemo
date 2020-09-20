package com.example.demo.homeController;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class controller {
	@RequestMapping(value="/")
	public String hello()
	{
		return"index";
	}

}
