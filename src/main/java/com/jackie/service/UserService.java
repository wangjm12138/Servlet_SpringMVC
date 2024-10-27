package com.jackie.service;

import com.jackie.POJO.User;

import java.util.List;

public interface UserService {

    User findUser(String uname, String password);

    List<User> findAllUser();
}
