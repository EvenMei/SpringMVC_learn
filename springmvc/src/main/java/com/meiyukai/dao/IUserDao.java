package com.meiyukai.dao;

import com.meiyukai.domain.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有的用户
     */
    @Select(value = "select * from user")
    List<User> findAllUsers();

    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    @Select(value = "select * from user where id = #{id}")
    User findUserById(@Param(value = "id") Integer id);
}
