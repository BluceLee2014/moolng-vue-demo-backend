package com.moolng.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/getData")
    public List<String> index(){
        System.out.println("getData");
        String[] strArray = new String[]{"az","bz","cz"};
        List<String> resultList = Arrays.asList(strArray);
        return resultList;
    }

    @GetMapping("/getMenu")
    public List<String> getMenu(){
        System.out.println("getMenu");
        List<String> menuList = new ArrayList();
        menuList.add("Dashboard");
        menuList.add("Email");
        menuList.add("Inbox");
        menuList.add("Email Read");
        menuList.add("Email Compose");
        return menuList;
    }
    static List<User> resultList = new CopyOnWriteArrayList<>();
    static {
        createUser();
    }

    private static void createUser(){
        for(int i=0; i<100; i++){
            User user = new User();
            user.setId(i);
            user.setName("Java"+i);
            user.setAge(i);
            user.setAddress("Sydney No. " + i + " Lake Park");
            resultList.add(user);
        }
    }

    @PostMapping("/getData2")
    public PageInfo getData2(@RequestBody RequestBese requestBese){
        System.out.println("getData2");
        int start = requestBese.getCurrent() - 1;
        int end = requestBese.getCurrent() * requestBese.getPageSize();
        if(start == 0){
            start = 0;
        }else {
            start = start * requestBese.getPageSize();
        }
        if(end > resultList.size()){
            end = resultList.size();
        }
        List<User> data = resultList.subList(start, end);
        return new PageInfo(data, resultList.size(), requestBese);
    }

    @GetMapping("/remove")
    public ResponseInfo remove(int id){
        ResponseInfo responseInfo = new ResponseInfo();
        try{
            resultList.remove(id);
            responseInfo.successResponseInfo(resultList.size());
        }catch (Exception e){
            e.printStackTrace();
            responseInfo.errorResponseInfo();
        }
        return responseInfo;
    }
}
