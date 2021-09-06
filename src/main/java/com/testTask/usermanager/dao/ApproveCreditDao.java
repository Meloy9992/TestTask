package com.testTask.usermanager.dao;

import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;

import java.util.List;

public interface ApproveCreditDao {
    void addApproveCredit(ApproveCredit approveCredit);

    ApproveCredit createApproveCredit(UserRequestCredit userRequestCredit, int userCreditAmount);

    List<ApproveCredit> getUserByAcceptRequest();

    List<ApproveCredit> getUserBySignedCredit();

    List<UserRequestCredit> searchCreditsByPhoneByFullNameByPassportData(String contactNumber, String passportData, String fullName);
}
