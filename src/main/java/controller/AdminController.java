package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.AdminImpl;
import dao.IAdmin;
import dao.IUser;
import dao.UserImpl;
import model.Admin;

@Controller
public class AdminController {
	IAdmin admin = new AdminImpl();
	IUser user = new UserImpl();

	@RequestMapping("home")
	public ModelAndView login() {
		return new ModelAndView("home");
	}

	@RequestMapping("admin")
	public ModelAndView admin() {
		return new ModelAndView("adminLogin", "b", new Admin());
	}

	@RequestMapping("adminLogin")
	public ModelAndView adminHome(@ModelAttribute("b") Admin b) {
		ModelAndView mav = null;
		String m = admin.adminLoginValidation(b);

		if (m.equals("Success")) {
			mav = new ModelAndView("adminHome");
		} else {
			mav = new ModelAndView("adminLoginFailed");
		}
		return mav;
	}

	@RequestMapping("viewUser")
	public ModelAndView viewUser() {
		return new ModelAndView("showUser", "u", admin.viewUser());
	}

	@RequestMapping("deleted")
	public ModelAndView deleted(@RequestParam("accountid") long accountid) {
		ModelAndView view = new ModelAndView("showUser");
		view.addObject("msg", user.deleted(accountid));
		// view.addObject("u", user.deleted(accountid));
		view.addObject("u", admin.viewUser());
		return new ModelAndView("showUser", "u", admin.viewUser());

	}

	@RequestMapping("updateAdminPassword")
	public ModelAndView updateAdminPassword(@RequestParam("username") String username) {
		ModelAndView v = new ModelAndView("updateAdminPassword");
		v.addObject("username", username);
		v.addObject("a", new Admin());
		return v;
	}

	@RequestMapping("adminPasswordUpdated")
	public ModelAndView adminPasswordUpdated(@ModelAttribute("a") Admin a) {
		ModelAndView v = new ModelAndView("adminHome");
		a.setUsername(a.getUsername());
		v.addObject("msg", admin.updateAdminPassword(a));
		v.addObject("a", new Admin());
		return v;
	}

}
