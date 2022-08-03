package jp.co.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {
private AdministratorService service;

@ModelAttribute
public InsertAdministratorForm setUpInsertAdministratorForm() {
	InsertAdministratorForm insertAdministratorForm = new InsertAdministratorForm();
	return insertAdministratorForm;
}


@RequestMapping("/toInsert")
public String toInsert() {
	return "agministrator/insert.html";
}














}
