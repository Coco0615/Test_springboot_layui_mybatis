package com.pc.controller;

import com.pc.entity.User;
import com.pc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("login")
    @ResponseBody
    public Map login(User user, HttpSession session,String code){
        Map map = new HashMap();
        logger.debug(code);
        String value = (String) session.getAttribute("value");
        logger.debug("1============="+user);
        User user1 = userService.selectByName(user.getNickname());
        if (user1!=null){
            if(user1.getPassword().equals(user.getPassword())){
                if (value.equals(code)){
                    session.setAttribute("user",user);
                    map.put("login",true);
                }else {
                    map.put("login","验证码错误");
                }
            }else {
                map.put("login",false);
            }
        }else {
            map.put("login",false);
        }
        return map;
    }
    @RequestMapping("out")
    public String out(HttpSession session){
        session.invalidate();
        return "redirect:/login.jsp";
    }
}
