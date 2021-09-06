package com.testTask.usermanager.service;

import com.testTask.usermanager.model.UserRequestCredit;

import java.util.List;

public interface UserRequestCreditService {
    void addUserRequest(UserRequestCredit userRequestCredit); //Добавление данных от пользователя

    List<UserRequestCredit> getListAllUser();

    UserRequestCredit getUserById(Long id);

    void signCredit(UserRequestCredit userRequestCredit);
}
