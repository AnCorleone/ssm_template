package com.anran.tmall.controller;

import com.anran.tmall.constant.APIResult;
import com.anran.tmall.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/22
 * @time 9:02
 * 描述  测试返回json
 */

@Controller
@RequestMapping("/test")
public class TestJsonController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public APIResult getResult() {
        User user = new User();
        user.setName("user");
        user.setPassword("1234");
        user.setId(1);
        HashMap<String, User> map = new HashMap<>();
        map.put("001", user);
        map.put("002", user);
        //对请求结果进行了包装
        APIResult.createOKMessage("请求成功");
        return APIResult.createOk(map);
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    public APIResult postResult(@RequestParam String name, @RequestParam String pwd) {
        User user = new User();
        user.setName(name);
        user.setPassword(pwd);
        user.setId(1);
        HashMap<String, User> map = new HashMap<>();
        map.put("001", user);
        map.put("002", user);
        //对请求结果进行了包装
        return APIResult.createOk(map);
    }
}
