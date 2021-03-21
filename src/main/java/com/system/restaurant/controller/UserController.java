package com.system.restaurant.controller;

import com.system.restaurant.domain.*;
import com.system.restaurant.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.security.*;
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

    /**
     * {
     *     "userLogin": "dragonfly95",
     *     "userPassword": "123456"
     * }
     */
    @PostMapping(value = "mysite/login")
    public ResponseEntity login(@RequestBody LoginVO loginVO, HttpServletRequest request) {
        UserVO userVO = userMapper.loginUser(loginVO.getUserLogin());
        if (userVO == null) {
            throw new RuntimeException("로그인정보가 맞지 않습니다");
        }
        String encrypto = md5(loginVO.getUserPassword());
        if (!encrypto.equals(userVO.getUserPassword())) {
            throw new RuntimeException("패스워드가 맞지 않습니다");
        }

        HttpSession session = request.getSession();
        session.setAttribute("userVO", userVO);

        return ResponseEntity.ok(new ResponseVo(200, ResponseVo.OK));
    }

    public static String md5( String source ) {
        try {
            MessageDigest md = MessageDigest.getInstance( "MD5" );
            byte[] bytes = md.digest( source.getBytes("UTF-8") );
            StringBuffer sb = new StringBuffer();
            for( int i=0; i<bytes.length; i++ )
            {
                byte b = bytes[ i ];
                String hex = Integer.toHexString((int) 0x00FF & b);
                if (hex.length() == 1)
                {
                    sb.append("0");
                }
                sb.append( hex );
            }
            return sb.toString();
        } catch( Exception e )  {
            e.printStackTrace();
            return null;
        }
    }
}
