package cn.hassan.webcrud.controller;

import cn.hassan.webcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class WebController {

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>hassan</h1>");
        map.put("users",Arrays.asList("sherry","tom","jack"));
        return "success";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "hello";
    }
}
