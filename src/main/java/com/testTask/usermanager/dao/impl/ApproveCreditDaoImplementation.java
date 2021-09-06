package com.testTask.usermanager.dao.impl;

import com.testTask.usermanager.dao.ApproveCreditDao;
import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.utils.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.testTask.utils.HibernateUtil.getSessionFactory;

@Repository
public class ApproveCreditDaoImplementation implements ApproveCreditDao {
    private static final Logger logger = LoggerFactory.getLogger(UserRequestCreditDao.class);

    @Override
    public void addApproveCredit(ApproveCredit approveCredit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(approveCredit);
        session.getTransaction().commit();
        session.close();
        logger.info("Approve credit was create: " + approveCredit);
    }

    @Override
    public ApproveCredit createApproveCredit(UserRequestCredit userRequestCredit, int userCreditAmount) {
        Date date = new Date();
        Random random = new Random();
        float percent = userCreditAmount * random.nextFloat();
        return new ApproveCredit(userRequestCredit, random.nextBoolean(),
                random.nextInt(365), random.nextInt((int) (userCreditAmount - percent)), date, false);
    }

    @Override
    public List<ApproveCredit> getUserByAcceptRequest() {
        Session session = getSessionFactory().openSession();
        List<ApproveCredit> approveCreditList =
                (List<ApproveCredit>) session.createQuery("FROM ApproveCredit WHERE statusApprovedApplication = " + true).list();
        session.close();
        return approveCreditList;
    }

    @Override
    public List<ApproveCredit> getUserBySignedCredit() {
        Session session = getSessionFactory().openSession();
        List<ApproveCredit> approveCreditList =
                (List<ApproveCredit>) session.createQuery("FROM ApproveCredit WHERE signatureStatus = " + true).list();
        session.close();
        return approveCreditList;
    }
}
