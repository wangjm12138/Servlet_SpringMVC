package com.jackie.mapper;


import com.jackie.POJO.User;

import java.util.List;

public interface UserMapper {
    /*
    spring 整合MyBatis思路
    目的就是可以在Service层注入mapper对象
    mapper对象是mybatis生成的
    SqlSession.getMapper()
    */
    User findUser(String uname, String password);

    List<User> findAllUser();
}
