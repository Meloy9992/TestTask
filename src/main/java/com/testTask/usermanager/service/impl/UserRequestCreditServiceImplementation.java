package com.testTask.usermanager.service.impl;

import com.testTask.usermanager.dao.UserRequestCreditDao;
import com.testTask.usermanager.model.ApproveCredit;
import com.testTask.usermanager.model.UserRequestCredit;
import com.testTask.usermanager.service.ApproveCreditService;
import com.testTask.usermanager.service.UserRequestCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service user request credit data processing
 */
@Service
public class UserRequestCreditServiceImplementation implements UserRequestCreditService {

    private UserRequestCreditDao userRequestCreditDao;
    private ApproveCreditService approveCreditService;

    @Autowired
    public UserRequestCreditServiceImplementation(UserRequestCreditDao userRequestCreditDao, ApproveCreditService approveCreditService) {
        this.userRequestCreditDao = userRequestCreditDao;
        this.approveCreditService = approveCreditService;
    }

    /**
     * Add user Request
     *
     */
    @Override
    public void addUserRequest(UserRequestCredit userRequestCredit) {
        userRequestCreditDao.addUserRequest(userRequestCredit);
    }

    /**
     * Get one user by Id
     *
     * @param id
     * @return one user by id
     */
    @Override
    public UserRequestCredit getUserById(Long id) {
        return userRequestCreditDao.getUserById(id);
    }

    /**
     * Get List User Request Credit
     *
     * @return all users
     */
    @Override
    public List<UserRequestCredit> getListAllUser() {
        return userRequestCreditDao.getListAllUser();
    }

    /**
     * Changes the one user's signing credit status
     *
     * @param userRequestCredit
     */
    @Override
    public void signCredit(UserRequestCredit userRequestCredit) {
        userRequestCreditDao.signCredit(userRequestCredit);
    }

    /**
     * Create request User with parameters
     *
     * @param fullName
     * @param passportData
     * @param maritalStatus
     * @param address
     * @param contactNumber
     * @param employmentInformation
     * @param userCreditAmount
     */
    @Override
    public void createRequestCredit(String fullName, int passportData, String maritalStatus, String address, int contactNumber, String employmentInformation, int userCreditAmount) {
        UserRequestCredit userRequestCredit = new UserRequestCredit(fullName, passportData,
                maritalStatus, address, contactNumber, employmentInformation, userCreditAmount);

        addUserRequest(userRequestCredit);
        ApproveCredit approveCredit = approveCreditService.createApproveCredit(userRequestCredit, userCreditAmount);
        approveCreditService.addApproveCredit(approveCredit);
    }
}
