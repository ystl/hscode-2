package com.td.hscode2.persistent.entity;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    private Integer id;
    private Integer fatherId;
    private String icon;
    private String menuName;
    private String url;
    private Integer state;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "father_id")
    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "menu_name")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", fatherId=" + fatherId +
                ", icon='" + icon + '\'' +
                ", menuName='" + menuName + '\'' +
                ", url='" + url + '\'' +
                ", state=" + state +
                '}';
    }
}
