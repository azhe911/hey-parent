package controller;

import org.hey.modle.User;
import org.hey.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	public IUserService userService;

	@RequestMapping(value = "/login")
	@ResponseBody
	public Object login(String userName,String password) {

		User user = userService.findUserByPassword(userName, password);

		return user;
	}
}
