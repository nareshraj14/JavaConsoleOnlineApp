package online;

import java.lang.*;

class Customer {
    private String sName;
    private String sEmail;
    private String sPassword;
    private String sAddress;
    private String sContact;
    private String sID;

    // c'tor
    Customer() {
        sName = "";
        sEmail = "";
        sPassword = "";
        sAddress = "";
        sContact = "";
        sID = "";
    }

    // c'tor overload
    Customer(String name, String email, String Password, String address, String contact) {
        sName = name;
        sEmail = email;
        sPassword = Password;
        sAddress = address;
        sContact = contact;
        GenerateCustId();
    }

    public String DisplayUserDetails() {
        String Details = "";
        Details = sID + ", " + sName + ", " + sEmail + ", " + sAddress + ", " + sContact;

        return Details;
    }

    // Generate/Create prod id
    void GenerateCustId() {
        sID = "" + (int) (Math.random() * 99999) + 10000;
    }

    public String GetEmail() {
        return sEmail;
    }

    public String GetCustomerID() {
        return sID;
    }

    public String GetAddress() {
        return sAddress;
    }

    public String GetContact() {
        return sContact;
    }

    public String GetName() {
        return sName;
    }

    public Boolean verifyPassword(String pass) {
        return sPassword.equals(pass);
    }
};