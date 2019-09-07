package com.tosit.genius.entity;

public class CompanyCheckKey {
    private String companyCheckCompanyId;

    private String companyCheckAdminId;

    public String getCompanyCheckCompanyId() {
        return companyCheckCompanyId;
    }

    public void setCompanyCheckCompanyId(String companyCheckCompanyId) {
        this.companyCheckCompanyId = companyCheckCompanyId == null ? null : companyCheckCompanyId.trim();
    }

    public String getCompanyCheckAdminId() {
        return companyCheckAdminId;
    }

    public void setCompanyCheckAdminId(String companyCheckAdminId) {
        this.companyCheckAdminId = companyCheckAdminId == null ? null : companyCheckAdminId.trim();
    }
}