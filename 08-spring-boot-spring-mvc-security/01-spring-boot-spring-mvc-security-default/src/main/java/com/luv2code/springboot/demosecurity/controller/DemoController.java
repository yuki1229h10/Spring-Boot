package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * デモ用のコントローラ
 * @author Yuki
 */
@Controller
public class DemoController {

	/**
	 * home.htmlを表示
	 * @return home.html
	 */
	@GetMapping("/")
	public String showHome() {

		return "home";
	}

	/**
	 * leaders.htmlを表示
	 * @return leaders.html
	 */
	@GetMapping("/leaders")
	public String showLeaders() {

		return "leaders";
	}

	/**
	 * systems.htmlを表示
	 * @return systems.html
	 */
	@GetMapping("/systems")
	public String showSystems() {

		return "systems";
	}
}
