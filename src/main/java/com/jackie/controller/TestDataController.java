package com.jackie.controller;

import com.jackie.POJO.Person;
import com.jackie.POJO.Person2;
import com.jackie.POJO.Person3;
import com.jackie.POJO.Pet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//Restcontroller可以绕开视图配置器，不然下面success就会去找success.jsp了
//下面第一种方式和servlet耦合度太高，可以用最下面方式，自动帮我们做参数转换了，不需要自己去get
@RestController
public class TestDataController {

    @RequestMapping("getParametersByReq")
    public String getParameters(HttpServletRequest request, HttpServletResponse response){
//        request.getParameterMap().forEach((k,v)->{
//            System.out.println(k+":"+v);
//        });
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username +" password:"+password);
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
//        for (Map.Entry<String, String[]> entry : entries) {
//            String key = entry.getKey();
//            String[] value = entry.getValue();
//            System.out.println(key + "=" + value);
//        }

        return "success";
    }

    //自动参数赋值，如果不加@RequestParam会报错，可能需要再编译时候加入-parameter，这个问题待解决
    //如果参数类型转换失败也会报错
    //@RequestParam既可以获取get请求，也可以获取post请求，但是请求的格式是x-www-form-urlencoding，也就是username=232&password=4242
    //如果要支持json格式需要用@RequestBody
    //

    @RequestMapping("getParametersByNoArg")
    public String getParameters2(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("username:"+username +" password:"+password);


        return "success";
    }

    //POJO对象
    @RequestMapping("getDataByPOJO")
    public String getParameters3(Person person){
        System.out.println(person);
        return "success";
    }

    //单纯的日期对象可以这么转换
    @RequestMapping("getDataByPOJO2")
    public String getParameters4(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthdate){
        System.out.println(birthdate);
        return "success";
    }

    //也可以在POJO的对象里面加注解
    //
    @RequestMapping("getDataByPOJO3")
    public String getParameters5(Person2 person2){
        System.out.println(person2);
//        System.out.println(person2.getPets().get(0).getPetName());
//        System.out.println(pets);
        return "success";
    }

    //可以在POJO对象里面用list和map来获取多个参数，有个问题就是中文怎么办？->post加过滤器，get就是修改tomcatconnector编码
    @RequestMapping("getDataByPOJO4")
    public String getParameters6(Person3 person3){
        System.out.println(person3);
        return "success";
    }


    //可以在POJO对象里面用list和map来获取多个参数，有个问题就是中文怎么办？->post加过滤器，get就是修改tomcatconnector编码
    @RequestMapping("getCookie")
    public String getParameters7(@CookieValue("JSESSIONID") String cookie){
//        System.out.println(person3);
        System.out.println(cookie);
        return "success";
    }
}
