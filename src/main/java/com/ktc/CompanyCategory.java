package com.ktc;

public class CompanyCategory {

    public CompanyCategory(String comId, String catId){
        this.companyId = comId;
        this.categoryId = catId;
    };
    public CompanyCategory(int countTot){
        this.count = countTot;
    };


    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    private String companyId;
    private String categoryId;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;







}
