package com.mindtree.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class homecontroller {
	@RequestMapping(value="/")
	public String home()
	{
		return "index";
	}

}
