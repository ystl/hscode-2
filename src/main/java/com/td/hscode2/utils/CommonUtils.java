package com.td.hscode2.utils;

import com.td.hscode2.persistent.entity.Menu;
import com.td.hscode2.persistent.entity.to.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

    /**
     * 将menuList改为mainMenuList
     * @param menuList
     * @return
     */
    public static List<MainMenu> getMainMenu(List<Menu> menuList) {
        List<MainMenu> mainMenuList = new ArrayList<>();
        for(Menu menu : menuList) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setId(menu.getId());
            mainMenu.setFatherId(menu.getFatherId());
            mainMenu.setIcon(menu.getIcon());
            mainMenu.setMenuName(menu.getMenuName());
            mainMenu.setUrl(menu.getUrl());
            mainMenu.setState(menu.getState());
            mainMenuList.add(mainMenu);
        }
        return mainMenuList;
    }

}
