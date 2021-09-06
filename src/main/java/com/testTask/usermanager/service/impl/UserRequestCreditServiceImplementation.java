package com.testTask.usermanager.service.impl;

import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.usermanager.service.UserRequestCreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        this.userRequestCreditDao.addUserRequest(userRequestCredit);
    }

    @Override
    public UserRequestCredit getUserById(Long id) {
        return this.userRequestCreditDao.getUserById(id);
    }

    @Override
    public List<UserRequestCredit> getListAllUser() {
        return this.userRequestCreditDao.getListAllUser();
    }

    @Override
    public void signCredit(UserRequestCredit userRequestCredit) {
        this.userRequestCreditDao.signCredit(userRequestCredit);
    }
}
