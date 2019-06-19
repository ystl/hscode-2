package com.td.hscode2.controller;

import com.td.hscode2.common.CommonMsg;
import com.td.hscode2.persistent.entity.Link;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkControllerTest {
    @Resource
    LinkController linkController;

    @Test
    public void addLink() {
        Link link = new Link();
        link.setLink("www.teggs.com");
        CommonMsg link1 = linkController.addLink(link);
        System.out.println(link1.toString());
    }
}