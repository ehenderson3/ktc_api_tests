package com.ktc;

public class ThirdPartyAdminModel {
    private String name;
    private String street1;
    private String city;
    private String state;
    private int zip;
    private String primaryContact;
    private String primaryEmail;
    private String primaryPhone;
    private String dataRecievedBy;
    private Boolean active;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getDataRecievedBy() {
        return dataRecievedBy;
    }

    public void setDataRecievedBy(String dataRecievedBy) {
        this.dataRecievedBy = dataRecievedBy;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ThirdPartyAdminModel(String nameVal, String street1Val, String cityVal, String stateVal, int zipVal, String primaryContactVal, String primaryEmailVal, String phoneNumberVal, String primaryPhoneVal, String dataRecievedByVal, boolean activeVal ){
        this.name = nameVal;
        this.street1 = street1Val;
        this.city = cityVal;
        this.state = stateVal;
        this.zip = zipVal;
        this.primaryContact = primaryContactVal;
        this.primaryEmail = primaryEmailVal;
        this.primaryPhone = primaryPhoneVal;
        this.dataRecievedBy = dataRecievedByVal;
        this.active = activeVal;

    };


}
