package com.testTask.usermanager.service.impl;

import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.usermanager.service.UserRequestCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRequestCreditServiceImplementation implements UserRequestCreditService {

    private UserRequestCreditDao userRequestCreditDao;

    @Autowired
    public UserRequestCreditServiceImplementation(UserRequestCreditDao userRequestCreditDao) {
        this.userRequestCreditDao = userRequestCreditDao;
    }

    @Override
    public void addUserRequest(UserRequestCredit userRequestCredit) {
        userRequestCreditDao.addUserRequest(userRequestCredit);
    }

    @Override
    public UserRequestCredit getUserById(Long id) {
        return  userRequestCreditDao.getUserById(id);
    }

    @Override
    public List<UserRequestCredit> getListAllUser(){
        return userRequestCreditDao.getListAllUser();
    }

    @Override
    public void signCredit(UserRequestCredit userRequestCredit) {
        userRequestCreditDao.signCredit(userRequestCredit);
    }
}
