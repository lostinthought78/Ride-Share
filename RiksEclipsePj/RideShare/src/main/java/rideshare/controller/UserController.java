package rideshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import rideshare.security.SecurityUtils;
import rideshare.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityUtils security;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getProfile(Model model, RedirectAttributes redirectAttrs) {
		model.addAttribute("user", userService.loadUserById(security.getCurrentUserId()));
		model.addAttribute("id", security.getCurrentUserId());
		return "user/profile";
	}
}