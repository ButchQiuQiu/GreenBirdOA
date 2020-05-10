package com.butch.greenbirdoa.pojo;

import java.io.Serializable;

/**
 * 权限类,包含对应的url
 */
public class Authority implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;

    public Authority() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Authority(Integer id, String name) {
        this.id = id;
        this.setName(name);
    }

    @Override
    public String toString() {
        return "Authority [id=" + id + ", name=" + name + "]";
    }
}