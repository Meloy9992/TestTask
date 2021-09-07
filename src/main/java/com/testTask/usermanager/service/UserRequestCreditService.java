package com.testTask.usermanager.service;

import com.testTask.usermanager.model.UserRequestCredit;

import java.util.List;

public interface UserRequestCreditService {
    void addUserRequest(UserRequestCredit userRequestCredit);

    UserRequestCredit getUserById(Long id);

    List<UserRequestCredit> getListAllUser();

    void signCredit(UserRequestCredit userRequestCredit);

    void createRequestCredit(String fullName, int passportData, String maritalStatus,
                             String address, int contactNumber, String employmentInformation,
                             int userCreditAmount);
}
