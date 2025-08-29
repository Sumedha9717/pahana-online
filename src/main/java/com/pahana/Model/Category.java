package com.pahana.Model;

public class Category {
	
	private int cate_id;
    private String cate_name;
    private String cate_description;
    
    public Category(Integer cate_id, String cate_name, String cate_description) {
	    this.cate_id=cate_id;
	    this.cate_name=cate_name;
	    this.cate_description=cate_description;
	}
    
    public Category(String cate_name, String cate_description) {
	    this.cate_name=cate_name;
	    this.cate_description=cate_description;
	}


	public int getCate_id() {
		return cate_id;
	}


	public String getCate_name() {
		return cate_name;
	}


	public String getCate_description() {
		return cate_description;
	}


	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}


	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}


	public void setCate_description(String cate_description) {
		this.cate_description = cate_description;
	}



}