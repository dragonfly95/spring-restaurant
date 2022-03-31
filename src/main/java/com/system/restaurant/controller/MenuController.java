package com.system.restaurant.controller;

import com.system.restaurant.domain.*;
import com.system.restaurant.mapper.*;
import com.system.restaurant.service.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MenuController {


    @Autowired
    MenuService menuService;

    /**
     * 메뉴 목록 api
     * @return
     */
    @RequestMapping(value = "/menus")
    public ResponseEntity<ArrayList<Menu>> menulist2() {
        ArrayList<Menu> menulist = menuService.menulist();
        return new ResponseEntity<ArrayList<Menu>>(menulist, HttpStatus.ACCEPTED);
    }

    // 메뉴 1건 조회 시
    //menus?id=1
    //menus/1
    @RequestMapping(value = "/menus/{menu_id}")
    public ResponseEntity<Menu> menuDetail(@PathVariable("menu_id") int menu_id) {
        Menu menu = menuService.findById(menu_id);
        return new ResponseEntity(menu, HttpStatus.ACCEPTED);
    }


    // 메뉴 등록
    // formdata submit => @ModelAttribute Menu menudata
    // json => @RequestBody Menu menudata 테이터의 흐름
    @RequestMapping(value = "/menus", method = RequestMethod.POST)
    public ResponseEntity<Menu> menuPost(@ModelAttribute Menu menudata) {
        int affected = menuService.post(menudata);
        return new ResponseEntity(new Menu(), HttpStatus.OK);
    }


    // 수정
    @RequestMapping(value = "/menus/{menu_id}", method = RequestMethod.PUT)
    public ResponseEntity<Menu> menuPut(@RequestBody Menu menudata) {
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

