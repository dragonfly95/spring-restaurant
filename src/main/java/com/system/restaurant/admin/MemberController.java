package com.system.restaurant.admin;

import com.system.restaurant.LogGetDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(name = "admin")
public class MemberController {

    @RequestMapping(value = "admin/login.do", method = RequestMethod.GET)
    @LogGetDate
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "admin/members.do", method = RequestMethod.GET)
    @LogGetDate
    public String members() {
        return "admin/members";
    }
}
