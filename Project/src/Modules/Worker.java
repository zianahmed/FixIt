package Modules;

import Database.Database;

public class Worker extends User {
	private double fee;
	private double rating;
	private String skill;
	
	public Worker() {
	    this.name = "";
        this.city = "";
        this.phone = "";
        this.dob = "";
        this.gender = "";
        this.skill="";
        this.fee=0;
        this.rating=0;
	}
	
	
    public Worker(String name, String city, String phone, String dob, String gender) {
        this.name = name;
        this.city = city;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }
    
    public double getFee() {
        return fee;
    }

    public void setFee(double Fee) {
        this.fee = Fee;
    }
    
    public void setRating(double r) {
        this.rating = r;
    }
    
    public double getRating() {
        return rating;
    }

    
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

	public void Register(){
		Database db= new Database();
		this.setId(db.register(this));
	};
	
	public void Login() {
		Database db = new Database();
		Worker w = db.login(this);
		this.name=w.name;
		this.city=w.city;
		this.gender=w.gender;
		this.dob=w.dob;
		this.skill=w.skill;
		this.fee=w.fee;
	}
	
}
