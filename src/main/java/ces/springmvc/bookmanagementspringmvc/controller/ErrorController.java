package ces.springmvc.bookmanagementspringmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ces.springmvc.bookmanagementspringmvc.constant.MVCCommandNames;

@Controller
public class ErrorController {

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String renderErrorPage(HttpServletRequest httpRequest, Model model) {

		return MVCCommandNames.VIEW_ERROR;
	}

}