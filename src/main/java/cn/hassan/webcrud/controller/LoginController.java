package cn.hassan.webcrud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Slf4j
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            session.setAttribute("user","hassan");
            return "redirect:/main.html";
        }else{
            //登陆失败

            map.put("msg","用户名密码错误");
            return  "index";
        }

    }
}