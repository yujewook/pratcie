package com.pratice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {
	@RequestMapping("/2")
	public String home(Model model) {
		model.addAttribute("hi", "안녕 제발 되렴" );
		return "index";
	}
}
