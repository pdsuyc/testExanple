package com.zh.chapter.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceView;
@SessionAttributes(value="language")
@Controller
//@RequestMapping(value="/first")
public class MySecondController {
	@PostMapping(value="/one")
	public ModelAndView dopost() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("hello", "the fist method");
		mav.setViewName("XXX.jsp");
		System.out.println("试一试注解能不能用！！");
		return mav;
	}
	@RequestMapping(value="/two")
	public String dopost2(
			@RequestParam(value="language",required=false) String language,
			Model model,
			HttpServletRequest req) {
									
			//model.addAttribute("lang", language);
			System.out.println("language:"+language);
			if(language != null) {
				if(language.equals("zh_CN")) {
					Locale locale = new Locale("zh","CN");
					req.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
					//model.addAttribute(session_locale,locale);
				}else if(language.equals("en_US")){
					Locale locale = new Locale("en","US");					
					req.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
				}
			}		
			
			else {
				req.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
			}
			
		return "login";
	}
	
	@RequestMapping(value="/three")
	public View dopost3() {
		View view = new InternalResourceView("login");
		System.out.println("再试一试注解能不能用！！");
		return view;
	}
}
