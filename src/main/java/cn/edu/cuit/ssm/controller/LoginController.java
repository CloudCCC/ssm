package cn.edu.cuit.ssm.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.cuit.ssm.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	@RequestMapping("/login")
	public  String Login(@RequestParam String name ,@RequestParam String pass,Model model) {
		boolean ret =userService.login(name,pass);
		if(ret) {
			return "success";
		}
		else{
			model.addAttribute("msg","用户名或密码错误，请重新输入");	
			return "login";
		}
		
	}
}
