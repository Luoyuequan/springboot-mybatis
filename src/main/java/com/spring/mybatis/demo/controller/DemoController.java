package com.spring.mybatis.demo.controller;

import com.spring.mybatis.demo.bean.Demo;
import com.spring.mybatis.demo.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luoyuequan
 * @time 2019/11/29 10:41
 */
@RestController
@RequestMapping
public class DemoController {
    @Autowired(required = false)
    DemoDao demoDao;

    @RequestMapping
    public List<Demo> getAll() {
        return demoDao.getAll();
    }

    @RequestMapping(value = "getById/{id}")
    public Demo getById(@PathVariable Long id) {
        return demoDao.getById(id);
    }

    @RequestMapping(value = "updateById/{id}/{name}")
    public String updateById(@PathVariable Long id, @PathVariable String name) {
        Demo demo = new Demo(id, name);
        if (demoDao.updateById(demo) == 1) {
            return "successfully";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "updateByIdSelective")
    public String updateByIdSelective(@PathVariable Long id, @PathVariable(required = false) String name) {
        Demo demo = new Demo(id, name);
        if (demoDao.updateByIdSelective(demo) == 1) {
            return "successfully";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "insert/{name}")
    public String insert(@PathVariable String name) {
        Demo demo = new Demo(name);
        if (demoDao.insert(demo) == 1) {
            return "successfully";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id) {
        if (demoDao.deleteById(id) == 1) {
            return "successfully";
        } else {
            return "fail";
        }
    }
}
