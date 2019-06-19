package com.td.hscode2.persistent.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    private Integer id;
    private String username;
    private String password;
    private String dep_sort;
    private String position;
    private String classification;
    private String tel;
    private String email;
    private String create_Time;
    private String update_Time;
    private String memo;


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
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Basic
    @Column(name = "dep_sort")
    public String getDep_sort() {
        return dep_sort;
    }

    public void setDep_sort(String dep_sort) {
        this.dep_sort = dep_sort;
    }
    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    @Basic
    @Column(name = "classification")
    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Basic
    @Column(name = "create_Time")
    public String getCreate_Time() {
        return create_Time;
    }

    public void setCreate_Time(String create_Time) {
        this.create_Time = create_Time;
    }
    @Basic
    @Column(name = "update_Time")
    public String getUpdate_Time() {
        return update_Time;
    }

    public void setUpdate_Time(String update_Time) {
        this.update_Time = update_Time;
    }
    @Basic
    @Column(name = "memo")
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dep_sort=" + dep_sort +
                ", position='" + position + '\'' +
                ", classification='" + classification + '\'' +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                ", create_Time='" + create_Time + '\'' +
                ", update_Time='" + update_Time + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
