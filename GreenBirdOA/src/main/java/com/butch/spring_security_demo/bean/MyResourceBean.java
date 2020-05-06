package com.butch.spring_security_demo.bean;

import org.springframework.stereotype.Component;

/**
 * Created by wxb on 2018/10/27 0027.
 * 资源表resource对应的类
 */
@Component
public class MyResourceBean {
    private Long id;
    private String url;
    private String roles;


    public String[] getRolesArray(){
        String[] authorities = roles.split(",");
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "MyResourceBean [id=" + id + ", roles=" + roles + ", url=" + url + "]";
    }
    

}
