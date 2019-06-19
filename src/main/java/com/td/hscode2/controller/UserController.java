package com.td.hscode2.controller;

import com.td.hscode2.common.CommonMsg;
import com.td.hscode2.persistent.entity.User;
import com.td.hscode2.persistent.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    UserRepository userRepository;

    @GetMapping("/list")
    public CommonMsg getList() {
        CommonMsg cm = new CommonMsg();
        cm.setData(userRepository.findAll());
        return cm;
    }

    @GetMapping("/delete")
    @ResponseBody
    public CommonMsg deleteUser(Integer id) {
        CommonMsg cm = new CommonMsg();
        if(null == id) {
            cm.setMsg("参数缺失");
            return cm;
        }
        userRepository.deleteById(id);
        return cm;
    }

    @PostMapping("/add")
    @ResponseBody
    public CommonMsg addList(User user) {
        CommonMsg cm = new CommonMsg();
       userRepository.saveAndFlush(user);
        return cm;
    }

    @PostMapping("/modify")
    public CommonMsg modifyList(User user) {
        return addList(user);
    }
}
