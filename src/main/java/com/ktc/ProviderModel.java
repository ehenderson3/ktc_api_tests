package com.ktc;

public class ProviderModel {

    private String city;
    private String email;
    private String name;
    private String npi;
    private String phoneNumber;
    private Boolean preferred;
    private String state;
    private String taxId;
    //private String appointments;
    private String street1;
    private String street2;
    private String zip;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getPreferred() {
        return preferred;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

/*    public String getAppointments() {
        return appointments;
    }

    public void setAppointments(String appointments) {
        this.appointments = appointments;
    }*/

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public ProviderModel(String cityVal, String emailVal, String nameVal, String npiVal, String phoneNumberVal, boolean preferredVal, String stateVal, String taxIdVal, String appointmentsVal, String street1Val, String zipVal ){
        this.city = cityVal;
        this.email = emailVal;
        this.name = nameVal;
        this.npi = npiVal;
        this.phoneNumber = phoneNumberVal;
        this.preferred = preferredVal;
        this.state = stateVal;
        this.taxId = taxIdVal;
        this.street1 = street1Val;
        this.zip = zipVal;

    };

}
