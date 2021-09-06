package com.testTask.usermanager.service.impl;

import com.testTask.usermanager.dao.ApproveCreditDao;
import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.usermanager.service.ApproveCreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApproveCreditServiceImplementation implements ApproveCreditService {
    private static final Logger logger = LoggerFactory.getLogger(UserRequestCreditDao.class);

    @Autowired
    public ApproveCreditServiceImplementation(ApproveCreditDao approveCreditDao) {
        this.approveCreditDao = approveCreditDao;
    }

    private ApproveCreditDao approveCreditDao;

    @Override
    public void addApproveCredit(ApproveCredit approveCredit) {
        approveCreditDao.addApproveCredit(approveCredit);
    }

    @Override
    public List<ApproveCredit> getUserByAcceptRequest() {
        return approveCreditDao.getUserByAcceptRequest();
    }

    @Override
    public List<ApproveCredit> getUserBySignedCredit() {
        return approveCreditDao.getUserBySignedCredit();
    }

    @Override
    public ApproveCredit createApproveCredit(UserRequestCredit userRequestCredit, int userCreditAmount) {
        return approveCreditDao.createApproveCredit(userRequestCredit, userCreditAmount);
    }

    @Override
    public List<UserRequestCredit> searchCreditsByPhoneByFullNameByPassportData(String contactNumber, String passportData, String fullName) {
        return approveCreditDao.searchCreditsByPhoneByFullNameByPassportData(contactNumber, passportData, fullName);
    }
}
