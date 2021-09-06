package com.testTask.usermanager.service;

import com.testTask.usermanager.model.UserRequestCredit;

import java.util.List;

public interface UserRequestCreditService {
    void addUserRequest(UserRequestCredit userRequestCredit);

    UserRequestCredit getUserById(Long id);

    List<UserRequestCredit> getListAllUser();

    void signCredit(UserRequestCredit userRequestCredit);
}
