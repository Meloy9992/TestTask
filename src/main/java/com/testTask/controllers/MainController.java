package com.testTask.controllers;

import com.testTask.usermanager.service.ApproveCreditService;
import com.testTask.usermanager.service.UserRequestCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Main controller by home page
 */
@Controller
public class MainController {

    private UserRequestCreditService userRequestCreditService;
    private ApproveCreditService approveCreditService;

    @Autowired
    public MainController(UserRequestCreditService userRequestCreditService, ApproveCreditService approveCreditService) {
        this.userRequestCreditService = userRequestCreditService;
        this.approveCreditService = approveCreditService;
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

        userRequestCreditService.createRequestCredit(fullName, passportData, maritalStatus,
                address, contactNumber, employmentInformation, userCreditAmount);
        return "redirect:/displayAllCredit";
    }
}