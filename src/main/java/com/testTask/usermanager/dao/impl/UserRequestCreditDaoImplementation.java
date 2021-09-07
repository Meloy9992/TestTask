package com.testTask.usermanager.dao.impl;

import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.testTask.utils.HibernateUtil.getSessionFactory;

@Repository
public class UserRequestCreditDaoImplementation implements UserRequestCreditDao {
    private static final Logger logger = LoggerFactory.getLogger(UserRequestCreditDao.class);

    /**
     * Add user Request from Data Base
     *
     * @param userRequestCredit
     */
    @Override
    public void addUserRequest(UserRequestCredit userRequestCredit) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(userRequestCredit);
        session.getTransaction().commit();
        session.close();
        logger.info("User successfully saved. User details: " + userRequestCredit);
    }

    /**
     * Get List User Request Credit
     *
     * @return
     */
    @Override
    public List<UserRequestCredit> getListAllUser() {
        try {
            Criteria criteria = getSessionFactory().openSession().createCriteria(UserRequestCredit.class);
            List<UserRequestCredit> users = criteria.list();
            return users;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * Get one user by Id from Data Base with createQuery
     * And logged successfully loaded
     *
     * @param id
     * @return UserRequestCredit
     */
    @Override
    public UserRequestCredit getUserById(Long id) {
        Session session = getSessionFactory().openSession();
        UserRequestCredit userRequestCredit = (UserRequestCredit)
                session.createQuery("FROM UserRequestCredit WHERE idRequestUsers = " + id).list().get(0);
        session.close();
        logger.info("User successfully loaded. User details: " + userRequestCredit);
        return userRequestCredit;
    }

    /**
     * Changes the one user's signing credit status
     * And logged successfully loaded
     *
     * @param userRequestCredit
     */
    @Override
    public void signCredit(UserRequestCredit userRequestCredit) {
        Session session = getSessionFactory().openSession();
        ApproveCredit approveCreditCurrentUser = userRequestCredit.getApproveCredits().get(0);
        if (!approveCreditCurrentUser.isSignatureStatus()) {
            session.beginTransaction();
            approveCreditCurrentUser.setSignatureStatus(true);
            session.saveOrUpdate(approveCreditCurrentUser);
            session.getTransaction().commit();
        }
        session.close();
        logger.info("User successfully loaded. User details: " + userRequestCredit);
    }
}
