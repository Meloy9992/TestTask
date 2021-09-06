package com.testTask.usermanager.service;

import com.testTask.usermanager.model.UserRequestCredit;

import java.util.List;

public interface UserRequestCreditService {
    void addUserRequest(UserRequestCredit userRequestCredit); //Добавление данных от пользователя

    void removeUserRequest(int id); // удаление данных пользователя

    UserRequestCredit getUserById(int id); // получение пользователя по id

    List<UserRequestCredit> listUser(); // получение всех пользователей
}
