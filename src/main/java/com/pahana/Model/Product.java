package com.pahana.Model;

public class Product {
    public Product(int id, String name, String price, String description) {
        this.pid=id;
        this.name=name;
        this.price= Double.parseDouble(price);
        this.description=description;
    }

    public Product(String fileName, String name, String price, String description, String category) {
        this.pimage=fileName;
        this.name=name;
        this.price= Double.parseDouble(price);
        this.description=description;
        this.category=category;

    }
    
    public Product(int id, String fileName, String name, String price, String description, String category) {
    	this.pid=id;
    	this.pimage=fileName;
        this.name=name;
        this.price= Double.parseDouble(price);
        this.description=description;
        this.category=category;

    }
    

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int pid;
    private String pimage;
    private String name;
    private  double price;
    private String description;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    private String category;

}

