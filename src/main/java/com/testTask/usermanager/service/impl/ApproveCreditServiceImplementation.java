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

/**
 * Implementation service approve credit
 */
@Service
public class ApproveCreditServiceImplementation implements ApproveCreditService {
    private ApproveCreditDao approveCreditDao;

    @Autowired
    public ApproveCreditServiceImplementation(ApproveCreditDao approveCreditDao) {
        this.approveCreditDao = approveCreditDao;
    }

    /**
     * Add approved credit from Data Base
     *
     * @param approveCredit
     */
    @Override
    public void addApproveCredit(ApproveCredit approveCredit) {
        approveCreditDao.addApproveCredit(approveCredit);
    }

    /**
     * Get List user by Accept Request
     *
     * @return users who have accept request
     */
    @Override
    public List<ApproveCredit> getUserByAcceptRequest() {
        return approveCreditDao.getUserByAcceptRequest();
    }

    /**
     * Get List user by Signed Credit
     *
     * @return users who have signed credit
     */
    @Override
    public List<ApproveCredit> getUserBySignedCredit() {
        return approveCreditDao.getUserBySignedCredit();
    }

    /**
     * Create Approve Credit by User and User Credit Amount
     *
     * @param userRequestCredit User
     * @param userCreditAmount  The credit amount the user is asking
     * @return Approve Credit with random values
     */
    @Override
    public ApproveCredit createApproveCredit(UserRequestCredit userRequestCredit, int userCreditAmount) {
        return approveCreditDao.createApproveCredit(userRequestCredit, userCreditAmount);
    }

    /**
     * search credit by phone or by full name or by passport data
     *
     * @param contactNumber
     * @param passportData
     * @param fullName
     * @return users with matches or the entire list of users if there are no values
     */
    @Override
    public List<UserRequestCredit> searchCreditsByPhoneByFullNameByPassportData(String contactNumber, String passportData, String fullName) {
        return approveCreditDao.searchCreditsByPhoneByFullNameByPassportData(contactNumber, passportData, fullName);
    }
}
