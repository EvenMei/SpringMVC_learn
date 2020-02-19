package com.meiyukai.service;

import com.meiyukai.domain.Account;

import java.util.List;


public interface AccountService {

    /**
     * 查询所有的账户
     */
    List<Account> findAllAccounts();


    /**
     * 根据姓名查找账户
     */

    public Account findAccount(String name);


    /**
     * 根据ID修改账户的金额
     */
    public void updateAccountById(Integer id, Double money);


    /**
     * 转账业务的实现
     */
    public void transfer(String from, String to, Double mount);



}
