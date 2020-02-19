package com.meiyukai.service;

import com.meiyukai.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有的用户
     */
    List<User> findAllUsers();


    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    User findUserById(Integer id);


}
