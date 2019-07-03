package com.goldmoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapServiceController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String dashborad() {
		return "index.html";
	}

	@RequestMapping(value = {"/view/**"}, method = RequestMethod.GET)
	public String viewPage() {
		return "index.html";
	}


}
