package com.samcancode.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping({"","/","home","home page","home","Home"})
	public String index() {
		return "index";
	}
}
