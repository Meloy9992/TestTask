package com.testTask.controllers;


import com.testTask.usermanager.dao.ApproveCreditDao;
import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.usermanager.service.ApproveCreditService;
import com.testTask.usermanager.service.UserRequestCreditService;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

import static com.testTask.utils.HibernateUtil.getSessionFactory;

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
        //dao
        Criteria criteria = getSessionFactory().openSession().createCriteria(UserRequestCredit.class);

        if (contactNumber != null && !contactNumber.equals("")) {
            criteria.add(Restrictions.eq("contactNumber", Integer.parseInt(contactNumber)));
        }
        if (passportData != null && !passportData.equals("")) {
            criteria.add(Restrictions.like("passportData", Integer.parseInt(passportData)));
        }
        if (fullName != null && !fullName.equals("")) {
            criteria.add(Restrictions.like("fullName", fullName, MatchMode.START));
        }

        model.addAttribute("search", criteria.list());
        return "searchCreditsByPhoneByFullNameByPassportData";
    }

    @GetMapping("/userById")
    public String displayUser(@RequestParam Long id, Model model) {
        UserRequestCredit userRequestCredit = userRequestCreditService.getUserById(id);
      //  userRequestCreditDao.signCredit(userRequestCredit);
        model.addAttribute("users", userRequestCredit);
        return "usersById";
    }

    @GetMapping("/signCredit")
    public String displayUser(@RequestParam Long id){
        UserRequestCredit userRequestCredit = userRequestCreditService.getUserById(id);
        userRequestCreditService.signCredit(userRequestCredit);
        return "redirect:/userById?id=" + id;
    }

    @GetMapping("/userByAcceptRequest")
    public String displayUserByAcceptRequest(Model model){
        List<ApproveCredit> approveCreditList = approveCreditService.getUserByAcceptRequest();
        model.addAttribute("acceptRequest", approveCreditList);
        return "userByAcceptRequest";
    }

    @GetMapping("/userBySignedCredit")
    public String displayUserBySignedCredit(Model model){
        List<ApproveCredit> approveCreditList = approveCreditService.getUserBySignedCredit();
        model.addAttribute("signedCredit", approveCreditList);
        return "userBySignedCredit";
    }
}
