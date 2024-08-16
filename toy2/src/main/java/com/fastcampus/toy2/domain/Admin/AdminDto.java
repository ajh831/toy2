package com.fastcampus.toy2.domain.Admin;

import java.util.Date;

public class AdminDto {
    private String id;
    private String pwd;
    private String stat;
    private String name;
    private String email;
    private Date createdAt;
    private String createdid;
    private Date updatedAt;
    private String updatedid;

    public AdminDto(String id, String pwd, String stat, String name, String email) {
        this.id = id;
        this.pwd = pwd;
        this.stat = stat;
        this.name = name;
        this.email = email;
        this.createdid = id;
        this.updatedid = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedid() {
        return createdid;
    }

    public void setCreatedid(String createdid) {
        this.createdid = createdid;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedid() {
        return updatedid;
    }

    public void setUpdatedid(String updatedid) {
        this.updatedid = updatedid;
    }
}
