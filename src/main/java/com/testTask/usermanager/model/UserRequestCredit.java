package com.testTask.usermanager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "request_users")
public class UserRequestCredit {

    @Id
    @Column(name = "id_request_users")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequestUsers;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "passport_data")
    private int passportData;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private int contactNumber;

    @Column(name = "employment_information")
    private String employmentInformation;

    @Column(name = "user_credit_amount")
    private int userCreditAmount;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userRequestCredit")
    private List<ApproveCredit> approveCredits;


    public Long getIdRequestUsers() {
        return idRequestUsers;
    }

    public void setIdRequestUsers(Long idRequestUsers) {
        this.idRequestUsers = idRequestUsers;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPassportData() {
        return passportData;
    }

    public void setPassportData(int passportData) {
        this.passportData = passportData;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmploymentInformation() {
        return employmentInformation;
    }

    public void setEmploymentInformation(String employmentInformation) {
        this.employmentInformation = employmentInformation;
    }

    public int getUserCreditAmount() {
        return userCreditAmount;
    }

    public void setUserCreditAmount(int userCreditAmount) {
        this.userCreditAmount = userCreditAmount;
    }

    public List<ApproveCredit> getApproveCredits() {
        return approveCredits;
    }

    public void setApproveCredits(List<ApproveCredit> approveCredits) {
        this.approveCredits = approveCredits;
    }


    public UserRequestCredit() {
    }

    public UserRequestCredit(String fullName, int passportData, String maritalStatus,
                             String address, int contactNumber, String employmentInformation, int userCreditAmount) {
        this.fullName = fullName;
        this.passportData = passportData;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.contactNumber = contactNumber;
        this.employmentInformation = employmentInformation;
        this.userCreditAmount = userCreditAmount;
    }

    @Override
    public String toString() {
        return "UserRequestCredit{" +
                "idRequestUsers=" + idRequestUsers +
                ", fullName='" + fullName + '\'' +
                ", passportData=" + passportData +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber=" + contactNumber +
                ", employmentInformation='" + employmentInformation + '\'' +
                ", userCreditAmount=" + userCreditAmount +
                ", approveCredits=" + approveCredits +
                '}';
    }
}
