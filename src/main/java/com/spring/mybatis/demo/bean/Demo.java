package com.spring.mybatis.demo.bean;

import java.io.Serializable;

/**
 * demo
 *
 * @author
 */
public class Demo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * name
     */
    private String name;

    public Demo() {
    }

    public Demo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Demo(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}