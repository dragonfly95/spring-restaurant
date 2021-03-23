package com.system.restaurant.controller;

import java.text.DateFormat;
import java.util.*;

import com.system.restaurant.*;
import com.system.restaurant.domain.*;
import com.system.restaurant.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@Autowired
	MenuService menuService;

	@RequestMapping(value = "/menu.do", method = RequestMethod.GET)
	// '/menu' 라는 요청이 들어왔을 때 'menulist' method 를 실행한다
	//public String menulist(Model, model, HttpServletRequest request){
	public String menulist(ModelMap model) {
		ArrayList<Menu> menulist = menuService.menulist(); //== (menu.getMenuName(),,,,);
		model.addAttribute("menulist", menulist);

		return "menulist";
	}

	@LogDate
	@GetMapping(value = "/login.do")
	public String loginPage() {
		return "login";
	}

	@GetMapping(value = "/main.do")
	public String mainPage() {
		return "main";
	}

}
