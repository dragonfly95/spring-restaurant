package com.system.restaurant.admin;

import com.system.restaurant.LogGetDate;
import com.system.restaurant.domain.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping(name = "admin")
public class MemberController {

    @RequestMapping(value = "admin/login.do", method = RequestMethod.GET)
    @LogGetDate
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("admin", new AdminUser("developer"));
        return "admin/login";
    }

    @RequestMapping(value = "admin/members.do", method = RequestMethod.GET)
    @LogGetDate
    public String members(AdminUser adminUser) {
        System.out.println("adminUser = " + adminUser.getRole());
        return "admin/members";
    }
}
