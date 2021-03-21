package com.system.restaurant.controller;

import com.system.restaurant.domain.*;
import com.system.restaurant.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    /**
     * {
     * "userName": "hongkil dong",
     * "userLogin": "dragonfly95",
     * "userPassword": "123456",
     * "userEmail": "hongkil.dong@gmail.com",
     * "userTye": "waiter"
     * }
     */
    @GetMapping(value = "users")
    public ResponseEntity getUsers() {

        List<UserVO> list = userMapper.selectUsers();
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "users")
    public ResponseEntity createUser(@RequestBody UserVO userVO) {
        int userId = userMapper.createUser(userVO);
        return ResponseEntity.ok(new ResponseVo(200, ResponseVo.OK));
    }


    /**
     * {
     * "userId": 1,
     * "userName": "hongkil dong",
     * "userLogin": "dragonfly95",
     * "userPassword": "123456",
     * "userEmail": "hongkil.dong@gmail.com",
     * "userTye": "waiter"
     * }
     */
    @PutMapping(value = "users/{userId}")
    public ResponseEntity updateUser(@RequestBody UserVO userVO) {
        int affected = userMapper.updateUser(userVO);
        return ResponseEntity.ok(new ResponseVo(200, ResponseVo.OK));
    }

    @DeleteMapping(value = "users/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") int userId) {
        int affected = userMapper.deleteUser(userId);
        return ResponseEntity.ok(new ResponseVo(200, ResponseVo.OK));
    }

    @GetMapping(value = "users/{userId}")
    public ResponseEntity selectOneUser(@PathVariable("userId") int userId) {
        int affected = userMapper.selectOne(userId);
        return ResponseEntity.ok(new ResponseVo(200, ResponseVo.OK));
    }
}
