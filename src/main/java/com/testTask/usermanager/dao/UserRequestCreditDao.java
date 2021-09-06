package com.testTask.usermanager.dao;

import com.testTask.usermanager.model.UserRequestCredit;

import java.util.List;

public interface UserRequestCreditDao {
    void addUserRequest(UserRequestCredit userRequestCredit); //Добавление данных от пользователя

    List<UserRequestCredit> getListAllUser();

    UserRequestCredit getUserById(Long id);

    void signCredit(UserRequestCredit userRequestCredit);

}
