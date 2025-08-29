package com.pahana.Model;

public class Customer {
	private int c_id;
    private String c_firstname;
    private String c_lastname;
    private String c_username;
    private String c_email;
    private String c_mobile;
    private String c_address;
    private String c_password;


    public Customer(String c_firstname, String c_email, String c_mobile, String c_address) {
        this.c_firstname=c_firstname;
        this.c_email=c_email;
        this.c_mobile=c_mobile;
        this.c_address=c_address;
    }



    public Customer(Integer c_id, String c_firstname, String c_lastname, String c_username, String c_email, String c_mobile, String c_address, String c_password) {
        this.c_id=c_id;
        this.c_firstname=c_firstname;
        this.c_lastname=c_lastname;
        this.c_username=c_username;
        this.c_email=c_email;
        this.c_mobile=c_mobile;
        this.c_address=c_address;
        this.c_password=c_password;

    }
    
    public Customer(String c_firstname, String c_lastname, String c_username, String c_email, String c_mobile, String c_address, String c_password) {
        this.c_firstname=c_firstname;
        this.c_lastname=c_lastname;
        this.c_username=c_username;
        this.c_email=c_email;
        this.c_mobile=c_mobile;
        this.c_address=c_address;
        this.c_password=c_password;

    }
    
    
    public Customer(Integer c_id, String c_firstname, String c_lastname, String c_username, String c_email, String c_mobile, String c_address) {
        this.c_id=c_id;
        this.c_firstname=c_firstname;
        this.c_lastname=c_lastname;
        this.c_username=c_username;
        this.c_email=c_email;
        this.c_mobile=c_mobile;
        this.c_address=c_address;

    }
    

    public int getC_id() {
		return c_id;
	}



	public String getC_firstname() {
		return c_firstname;
	}



	public String getC_lastname() {
		return c_lastname;
	}



	public String getC_username() {
		return c_username;
	}



	public String getC_email() {
		return c_email;
	}



	public String getC_mobile() {
		return c_mobile;
	}



	public String getC_address() {
		return c_address;
	}



	public String getC_password() {
		return c_password;
	}



	public void setC_id(int c_id) {
		this.c_id = c_id;
	}



	public void setC_firstname(String c_firstname) {
		this.c_firstname = c_firstname;
	}



	public void setC_lastname(String c_lastname) {
		this.c_lastname = c_lastname;
	}



	public void setC_username(String c_username) {
		this.c_username = c_username;
	}



	public void setC_email(String c_email) {
		this.c_email = c_email;
	}



	public void setC_mobile(String c_mobile) {
		this.c_mobile = c_mobile;
	}



	public void setC_address(String c_address) {
		this.c_address = c_address;
	}



	public void setC_password(String c_password) {
		this.c_password = c_password;
	}


  

}
