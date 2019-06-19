package com.td.hscode2.persistent.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "custom_link")
@Entity
public class Link {
    private String id;
    private String country_name;
    private String link;
    private Date create_time;
    private Date update_time;
    private String image;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Basic
    @Column(name = "country_name")
    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    @Basic
    @Column(name = "create_time")
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    @Basic
    @Column(name = "update_time")
    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id='" + id + '\'' +
                ", country_name='" + country_name + '\'' +
                ", link='" + link + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}