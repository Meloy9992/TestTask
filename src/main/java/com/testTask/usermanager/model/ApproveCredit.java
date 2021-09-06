package com.testTask.usermanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "approve_credit")
public class ApproveCredit {

    @Id
    @Column(name = "id_approve_credit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_request_users")
    private UserRequestCredit userRequestCredit;

    @Column(name = "status_approved_application")
    private boolean statusApprovedApplication;

    @Column(name = "offer_term")
    private int offerTerm;

    @Column(name = "approve_credit_sum")
    private int approveCreditSum;

    @Column(name = "approve_credit_date")
    private Date approveCreditDate;

    @Column(name = "signature_status")
    private boolean signatureStatus;

    public boolean getStatusApprovedApplication() {
        return statusApprovedApplication;
    }

    public void setStatusApprovedApplication(boolean statusApprovedApplication) {
        this.statusApprovedApplication = statusApprovedApplication;
    }

    public int getOfferTerm() {
        return offerTerm;
    }

    public void setOfferTerm(int offerTerm) {
        this.offerTerm = offerTerm;
    }

    public int getApproveCreditSum() {
        return approveCreditSum;
    }

    public void setApproveCreditSum(int approveCreditSum) {
        this.approveCreditSum = approveCreditSum;
    }

    public UserRequestCredit getUserRequestCredit() {
        return userRequestCredit;
    }

    public void setUserRequestCredit(UserRequestCredit userRequestCredit) {
        this.userRequestCredit = userRequestCredit;
    }

    public Date getApproveCreditDate() {
        return approveCreditDate;
    }

    public void setApproveCreditDate(Date approveCreditDate) {
        this.approveCreditDate = approveCreditDate;
    }

    public boolean isSignatureStatus() {
        return signatureStatus;
    }

    public void setSignatureStatus(boolean signatureStatus) {
        this.signatureStatus = signatureStatus;
    }

    public ApproveCredit() {
    }

    public ApproveCredit(UserRequestCredit userRequestCredit, boolean statusApprovedApplication, int offerTerm, int approveCreditSum, Date approveCreditDate, boolean signatureStatus) {
        this.userRequestCredit = userRequestCredit;
        this.statusApprovedApplication = statusApprovedApplication;

        if (!statusApprovedApplication) {
            this.offerTerm = 0;
            this.approveCreditSum = 0;
            this.approveCreditDate = new Date(0);
            this.signatureStatus = false;
        } else {
            this.offerTerm = offerTerm;
            this.approveCreditSum = approveCreditSum;
            this.approveCreditDate = approveCreditDate;
            this.signatureStatus = signatureStatus;
        }
    }
}
