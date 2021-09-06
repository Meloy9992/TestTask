package com.testTask.usermanager.service;

import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;

import java.util.List;

public interface ApproveCreditService {
    void addApproveCredit(ApproveCredit approveCredit);

    List<ApproveCredit> getUserByAcceptRequest();

    List<ApproveCredit> getUserBySignedCredit();

    ApproveCredit createApproveCredit(UserRequestCredit userRequestCredit, int  userCreditAmount);

    List<UserRequestCredit> searchCreditsByPhoneByFullNameByPassportData(String contactNumber, String passportData, String  fullName);
}
