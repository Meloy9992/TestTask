package com.testTask.controllers;

import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.usermanager.service.UserRequestCreditServiceImplementation;
import com.testTask.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class MainController {

    private UserRequestCreditServiceImplementation userRequestCreditServiceImplementation;

    @GetMapping("/credit")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/credits")
    public String credit(Model model) {
        model.addAttribute("title", "Страница кредита");
        return "displayAllCredit";
    }

    @PostMapping("/credit")
    public String addUserRequest(@RequestParam String fullName, @RequestParam int passportData,
                                 @RequestParam String maritalStatus, @RequestParam String address,
                                 @RequestParam int contactNumber, @RequestParam String employmentInformation,
                                 @RequestParam int userCreditAmount, Model model) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        UserRequestCredit userRequestCredit = new UserRequestCredit(fullName, passportData, maritalStatus,
                address, contactNumber, employmentInformation, userCreditAmount);
        userRequestCredit.setPermissionCredit(true);

        session.save(userRequestCredit);

        Date date = new Date();
        ApproveCredit approveCredit = new ApproveCredit(userRequestCredit, date, true);

        session.save(approveCredit);

        session.getTransaction().commit();
        session.close();

        return "redirect:/credit";
    }
}