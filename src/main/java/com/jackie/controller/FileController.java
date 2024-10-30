package com.jackie.controller;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {


    @ResponseBody
    @RequestMapping("fileUpload")
    public Map<String,String> fileuplaod(@RequestParam("headphoto") MultipartFile headphoto, HttpServletRequest request) throws IOException {
     // public String fileuplaod(MultipartFile headphoto) throws IOException {

        //第一种，是存在磁盘里面
//        File dir = new File("C:/java_workspace");
//        String originalFilename = headphoto.getOriginalFilename();
//
//        File file = new File(dir, originalFilename);
//        headphoto.transferTo(file);

        //第二种，是存webapp里面里面，这样前端可以访问的到
//        String realPath = request.getServletContext().getRealPath("/upload");
//
//        File file = new File(realPath);
//        if(!file.exists()){
//            file.mkdirs();
//        }
//        headphoto.transferTo(file);


        //第三种，是存webapp里面里面，这样前端可以访问的到，并且名字修改未uuid
        Map<String,String> map = new HashMap<String,String>();

//        if(headphoto.getSize() > 1024*1024*5){
//            map.put("message","文件大小不能超过5M");
//            return map;
//        }

        String realPath = request.getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        File dir = new File(realPath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        String originName = headphoto.getOriginalFilename();
        //String extendsName = originName.substring(originName.lastIndexOf("."));
        String extendsName = originName.substring(originName.lastIndexOf("."));

        String newName  = UUID.randomUUID().toString().concat(extendsName);
        File file = new File(dir, newName);
        System.out.println(file.getAbsolutePath());
        headphoto.transferTo(file);

        map.put("message","success");
        map.put("filename", newName);
        map.put("content-type",headphoto.getContentType());

        return map;
    }

    @ResponseBody
    @RequestMapping("fileUpload2")
    public Map<String,String> fileuplaod2(@RequestParam("headphoto") MultipartFile headphoto, HttpServletRequest request) throws IOException {
        Map<String,String> map = new HashMap<String,String>();



        return map;
    }

    @ResponseBody
    @RequestMapping("download")
    public void download(@RequestParam("file") String file, HttpServletRequest request,HttpServletResponse response) throws IOException {
       String realPath = request.getServletContext().getRealPath("/upload");
       File filePath = new File(realPath, file);
       response.setHeader("content-Disposition", "attachment;filename=" + file);
       response.setContentType("image/png");

       FileInputStream fileOut = new FileInputStream(filePath);
       ServletOutputStream outputStream = response.getOutputStream();
       IOUtils.copy(fileOut, outputStream);
    }
}
