package com.testTask.usermanager.service.impl;

import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.usermanager.service.ApproveCreditService;
import com.testTask.usermanager.service.UserRequestCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRequestCreditServiceImplementation implements UserRequestCreditService {

    private UserRequestCreditDao userRequestCreditDao;
    private ApproveCreditService approveCreditService;

    @Autowired
    public UserRequestCreditServiceImplementation(UserRequestCreditDao userRequestCreditDao, ApproveCreditService approveCreditService) {
        this.userRequestCreditDao = userRequestCreditDao;
        this.approveCreditService = approveCreditService;
    }

    @Override
    public void addUserRequest(UserRequestCredit userRequestCredit) {
        userRequestCreditDao.addUserRequest(userRequestCredit);
    }

    @Override
    public UserRequestCredit getUserById(Long id) {
        return userRequestCreditDao.getUserById(id);
    }

    @Override
    public List<UserRequestCredit> getListAllUser() {
        return userRequestCreditDao.getListAllUser();
    }

    @Override
    public void signCredit(UserRequestCredit userRequestCredit) {
        userRequestCreditDao.signCredit(userRequestCredit);
    }

    @Override
    public void createRequestCredit(String fullName, int passportData, String maritalStatus, String address, int contactNumber, String employmentInformation, int userCreditAmount) {
        UserRequestCredit userRequestCredit = new UserRequestCredit(fullName, passportData,
                maritalStatus, address, contactNumber, employmentInformation, userCreditAmount);

        addUserRequest(userRequestCredit);
        ApproveCredit approveCredit = approveCreditService.createApproveCredit(userRequestCredit, userCreditAmount);
        approveCreditService.addApproveCredit(approveCredit);
    }
}
