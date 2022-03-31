package com.system.restaurant.mapper;

import com.system.restaurant.domain.*;

import java.util.*;

public interface UserMapper {
    List<UserVO> selectUsers();

    int createUser(UserVO userVO);

    int updateUser(UserVO userVO);

    int deleteUser(int userId);

    int selectOne(int userId);

    UserVO loginUser(String userLogin);

}
