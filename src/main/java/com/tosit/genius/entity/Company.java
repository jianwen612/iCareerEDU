package com.tosit.genius.entity;

public class Company {
    private String companyId;

    private String companyName;

    private String companyEmail;

    private String companyPswd;

    private String companyLicence;

    private String companyLicenceNo;

    private Boolean companyStatus;

    private String companyPhoneNo;

    private String companyIntroduction;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail == null ? null : companyEmail.trim();
    }

    public String getCompanyPswd() {
        return companyPswd;
    }

    public void setCompanyPswd(String companyPswd) {
        this.companyPswd = companyPswd == null ? null : companyPswd.trim();
    }

    public String getCompanyLicence() {
        return companyLicence;
    }

    public void setCompanyLicence(String companyLicence) {
        this.companyLicence = companyLicence == null ? null : companyLicence.trim();
    }

    public String getCompanyLicenceNo() {
        return companyLicenceNo;
    }

    public void setCompanyLicenceNo(String companyLicenceNo) {
        this.companyLicenceNo = companyLicenceNo == null ? null : companyLicenceNo.trim();
    }

    public Boolean getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(Boolean companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getCompanyPhoneNo() {
        return companyPhoneNo;
    }

    public void setCompanyPhoneNo(String companyPhoneNo) {
        this.companyPhoneNo = companyPhoneNo == null ? null : companyPhoneNo.trim();
    }

    public String getCompanyIntroduction() {
        return companyIntroduction;
    }

    public void setCompanyIntroduction(String companyIntroduction) {
        this.companyIntroduction = companyIntroduction == null ? null : companyIntroduction.trim();
    }
}