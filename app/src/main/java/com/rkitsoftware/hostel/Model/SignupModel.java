package com.rkitsoftware.hostel.Model;

public class SignupModel {

    private String acpcRank;

    private String branch;

    private String category;

    private String city;

    private String document;

    private String email;

    private Long enrollNo;

    private String isApproved;

    private String mobileNo;

    public SignupModel(){

    }

    public SignupModel(String acpcRank, String branch, String category, String city, String document, String email, Long enrollNo, String isApproved, String mobileNo, String name) {
        this.acpcRank = acpcRank;
        this.branch = branch;
        this.category = category;
        this.city = city;
        this.document = document;
        this.email = email;
        this.enrollNo = enrollNo;
        this.isApproved = isApproved;
        this.mobileNo = mobileNo;
        this.name = name;
    }

    private String name;

    public String getAcpcRank() {
        return acpcRank;
    }

    public void setAcpcRank(String acpcRank) {
        this.acpcRank = acpcRank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEnrollNo() {
        return enrollNo;
    }

    public void setEnrollNo(Long enrollNo) {
        this.enrollNo = enrollNo;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
