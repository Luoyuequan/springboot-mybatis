package com.spring.mybatis.demo.dao;

import com.spring.mybatis.demo.bean.Demo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author luoyuequan
 * @time 2019/11/29 10:34
 */
public interface DemoDao {
    /**
     * 查询所有
     *
     * @return
     */
    @Select(value = "select id,name from demo")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    List<Demo> getAll();

    /**
     * 根据指定id查询
     *
     * @param id id
     * @return
     */
    /*@Select(value = "select id,name from demo where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })*/
    Demo getById(@Param("id") Long id);

    /**
     * 固定修改
     *
     * @param demo
     * @return
     */
    @Update(value = "update demo set name = #{demo.name} where id = #{demo.id}")
    int updateById(@Param("demo") Demo demo);

    /**
     * 动态修改
     *
     * @param demo
     * @return
     */
    int updateByIdSelective(@Param("demo") Demo demo);

    /**
     * 固定添加
     *
     * @param demo
     * @return
     */
    @Insert(value = "insert into demo (name) values(#{demo.name})")
    int insert(@Param("demo") Demo demo);

    /**
     * 动态性根据值，添加
     *
     * @param demo
     * @return
     */
    int insertSelective(@Param("demo") Demo demo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Delete(value = "delete from demo where id = #{id}")
    int deleteById(@Param("id") Long id);
}
