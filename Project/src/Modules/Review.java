package Modules;

import Database.Database;
import java.util.*;
public class Review {
    private int cId;
    private String cName;
    private int wId;
    private int rating;
    private String wName;
    private String date;
    private String comment;

    public Review() {
    	
    }
    
    public void post() {
    	Database db=new Database();
    	db.postReview(this);
    } 
    
    public ArrayList<Review> getReviews(int wid){
    	Database db=new Database();
    	return db.getReview(wid);
    }
    
    
    public Review(int cId, String cName, int wId, int rating, String wName, String date, String comment) {
    	this.cId = cId;
        this.cName = cName;
        this.wId = wId;
        this.rating = rating;
        this.wName = wName;
        this.date = date;
        this.comment = comment;
    }


    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

