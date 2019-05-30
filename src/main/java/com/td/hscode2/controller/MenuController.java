package com.td.hscode2.controller;


import com.td.hscode2.common.CommonMsg;
import com.td.hscode2.common.GlobalConstant;
import com.td.hscode2.persistent.entity.Menu;
import com.td.hscode2.persistent.entity.to.MainMenu;
import com.td.hscode2.persistent.repository.MenuRepository;
import com.td.hscode2.utils.CommonUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/menu", method = {RequestMethod.POST, RequestMethod.GET})
public class MenuController implements GlobalConstant {

    @Resource
    MenuRepository menuRepository;

    @GetMapping
    public ModelAndView menu() {
        return new ModelAndView("/items/menu-list");
    }

    /**
     * 获取全部菜单项，子菜单作为父菜单的children
     */
    @GetMapping("/get-menu")
    public List<MainMenu> getMenu(HttpSession session) {
        List<MainMenu> mainMenuList = CommonUtils.getMainMenu(menuRepository.findAllMainMenu());
        for (MainMenu mainMenu : mainMenuList) {
            mainMenu.setChildren(menuRepository.findAllChildrenMenu(mainMenu.getId()));
        }
        return mainMenuList;
    }

    @GetMapping("/list")
    public CommonMsg getMenuList(){
        CommonMsg cm = new CommonMsg();
        cm.setData(menuRepository.findAll());
        return cm;
    }

    @GetMapping("/delete")
    @ResponseBody
    public CommonMsg deleteMenu(Integer id) {
        CommonMsg cm = new CommonMsg();
        if(null == id) {
            cm.setMsg("参数缺失");
            return cm;
        }
        menuRepository.deleteById(id);
        return cm;
    }

    @PostMapping("/add")
    @ResponseBody
    public CommonMsg addMenu(Menu menu) {
        CommonMsg cm = new CommonMsg();
        menuRepository.saveAndFlush(menu);
        return cm;
    }

    @PostMapping("/modify")
    public CommonMsg modifyMenu(Menu menu) {
        return addMenu(menu);
    }
}
