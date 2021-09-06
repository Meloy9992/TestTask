package com.testTask.controllers;


import com.testTask.usermanager.dao.ApproveCreditDao;
import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.dao.impl.ApproveCreditDaoImplementation;
import com.testTask.usermanager.dao.impl.UserRequestCreditDaoImplementation;
import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.usermanager.service.ApproveCreditService;
import com.testTask.usermanager.service.UserRequestCreditService;
import com.testTask.usermanager.service.impl.UserRequestCreditServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Random;

@Controller
public class MainController {

    private UserRequestCreditService userRequestCreditService;
    private ApproveCreditService approveCreditService;

    @Autowired
    public MainController(UserRequestCreditDao userRequestCreditDao, ApproveCreditDao approveCreditDao) {
        this.userRequestCreditDao = userRequestCreditDao;
        this.approveCreditDao = approveCreditDao;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @PostMapping("/")
    public String userCreditRequest(@RequestParam String fullName, @RequestParam int passportData, @RequestParam String maritalStatus,
                                    @RequestParam String address, @RequestParam int contactNumber, @RequestParam String employmentInformation,
                                    @RequestParam int userCreditAmount) {
//service
        UserRequestCredit userRequestCredit = new UserRequestCredit(fullName, passportData,
                maritalStatus, address, contactNumber, employmentInformation, userCreditAmount);

        userRequestCreditDao.addUserRequest(userRequestCredit);
        ApproveCredit approveCredit = approveCreditDao.createApproveCredit(userRequestCredit, userCreditAmount);
        approveCreditDao.addApproveCredit(approveCredit);
        return "redirect:/displayAllCredit";
    }

}