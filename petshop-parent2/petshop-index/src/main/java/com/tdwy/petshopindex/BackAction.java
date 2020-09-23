package com.tdwy.petshopindex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BackAction {
	
	@GetMapping("/back/")
	public  String index() {
		return "index";
	}
	
}