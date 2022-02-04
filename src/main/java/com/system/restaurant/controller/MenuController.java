package com.system.restaurant.controller;

import com.system.restaurant.ValidCustomException;
import com.system.restaurant.domain.*;
import com.system.restaurant.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class MenuController {


    @Autowired
    MenuService menuService;

    @Autowired
    UserService userService;

    /**
     * 메뉴 목록 api
     * @return
     */
    @RequestMapping(value = "/menus")
    public ResponseEntity<ArrayList<Menu>> menulist2(AdminUser adminUser) {
        String role = adminUser.getRole();
        ArrayList<Menu> menulist = menuService.menulist();
        Iterator<Menu> iterator = menulist.iterator();
        while(iterator.hasNext()) {
        	Menu next = iterator.next();
        }
        List<UserVO> users = userService.list();

        return new ResponseEntity<ArrayList<Menu>>(menulist, HttpStatus.ACCEPTED);
    }

    // 메뉴 1건 조회 시
    //menus?id=1
    //menus/1
    @RequestMapping(value = "/menus/{menu_id}")
    public ResponseEntity<Menu> menuDetail(@PathVariable("menu_id") int menu_id, AdminUser adminUser) {
        Menu menu = menuService.findById(menu_id);
        return new ResponseEntity(menu, HttpStatus.ACCEPTED);
    }


    // 메뉴 등록
    // formdata submit => @ModelAttribute Menu menudata
    // json => @RequestBody Menu menudata 테이터의 흐름
    @RequestMapping(value = "/menus", method = RequestMethod.POST)
    public ResponseEntity<Menu> menuPost(@ModelAttribute @Valid Menu menudata/*, BindingResult bindingResult*/) {
//        if (bindingResult.hasErrors()) {
//            throw new ValidCustomException("dsdf");
//        }
        Assert.hasLength(menudata.getMenuName(), "값을 넣어주세요");

        if (menudata.getMenuName().length() == 0) {
            // throw new ValidCustomException();
        }
        int affected = menuService.post(menudata);
        
        return new ResponseEntity(new Menu(), HttpStatus.ACCEPTED);
    }


    // 수정
    @RequestMapping(value = "/menus/{menu_id}", method = RequestMethod.PUT)
    public ResponseEntity<Menu> menuPut(@RequestBody @Valid Menu menudata) {
        int affected = menuService.put(menudata);
        return new ResponseEntity(new Menu(), HttpStatus.ACCEPTED);
    }

    // 삭제
    @RequestMapping(value = "/menus/{menu_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Menu> menuDelete(@PathVariable("menu_id") int menu_id) {
        int affected = menuService.delete(menu_id);
        return new ResponseEntity(new Menu(), HttpStatus.ACCEPTED);
    }
}

