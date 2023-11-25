package Database;

import java.sql.*;
import Modules.*;
import java.util.*;
public class Database {
	
  public int register(Customer c) {
    	int generatedId=-1;
        String insertQuery = "INSERT INTO Customer (name, phoneNo, pass, city, gender, dob) VALUES (?, ?, ?, ?, ?, ?)";

        try (
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)
        ) {
            preparedStatement.setString(1, c.getName());
            preparedStatement.setString(2, c.getPhone());
            preparedStatement.setString(3, c.getPassword());
            preparedStatement.setString(4, c.getCity());
            preparedStatement.setString(5, c.getGender());
            preparedStatement.setString(6, c.getDob());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedId;
    }   
  public int register(Worker c) {
        int generatedId = -1;

        String insertQuery = "INSERT INTO Worker (name, phoneNo, pass, city, gender, dob, skill, fee) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, c.getName());
            preparedStatement.setString(2, c.getPhone());
            preparedStatement.setString(3, c.getPassword());
            preparedStatement.setString(4, c.getCity());
            preparedStatement.setString(5, c.getGender());
            preparedStatement.setString(6, c.getDob());
            preparedStatement.setString(7, c.getSkill());
            preparedStatement.setString(8, String.valueOf(c.getFee()));
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
    }
  public void insertService(Service service) {
      String insertQuery = "INSERT INTO Service (wid, cid, addr, Details, date, status,fee) VALUES (?, ?, ?, ?, ?, ?,?)";

      try (
              Connection connection = DriverManager.getConnection(url, user, password);
              PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)
      ) {
          preparedStatement.setInt(1, service.getWid());
          preparedStatement.setInt(2, service.getCid());
          preparedStatement.setString(3, service.getAddr());
          preparedStatement.setString(4, service.getDetail());
          preparedStatement.setString(5, service.getDate());
          preparedStatement.setString(6, "Pending");
          preparedStatement.setString(7, String.valueOf(service.getFee()));

          preparedStatement.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  
  public Worker login(Worker w) {
      String selectQuery = "SELECT * FROM Worker WHERE phoneNo = ? AND pass = ?";
      try (
          Connection connection = DriverManager.getConnection(url, user, password);
          PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)
      ) {
          preparedStatement.setString(1, w.getPhone());
          preparedStatement.setString(2, w.getPassword());

          try (ResultSet resultSet = preparedStatement.executeQuery()) {
              if (resultSet.next()) {
                  w.setId(resultSet.getInt("id"));
                  w.setName(resultSet.getString("name"));
                  w.setCity(resultSet.getString("city"));
                  w.setGender(resultSet.getString("gender"));
                  w.setDob(resultSet.getString("dob"));
                  w.setSkill(resultSet.getString("skill"));
                  w.setFee(resultSet.getDouble("fee"));
                  w.setRating(resultSet.getDouble("rating"));
              }
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return w;
  }
  public Customer login(Customer c) {
      String selectQuery = "SELECT * FROM Customer WHERE phoneNo = ? AND pass = ?";
      try (
          Connection connection = DriverManager.getConnection(url, user, password);
          PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)
      ) {
          preparedStatement.setString(1, c.getPhone());
          preparedStatement.setString(2, c.getPassword());

          try (ResultSet resultSet = preparedStatement.executeQuery()) {
              if (resultSet.next()) {
                  c.setId(resultSet.getInt("id"));
                  c.setName(resultSet.getString("name"));
                  c.setCity(resultSet.getString("city"));
                  c.setGender(resultSet.getString("gender"));
                  c.setDob(resultSet.getString("dob"));
              }
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return c;
  }
  
  public Customer update(Customer c) {
	  
	  String updateQuery = "UPDATE Customer SET name=?, phoneNo=?, city=?, pass=? WHERE id=?";

	    try (
	        Connection connection = DriverManager.getConnection(url, user, password);
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)
	    ) {
	        preparedStatement.setString(1, c.getName());
	        preparedStatement.setString(2, c.getPhone());
	        preparedStatement.setString(3, c.getCity());
	        preparedStatement.setString(4, c.getPassword());
	        preparedStatement.setInt(5, c.getId());

	        int rowsAffected = preparedStatement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	  
	  return c;
  }
  public Worker update(Worker w){
	  
	  String updateQuery = "UPDATE Worker SET name=?, phoneNo=?, city=?, pass=?,skill=?,fee=? WHERE id=?";

	    try (
	        Connection connection = DriverManager.getConnection(url, user, password);
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)
	    ) {
	        preparedStatement.setString(1, w.getName());
	        preparedStatement.setString(2, w.getPhone());
	        preparedStatement.setString(3, w.getCity());
	        preparedStatement.setString(4, w.getPassword());
	        preparedStatement.setString(5, w.getSkill());
	        preparedStatement.setDouble(6, w.getFee());
	        preparedStatement.setInt(7, w.getId());

	        int rowsAffected = preparedStatement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	  
	  return w;
  }

  public double getWBal(int wid) {
	  String selectQuery = "SELECT Amount FROM wAccount WHERE wid = ?";
      double bal=0;
	  try (
          Connection connection = DriverManager.getConnection(url, user, password);
          PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)
      ) {
          preparedStatement.setInt(1, wid);

          try (ResultSet resultSet = preparedStatement.executeQuery()) {
              if (resultSet.next()) {
                  bal= resultSet.getDouble("Amount");
              }
          }
      } 
	  
	  catch (SQLException e) {
          e.printStackTrace();
      }
      return bal;
  
  };
  
  public ArrayList<Worker> getWorker(String skill, String city) {
      ArrayList<Worker> workers = new ArrayList<>();

      String query = "SELECT * FROM Worker WHERE skill = ? AND city = ?";

      try (Connection connection = DriverManager.getConnection(url, user, password);
           PreparedStatement preparedStatement = connection.prepareStatement(query)) {

          preparedStatement.setString(1, skill);
          preparedStatement.setString(2, city);

          try (ResultSet resultSet = preparedStatement.executeQuery()) {
              while (resultSet.next()) {
                  Worker worker = new Worker();
                  worker.setId(resultSet.getInt("id"));
                  worker.setName(resultSet.getString("name"));
                  worker.setPhone(resultSet.getString("phoneNo"));
                  worker.setDob(resultSet.getString("dob"));
                  worker.setCity(resultSet.getString("city"));
                  worker.setSkill(resultSet.getString("skill"));
                  worker.setFee(resultSet.getDouble("fee"));
                  worker.setGender(resultSet.getString("gender"));
                  worker.setRating(resultSet.getDouble("rating"));
                  workers.add(worker);
              }
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return workers;
  }
  public ArrayList<Review> getReview(int wId) {
      ArrayList<Review> reviews = new ArrayList<>();

      String sqlQuery = "SELECT c.name AS 'name', r.rating AS 'rating', r.review AS 'comment', r.date AS 'date' " +
                        "FROM Review r " +
                        "INNER JOIN Worker w ON r.wid = w.id " +
                        "INNER JOIN Customer c ON c.id = r.cid " +
                        "WHERE w.id = ?";

      try (Connection connection = DriverManager.getConnection(url, user, password)){
	    	      try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
	          preparedStatement.setInt(1, wId);
	
	          try (ResultSet resultSet = preparedStatement.executeQuery()) {
	              while (resultSet.next()) {
	                  String name = resultSet.getString("name");
	                  int rating = resultSet.getInt("rating");
	                  String comment = resultSet.getString("comment");
	                  String date = resultSet.getString("date");
	
	                  Review review = new Review(0, name, wId, rating, "", date, comment);
	                  reviews.add(review);
	              }
	          }
	      }
	  } catch (SQLException e) {
          e.printStackTrace(); 
      }

      return reviews;
  }
  public ArrayList<Service> getCService(int cid, String status) {
	    ArrayList<Service> services = new ArrayList<>();

	    String selectQuery = "SELECT w.id as 'wid',s.sid as 's',w.skill as 'type',w.city as 'city', c.name as 'customer', w.name as 'worker', s.date as 'date', w.phoneNo as 'wphone', s.addr as 'address', s.details as 'detail', s.fee as 'fee' " +
	            "FROM Service s " +
	            "INNER JOIN Worker w ON s.wid = w.id " +
	            "INNER JOIN Customer c ON c.id = s.cid " +
	            "WHERE s.cid = ? AND s.status = ?";

	    try (Connection connection = DriverManager.getConnection(url, user, password)) {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            preparedStatement.setInt(1, cid);
	            preparedStatement.setString(2, status);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {  
	                    int serviceId = resultSet.getInt("s");
	                    int wId = resultSet.getInt("wid");
	                    String customerName = resultSet.getString("customer");
	                    String workerName = resultSet.getString("worker");
	                    String date = resultSet.getString("date");
	                    String workerPhone = resultSet.getString("wphone");
	                    String address = resultSet.getString("address");
	                    String detail = resultSet.getString("detail");
	                    String city = resultSet.getString("city");
	                    double fee = resultSet.getDouble("fee");
	                    String type=resultSet.getString("type");
	                    
	                    Service service = new Service();
	                    service.setType(type);
	                    service.setId(serviceId);
	                    service.setCid(cid);
	                    service.setDate(date);
	                    service.setAddr(address);
	                    service.setStatus(status);
	                    service.setDetail(detail);
	                    service.setcName(customerName);
	                    service.setwName(workerName);
	                    service.setwPhone(workerPhone);
	                    service.setCity(city);
	                    service.setFee(fee);
	                    service.setWid(wId);
	                    	
	                    services.add(service);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return services;
	}
  public ArrayList<Service> getWService(int wid, String status) {
	    ArrayList<Service> services = new ArrayList<>();

	    String selectQuery = "SELECT c.id as 'cid',s.sid as 's',w.skill as 'type',w.city as 'city', c.name as 'customer', w.name as 'worker', s.date as 'date', c.phoneNo as 'cphone', s.addr as 'address', s.details as 'detail', s.fee as 'fee' " +
	            "FROM Service s " +
	            "INNER JOIN Worker w ON s.wid = w.id " +
	            "INNER JOIN Customer c ON c.id = s.cid " +
	            "WHERE s.wid = ? AND s.status = ?";

	    try (Connection connection = DriverManager.getConnection(url, user, password)) {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            preparedStatement.setInt(1, wid);
	            preparedStatement.setString(2, status);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {  
	                    int serviceId = resultSet.getInt("s");
	                    int cId = resultSet.getInt("cid");
	                    String customerName = resultSet.getString("customer");
	                    String workerName = resultSet.getString("worker");
	                    String date = resultSet.getString("date");
	                    String cPhone = resultSet.getString("cphone");
	                    String address = resultSet.getString("address");
	                    String detail = resultSet.getString("detail");
	                    String city = resultSet.getString("city");
	                    double fee = resultSet.getDouble("fee");
	                    String type=resultSet.getString("type");
	                    
	                    Service service = new Service();
	                    service.setType(type);
	                    service.setId(serviceId);
	                    service.setCid(cId);
	                    service.setDate(date);
	                    service.setAddr(address);
	                    service.setStatus(status);
	                    service.setDetail(detail);
	                    service.setcName(customerName);
	                    service.setwName(workerName);
	                    service.setcPhone(cPhone);
	                    service.setCity(city);
	                    service.setFee(fee);
	                    service.setWid(wid);
	                    	
	                    services.add(service);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return services;
	}

  public void removeService(int i) {
	    String deleteQuery = "DELETE FROM Service WHERE sid = ?";
	    
	    try (Connection connection = DriverManager.getConnection(url, user, password);
	         PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
	        
	        preparedStatement.setInt(1, i);  
	        int rowsAffected = preparedStatement.executeUpdate();

	        

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
  public void updateService(int i, String status) {
	    String updateQuery = "UPDATE Service SET status=? WHERE sid = ?";

	    try (Connection connection = DriverManager.getConnection(url, user, password);
	         PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

	        preparedStatement.setString(1, status);
	        preparedStatement.setInt(2, i);

	        preparedStatement.executeUpdate();


	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
  public void newPayment(Service s,double total) {
      String insertQuery = "INSERT INTO Payment (sid, cid, wid, amount,date) VALUES (?,?,?,?,CURDATE())";

      try (
          Connection connection = DriverManager.getConnection(url, user, password);

          PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)
      ) {
          preparedStatement.setInt(1, s.getId());
          preparedStatement.setInt(2, s.getCid());
          preparedStatement.setInt(3, s.getWid());
          preparedStatement.setDouble(4, total);;
          preparedStatement.executeUpdate();

      } catch (SQLException e) {
          e.printStackTrace();
      }
  
  }
  
  public void postReview(Review r) {
      String insertQuery = "INSERT INTO Review (wid, cid, date, Rating, review) VALUES (?, ?, ?, ?, ?)";

      try (
          Connection connection = DriverManager.getConnection(url, user, password);
          PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)
      ) {
          preparedStatement.setInt(1, r.getwId());
          preparedStatement.setInt(2, r.getcId());
          preparedStatement.setString(3, r.getDate());
          preparedStatement.setInt(4, r.getRating());
          preparedStatement.setString(5, r.getComment());

          preparedStatement.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  

	String url = "jdbc:mysql://localhost:3306/sda";
	String user = "root";
	String password = "123456";
 

  public void withdraw(Withdraw withdrawal) {
      Connection connection = null;

      try {
          connection = DriverManager.getConnection(url, user, password);

          String insertQuery = "INSERT INTO withdraw (wid, amount, accTitle, accNum, bank, date) VALUES (?, ?, ?, ?, ?, CURDATE())";

          try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
              preparedStatement.setInt(1, withdrawal.getWid());
              preparedStatement.setDouble(2, withdrawal.getAmount());
              preparedStatement.setString(3, withdrawal.getAccTitle());
              preparedStatement.setString(4, withdrawal.getAccNum());
              preparedStatement.setString(5, withdrawal.getBank());

              // Executing the query
              preparedStatement.executeUpdate();
          }
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          // Closing the connection
          if (connection != null) {
              try {
                  connection.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
      }
  }

  public ArrayList<Withdraw> wHistory(int wid) {
      ArrayList<Withdraw> withdrawalList = new ArrayList<>();
      Connection connection = null;

      try {
          connection = DriverManager.getConnection(url, user, password);

          String selectQuery = "SELECT * FROM withdraw WHERE wid = ?";

          try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
              preparedStatement.setInt(1, wid);

              try (ResultSet resultSet = preparedStatement.executeQuery()) {
                  while (resultSet.next()) {
                      int withdrawalId = resultSet.getInt("wid");
                      double withdrawalAmount = resultSet.getDouble("amount");
                      String accTitle = resultSet.getString("accTitle");
                      String accNum = resultSet.getString("accNum");
                      String bank = resultSet.getString("bank");
                      String date = resultSet.getString("date");

                      Withdraw withdrawal = new Withdraw(withdrawalId, withdrawalAmount, accTitle, accNum, bank, date);
                      withdrawalList.add(withdrawal);
                  }
              }
          }
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          if (connection != null) {
              try {
                  connection.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
      }

      return withdrawalList;
  }

}
