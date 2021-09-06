package com.testTask.usermanager.dao;

import com.testTask.usermanager.model.UserRequestCredit;

import java.util.List;

public interface UserRequestCreditDao {
    void addUserRequest(UserRequestCredit userRequestCredit);

    List<UserRequestCredit> getListAllUser();

    UserRequestCredit getUserById(Long id);

    void signCredit(UserRequestCredit userRequestCredit);
}
