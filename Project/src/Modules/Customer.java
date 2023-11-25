package Modules;

import Database.Database;

public class Customer extends User {
	
	
	public Customer() {
	    this.name = "";
        this.city = "";
        this.phone = "";
        this.dob = "";
        this.gender = "";
    	
	}
	
    public Customer(String name, String city, String phone, String dob, String gender) {
        this.name = name;
        this.city = city;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }


	
	public void Register(){
		Database db= new Database();
		this.setId(db.register(this));
	};
	
	
	public void update() {
		Database db= new Database();
		db.update(this);	
	}
	
	public void Login(){
		Database db= new Database();
		Customer c= db.login(this);
		this.name=c.name;
		this.city=c.city;
		this.gender=c.gender;
		this.dob=c.dob;
		};

	
};
