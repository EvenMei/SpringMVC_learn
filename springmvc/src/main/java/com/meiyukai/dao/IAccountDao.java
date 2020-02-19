package com.meiyukai.dao;

import com.meiyukai.domain.Account;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "accountDao")
@CacheNamespace(blocking = true)
public interface IAccountDao {
    /**
     * 查询所有的账户
     */
    @Select(value = "select * from account")
    List<Account> findAllAccounts();

    /**
     * 根据姓名查找账户
     */

    @Select(value = "select * from account where name like '%${name}%'")
    public List<Account> findAccountByName(@Param(value = "name") String name);


    /**
     * 根据ID修改账户的金额
     */
    @Update(value = "update account set money = #{money}  where id = #{id} ")
    public void updateAccountById(@Param(value = "id") Integer id, @Param(value = "money") Double money);



}
