package com.meiyukai.service.impl;

import com.meiyukai.dao.IAccountDao;
import com.meiyukai.domain.Account;
import com.meiyukai.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private IAccountDao accountDao;


    public List<Account> findAllAccounts() {
        return accountDao.findAllAccounts();
    }

    /**
     * 查询账户
     * @param name
     * @return
     */
    public Account findAccount(String name) {
        List<Account> accounts = accountDao.findAccountByName(name);
        if(accounts.size()>=1){
            return accounts.get(0);
        }else{
      return null  ;
        }
    }

    public void updateAccountById(Integer id, Double money) {
        accountDao.updateAccountById(id , money);
    }


    /**
     * 转账业务的实现
     */
    public void transfer(String from, String to, Double mount) {
        Account fromAccount  = findAccount(from);
        Account toAccount = findAccount(to);
        if(fromAccount == null  || toAccount==null){
            System.out.println("账户查询有误 !    ");
        }
        else{
            accountDao.updateAccountById(fromAccount.getId() , (fromAccount.getMoney()-mount));
//            int i = 1/0;
            accountDao.updateAccountById(toAccount.getId() , (toAccount.getMoney()+mount));
        }

    }








}
