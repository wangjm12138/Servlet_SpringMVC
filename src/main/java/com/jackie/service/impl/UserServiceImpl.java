package com.jackie.service.impl;

import com.jackie.POJO.User;
import com.jackie.mapper.UserMapper;
import com.jackie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(String uname, String password) {
        return userMapper.findUser(uname,password);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

}
