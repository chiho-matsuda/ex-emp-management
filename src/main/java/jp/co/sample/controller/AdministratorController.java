package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratorService service;
	
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		InsertAdministratorForm insertAdministratorForm = new InsertAdministratorForm();
		return insertAdministratorForm;
	}

	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}

	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator();
		administrator.getId();
		administrator.getName();
		administrator.getMailAddress();
		administrator.getPassword();
		service.insert(administrator);
		return "/";
	}

	@ModelAttribute
	public LoginForm setUpLoginForm() {
		LoginForm loginForm = new LoginForm();
		return loginForm;
	}

//
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}

@Autowired
	private HttpSession session;
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administrator admin = service.login(form.getMailAddress(),form.getPassword());
		
		if (admin == null) {
			System.out.println("メールアドレスまたはパスワードが不正です。");
			return toLogin();
		}else {
			session.setAttribute("administratorName", model);
			return "forward:/employee/showList";
		}
	
	}
}