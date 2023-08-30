package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.AccountImpl;
import dao.IAccount;
import model.Account;

@Controller
public class AccountController {

	IAccount account = new AccountImpl();

	@RequestMapping("view")
	public ModelAndView viewAccount() {
		return new ModelAndView("showAccount", "a", account.viewAccount());
	}

	@RequestMapping("delete")
	public ModelAndView delete(@RequestParam("accountid") long accountid) {
		ModelAndView view = new ModelAndView("showAccount");
		view.addObject("msg", account.delete(accountid));
		view.addObject("a", account.viewAccount());
		return view;

	}

	@RequestMapping("update")
	public ModelAndView update(@RequestParam("accountid") long accountid, @RequestParam("username") String username,
			@RequestParam("mailid") String mailid, @RequestParam("mobileno") long mobileno,
			@RequestParam("accounttype") String accounttype, @RequestParam("balance") double balance,
			@RequestParam("password") String password) {
		ModelAndView view = new ModelAndView("update");
		view.addObject("accountid", accountid);
		view.addObject("username", username);
		view.addObject("mailid", mailid);
		view.addObject("mobileno", mobileno);
		view.addObject("accounttype", accounttype);
		view.addObject("balance", balance);
		view.addObject("password", password);
		view.addObject("a", new Account());
		return view;

	}

	@RequestMapping("updatedValue")
	public ModelAndView updatedValue(@ModelAttribute("a") Account a) {
		ModelAndView view = new ModelAndView("showAccount");
		view.addObject("msg", account.update(a));
		view.addObject("a", account.viewAccount());
		return view;

	}

	@RequestMapping("add")
	public ModelAndView add() {
		return new ModelAndView("add", "a", new Account());

	}

	@RequestMapping("addAccount")
	public ModelAndView addAccount(@ModelAttribute("a") Account a) {
		ModelAndView view = new ModelAndView("showAccount");
		view.addObject("msg", account.add(a));
		view.addObject("a", account.viewAccount());
		return view;

	}
	

}
