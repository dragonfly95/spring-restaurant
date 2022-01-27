package com.system.restaurant.service;

import com.system.restaurant.domain.UserVO;
import com.system.restaurant.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public List<UserVO> list() {
        return userMapper.selectUsers();
    }
	public UserVO create() {
		int createUser = userMapper.createUser(null);
		
		return null;
	}
}
