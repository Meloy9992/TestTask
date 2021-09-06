package com.testTask.usermanager.service.impl;

import com.testTask.usermanager.dao.ApproveCreditDao;
import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.usermanager.service.ApproveCreditService;
import com.testTask.utils.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ApproveCreditServiceImplementation implements ApproveCreditService {
    private static final Logger logger = LoggerFactory.getLogger(UserRequestCreditDao.class);

    @Autowired
    public ApproveCreditServiceImplementation(ApproveCreditDao approveCreditDao) {
        this.approveCreditDao = approveCreditDao;
    }

    private ApproveCreditDao approveCreditDao;

    @Override
    public void addApproveCredit(ApproveCredit approveCredit) {
        approveCreditDao.addApproveCredit(approveCredit);
    }

    @Override
    public List<UserRequestCredit> sortedByStatusAccept() {
        return approveCreditDao.
    }

    @Override
    public List<UserRequestCredit> outputAllSignedRequest() {
        return ;
    }


    @Override
    public ApproveCredit createApproveCredit(UserRequestCredit userRequestCredit, int  userCreditAmount){
      return approveCreditDao.createApproveCredit(userRequestCredit, userCreditAmount);
    }
}
