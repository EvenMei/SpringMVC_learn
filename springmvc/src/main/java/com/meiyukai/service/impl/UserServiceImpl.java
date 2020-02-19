package com.meiyukai.service.impl;

import com.meiyukai.dao.IUserDao;
import com.meiyukai.domain.User;
import com.meiyukai.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private IUserDao userDao;

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }
}
