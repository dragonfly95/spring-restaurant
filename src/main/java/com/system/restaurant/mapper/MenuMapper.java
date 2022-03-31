package com.system.restaurant.mapper;

import com.system.restaurant.domain.*;

import java.util.*;

public interface MenuMapper {

    ArrayList<Menu> menulist();

    int delete(int menu_id);

    Menu findById(int menu_id);

    int post(Menu menudata);

    int put(Menu menudata);

}
