package com.td.hscode2.controller;

import com.td.hscode2.common.CommonMsg;
import com.td.hscode2.common.GlobalConstant;
import com.td.hscode2.persistent.entity.User;
import com.td.hscode2.persistent.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class IndexController implements GlobalConstant {

    @Resource
    UserRepository userRepository;

    @RequestMapping("/")
    public ModelAndView index(HttpSession session) {
        if(null == session.getAttribute(SESSION_ATTR_KEY)) {
            return new ModelAndView("index");
        }
        return home(session);
    }

    @RequestMapping("/home")
    public ModelAndView home(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("admin", session.getAttribute(SESSION_ATTR_KEY));
        return modelAndView;
    }

    @RequestMapping("/login")
    @ResponseBody
    public CommonMsg login(User user, HttpSession session) {

        System.out.println(user.toString());

        CommonMsg cm = new CommonMsg();

        User verifyUser = new User();
        verifyUser.setUsername(user.getUsername());

        Optional<User> userOptional = userRepository.findOne(Example.of(verifyUser));

        if(!userOptional.isPresent()) {
            cm.setMsg("账号不存在");
            return cm;
        }

        verifyUser = userOptional.get();

        System.out.println(verifyUser.toString());

        if(!verifyUser.getPassword().equals(user.getPassword())) {
            cm.setMsg("账号或密码错误");
            return cm;
        }

        session.setAttribute(SESSION_ATTR_KEY, verifyUser);

        return cm;
    }

}
