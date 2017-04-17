package com.wenhua.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wenhua.base.web.controller.BaseController;

@Controller
@RequestMapping
public class HomeController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@RequestMapping(value = {"", "/", "/index"}, method = {RequestMethod.GET})
    public ModelAndView index(HttpServletRequest request, ModelMap model) {

        model.addAttribute("name", "Junney");
        return view("/index.ftl", model);
    }

    @RequestMapping(value = "/404")
    public ModelAndView pageNotFound(ModelMap model) {
        return view("/404.ftl", model);
    }

    @RequestMapping(value = "/403")
    public ModelAndView noPermission(ModelMap model) {
        return view("/403.ftl", model);
    }
}
