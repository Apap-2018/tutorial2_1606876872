package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String viral() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value= "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value = {"/challenge", "/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		//model.addAttribute("name", name);//
		//return "challenge";//
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
		
	}
	
	@RequestMapping("/generator")
	public String ViralGenerator(@RequestParam(value = "a", required = false, defaultValue = "0") int a, @RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model) {
			String hsl = "";
	
			if(a==0 && b==0) {
				hsl = "hm";
			}
			
			else if(a==0 && b>0) {
				for (int i = 0; i<b; i++) {
					hsl += "hm ";
				}
			}
			
			else if(a>0 && b==0) {
				hsl += "h";
				for (int i =0; i<a; i++) {
					hsl += "m";
				}
			}
			
			else if(a>0 && b>0) {
				hsl += "h";
				for(int i = 0; i<a ; i++) {
					hsl += "m";
				}
				hsl += " ";
				String str = "";
				for(int i = 0; i<b; i++) {
					str+= hsl;
				}
				hsl = str;
			}
			

		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("hasil", hsl);
		return "generator";
}
	
}
