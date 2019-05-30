package com.td.hscode2.controller;

import com.td.hscode2.common.CommonMsg;
import com.td.hscode2.common.GlobalConstant;
import com.td.hscode2.persistent.entity.User;
import com.td.hscode2.persistent.repository.UserRepository;
import com.td.hscode2.utils.VerifyCode;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
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
        modelAndView.addObject("user", session.getAttribute(SESSION_ATTR_KEY));
        return modelAndView;
    }

    @RequestMapping("/login")
    @ResponseBody
    public CommonMsg login(User user, HttpSession session, String code) {
        System.out.println(user.toString());
        CommonMsg cm = new CommonMsg();
        String text = (String) session.getAttribute(SESSION_VERIFY_KEY);
        if(!text.toLowerCase().equals(code.toLowerCase())) {
            cm.setMsg("验证码错误");
            return cm;
        }
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

    @RequestMapping("/verify")
    public void verifyCode(HttpSession session, HttpServletResponse response) {
        //创建对象
        VerifyCode vc = new VerifyCode();
        //获取图片对象
        BufferedImage image = vc.getImage();
        //获取图片的文本内容
        String text = vc.getText();
        //将系统生成的文本内容保存到session中
        session.setAttribute(SESSION_VERIFY_KEY, text);
        //向浏览器输出图片
        try{
            OutputStream out = response.getOutputStream();
            vc.output(image, out);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session) {
        session.removeAttribute(SESSION_ATTR_KEY);
        return "redirect:/";
    }

}
