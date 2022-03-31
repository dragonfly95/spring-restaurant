package com.system.restaurant.service;

import com.system.restaurant.domain.*;
import com.system.restaurant.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public ArrayList<Menu> menulist() {
        return menuMapper.menulist();
    }

    public int delete(int menu_id) {
        return menuMapper.delete(menu_id);
    }

    public int put(Menu menudata) {
        return menuMapper.put(menudata);
    }

    public int post(Menu menudata) {
        return menuMapper.post(menudata);
    }

    public Menu findById(int menu_id) {
        return menuMapper.findById(menu_id);
    }
}
