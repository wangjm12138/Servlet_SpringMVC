package com.jackie.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.jackie.POJO.Person2;
import com.jackie.POJO.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//对应JackonTest.jsp
@Controller
public class AjaxJsonController {

    @ResponseBody
    @RequestMapping("testAjax")
    public Pet demo(@RequestParam("pname") String pname, @RequestParam("page") String page) throws JsonProcessingException {
        //springmvc会自动把Pet转换成Json格式，伪代码类似如下
        System.out.println(pname+":"+page);
        Pet pet = new Pet("Tom","cat");
//        ObjectMapper mapper = new ObjectMapper();
//        String s = mapper.writeValueAsString(pet);

        return pet;

    }


    //不能用想requestParam那样用两次的requestbody
    //只能在pojo对象里面,如果POJO对象的参数多于入参，后续参数就是null。
    @ResponseBody
    @RequestMapping("testAjax2")
//    public Pet demo2(@RequestBody String pname, @RequestBody String page) throws JsonProcessingException {
     public Pet demo2(@RequestBody Person2 person2) throws JsonProcessingException {

            //springmvc会自动把Pet转换成Json格式，伪代码类似如下
        System.out.println(person2);
        Pet resPet = new Pet("Tom","cat");
//        ObjectMapper mapper = new ObjectMapper();
//        String s = mapper.writeValueAsString(pet);

        return resPet;

    }
}
