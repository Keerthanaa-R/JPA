package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.AccountImpl;
import dao.IAccount;
import dao.IUser;
import dao.UserImpl;
import model.Admin;
import model.User;

@Controller
public class UserController {
	IUser user = new UserImpl();
	IAccount account = new AccountImpl();

	@RequestMapping("user")
	public ModelAndView user() {
		return new ModelAndView("userLogin", "u", new User());
	}

	@RequestMapping("userLogin")
	public ModelAndView userHome(@ModelAttribute("u") User u) {
		ModelAndView view = null;
		String m = user.userLoginValidation(u);
		if (m.equals("Success")) {
			view = new ModelAndView("userHome");
			view.addObject("username", u.getUsername());
		} else {
			view = new ModelAndView("userLoginFailed");
		}
		return view;
	}

	@RequestMapping("viewAccount")
	public ModelAndView viewAccount() {
		return new ModelAndView("showAccountUser", "a", account.viewAccount());
	}

	@RequestMapping("viewDetails")
	public ModelAndView viewUserDetails(@RequestParam("username") String username) {
		ModelAndView view = new ModelAndView("showDetails");
		view.addObject("a", user.viewAccountDetails(username));
		return view;
	}

	@RequestMapping("updateUserPassword")
	public ModelAndView updateUserPassword(@RequestParam("username") String username) {
		ModelAndView v = new ModelAndView("updateUserPassword");
		v.addObject("username", username);
		v.addObject("u", new User());
		return v;
	}

	@RequestMapping("userPasswordUpdated")
	public ModelAndView userPasswordUpdated(@ModelAttribute("u") User u) {
		ModelAndView v = new ModelAndView("userHome");
		u.setUsername(u.getUsername());
		v.addObject("msg", user.updateUserPassword(u));
		v.addObject("u", new User());
		return v;
	}
}
