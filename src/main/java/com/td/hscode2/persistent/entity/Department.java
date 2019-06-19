package com.td.hscode2.persistent.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    private Integer id;
    private String dep_name;
    private String permission;
    private Integer member;
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
    @Column(name = "dep_name")
    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }
    @Basic
    @Column(name = "permission")
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    @Basic
    @Column(name = "member")
    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }
}
