package com.td.hscode2.controller;

import com.td.hscode2.common.CommonMsg;
import com.td.hscode2.persistent.entity.Link;
import com.td.hscode2.persistent.repository.LinkRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Resource
    LinkRepository linkRepository;

    @RequestMapping()
    public ModelAndView link(){
        return new ModelAndView("/items/custom-link-add");
    }

    @GetMapping("/list")
    public CommonMsg getLinkList(){
        CommonMsg cm = new CommonMsg();
        cm.setData(linkRepository.findAll());
        return cm;
    }

    @GetMapping("/delete")
    public CommonMsg deleteLink(Integer id) {
        CommonMsg cm = new CommonMsg();
        if(null == id) {
            cm.setMsg("该数据不存在");
            return cm;
        }
        linkRepository.deleteById(id);
        return cm;
    }

    @PostMapping("/add")
    public CommonMsg addLink(Link link) {
        CommonMsg cm = new CommonMsg();
        linkRepository.saveAndFlush(link);
        return cm;
    }

    @PostMapping("/modify")
    public CommonMsg modifyLink(Link link) {
        return modifyLink(link);
    }

    @GetMapping
    public CommonMsg update(){
        return null;
    }


}
