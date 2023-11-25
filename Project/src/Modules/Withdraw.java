package Modules;

import java.util.*;
import Database.*;
public class Withdraw {
    private int wid;
    private double amount;
    private String accTitle;
    private String accNum;
    private String bank;
    private String date;

    public Withdraw() {
    }

    public Withdraw(int wid, double amount, String accTitle, String accNum, String bank, String date) {
        this.wid = wid;
        this.amount = amount;
        this.accTitle = accTitle;
        this.accNum = accNum;
        this.bank = bank;
        this.date = date;
    }

    public void makeWithdraw() {
    	Database db=new Database();
    	db.withdraw(this);
    }
    
    public ArrayList<Withdraw> History(int wid){
    	Database db=new Database();
    	return db.wHistory(wid);
    } 
    
    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccTitle() {
        return accTitle;
    }

    public void setAccTitle(String accTitle) {
        this.accTitle = accTitle;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
