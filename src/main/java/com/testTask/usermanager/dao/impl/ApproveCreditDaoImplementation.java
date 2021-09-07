package com.testTask.usermanager.dao.impl;

import com.testTask.usermanager.dao.ApproveCreditDao;
import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.testTask.utils.HibernateUtil.getSessionFactory;

/**
 * Implementation approve credit and putting it into the database
 */
@Repository
    public class ApproveCreditDaoImplementation implements ApproveCreditDao {
    private static final Logger logger = LoggerFactory.getLogger(UserRequestCreditDao.class);

    /**
     * Add approved credit
     *
     * @param approveCredit
     */
    @Override
    public void addApproveCredit(ApproveCredit approveCredit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(approveCredit);
        session.getTransaction().commit();
        session.close();
        logger.info("Approve credit was create: " + approveCredit);
    }

    /**
     * Create Approve Credit by Current Date,
     * Random percent,
     * Random status approved Request,
     * Random accept number of days 0 - 365,
     * Random approve Credit by Random percent,
     * and default signature Status = false
     *
     * @param userRequestCredit User
     * @param userCreditAmount  The credit amount the user is asking
     * @return Approve Credit with random values
     */
    @Override
    public ApproveCredit createApproveCredit(UserRequestCredit userRequestCredit, int userCreditAmount) {
        Date date = new Date();
        Random random = new Random();
        float percent = userCreditAmount * random.nextFloat();
        return new ApproveCredit(userRequestCredit, random.nextBoolean(),
                random.nextInt(365), random.nextInt((int) (userCreditAmount - percent)), date, false);
    }

    /**
     * Get List user by Accept Request from Data Base with createQuery
     *
     * @return users who have accept request
     */
    @Override
    public List<ApproveCredit> getUserByAcceptRequest() {
        Session session = getSessionFactory().openSession();
        List<ApproveCredit> approveCreditList =
                (List<ApproveCredit>) session.createQuery("FROM ApproveCredit WHERE statusApprovedApplication = " + true).list();
        session.close();
        return approveCreditList;
    }

    /**
     * Get List user by Signed Credit from Data Base with createQuery
     *
     * @return users who have signed credit
     */
    @Override
    public List<ApproveCredit> getUserBySignedCredit() {
        Session session = getSessionFactory().openSession();
        List<ApproveCredit> approveCreditList =
                (List<ApproveCredit>) session.createQuery("FROM ApproveCredit WHERE signatureStatus = " + true).list();
        session.close();
        return approveCreditList;
    }

    /**
     * Search credit by phone or by full name or by passport data
     * full name can be introduced partially
     *
     * @param contactNumber
     * @param passportData
     * @param fullName
     * @return users with matches or the entire list of users if there are no values
     */
    @Override
    public List<UserRequestCredit> searchCreditsByPhoneByFullNameByPassportData(String contactNumber, String passportData, String fullName) {
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
        return criteria.list();
    }
}

