package com.tosit.genius.entity;

public class Administrator {
    private String adminId;

    private String adminPswd;

    private String adminEmail;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getAdminPswd() {
        return adminPswd;
    }

    public void setAdminPswd(String adminPswd) {
        this.adminPswd = adminPswd == null ? null : adminPswd.trim();
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail == null ? null : adminEmail.trim();
    }
}