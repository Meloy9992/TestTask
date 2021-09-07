package com.testTask.controllers;


import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.usermanager.service.ApproveCreditService;
import com.testTask.usermanager.service.UserRequestCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *  Controller display credit by AWP Manager
 */
@Controller
public class DisplayCreditController {

    private UserRequestCreditService userRequestCreditService;
    private ApproveCreditService approveCreditService;

    @Autowired
    public DisplayCreditController(UserRequestCreditService userRequestCreditService, ApproveCreditService approveCreditService) {
        this.userRequestCreditService = userRequestCreditService;
        this.approveCreditService = approveCreditService;
    }

    @GetMapping("/displayAllCredit")
    public String displayAllCredit(Model model) {
        model.addAttribute("users", userRequestCreditService.getListAllUser());
        return "displayAllCredit";
    }

    @GetMapping("/searchCreditsByPhoneByFullNameByPassportData")
    public String searchCreditsByPhoneByFullNameByPassportData(Model model) {
        return "searchCreditsByPhoneByFullNameByPassportData";
    }

    @PostMapping("/searchCreditsByPhoneByFullNameByPassportData")
    public String searchCreditsByPhoneByFullNameByPassportData(@RequestParam String contactNumber,
                                                               @RequestParam String passportData, Model model, @RequestParam String fullName) {

        model.addAttribute("search", approveCreditService.searchCreditsByPhoneByFullNameByPassportData(contactNumber, passportData, fullName));
        return "searchCreditsByPhoneByFullNameByPassportData";
    }

    @GetMapping("/userById")
    public String displayUser(@RequestParam Long id, Model model) {
        UserRequestCredit userRequestCredit = userRequestCreditService.getUserById(id);
        model.addAttribute("users", userRequestCredit);
        return "usersById";
    }

    @GetMapping("/signCredit")
    public String displayUser(@RequestParam Long id) {
        UserRequestCredit userRequestCredit = userRequestCreditService.getUserById(id);
        userRequestCreditService.signCredit(userRequestCredit);
        return "redirect:/userById?id=" + id;
    }

    @GetMapping("/userByAcceptRequest")
    public String displayUserByAcceptRequest(Model model) {
        List<ApproveCredit> approveCreditList = approveCreditService.getUserByAcceptRequest();
        model.addAttribute("acceptRequest", approveCreditList);
        return "userByAcceptRequest";
    }

    @GetMapping("/userBySignedCredit")
    public String displayUserBySignedCredit(Model model) {
        List<ApproveCredit> approveCreditList = approveCreditService.getUserBySignedCredit();
        model.addAttribute("signedCredit", approveCreditList);
        return "userBySignedCredit";
    }
}
