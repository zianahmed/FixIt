package Modules;
import Database.*;
import java.util.*;
public class Service {
	private String cName;
	private String wName;
	private String wPhone;
	private String cPhone;
    private int id;
    private int cid;
    private int wid;
    private String date;
    private String addr;
    private String city;
    private String type;
    private String status;
    private String detail;
    private double fee;
    public Service() {

    }

    public Service(int id, int cid, int wid, String date, String addr, String city, String type, String status, String detail,String cName,String wName,String wPhone,String cPhone) {
        this.id = id;
        this.cid = cid;
        this.wid = wid;
        this.date = date;
        this.addr = addr;
        this.city = city;
        this.type = type;
        this.status = status;
        this.detail = detail;
        this.cName=cName;
        this.wName=wName;
        this.wPhone=wPhone;
        this.cPhone=wPhone;
    }

    
    public void Register() {
    	Database db = new Database();
    	db.insertService(this);
    }
    
    public void Pay(double total) {
    	Database db=new Database();
    	db.newPayment(this, total);
    	this.updateStatus(id, "Review");
    }
    
    public ArrayList<Service> cService(int cid,String status){
    	Database db=new Database();
    	ArrayList<Service> s=db.getCService(cid, status);
    	return s;
    }
    
    public ArrayList<Service> wService(int wid,String status){
    	Database db=new Database();
    	return db.getWService(wid, status);
    }
    
    
    public void Remove(int i) {
    	Database db=new Database();
    	db.removeService(i);
    }
    
    public void updateStatus(int i,String status) {
    	Database db=new Database();
    	db.updateService(i,status);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
    
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }
    
    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getwPhone() {
        return wPhone;
    }

    public void setwPhone(String wPhone) {
        this.wPhone = wPhone;
    }
    
    
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

