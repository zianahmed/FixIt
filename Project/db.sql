Create database sda;
use sda;

CREATE TABLE Customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name TEXT,
    phoneNo TEXT,
    pass TEXT,
    city TEXT,
    gender TEXT,
    dob DATE
);

CREATE TABLE Worker (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name TEXT,
    phoneNo TEXT,
    pass TEXT,
    city TEXT,
    gender TEXT,
    dob DATE,
    skill TEXT,
    fee DOUBLE,
    rating double
);


Create Table Service (
sid int Primary key auto_increment,
wid int,
cid int,
addr TEXT,
Details TEXT,
fee double,
date TEXT,
status TEXT
);

CREATE TABLE Status (
sid int,
status TEXT,
date DATE
);



CREATE TABLE Review (
sid INT,
wid INT,
cid INT,
date date,
Rating INT,
review TEXT
);

CREATE TABLE payment(
id INT PRIMARY KEY AUTO_INCREMENT,
sid INT,
cid INT,
wid INT,
Amount DOUBLE,
date DATE 
);


CREATE TABLE wAccount(
wid int,
Amount double default 0
);

CREATE TABLE withdraw (
wid int,
amount double,
accTitle TEXT,
accNum TEXT,
bank TEXT,
date DATE
);


DELIMITER //
CREATE TRIGGER update_worker_rating
AFTER INSERT ON Review
FOR EACH ROW
BEGIN
    DECLARE total_ratings INT;
    DECLARE new_rating DOUBLE;
    
    -- Calculate the new average rating
    SELECT COUNT(*), AVG(Rating) INTO total_ratings, new_rating
    FROM Review
    WHERE wid = NEW.wid;

    -- Update the Worker table with the new rating
    UPDATE Worker
    SET rating = new_rating
    WHERE id = NEW.wid;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER after_worker_insert
AFTER INSERT ON Worker
FOR EACH ROW
BEGIN
    INSERT INTO wAccount (wid, Amount) VALUES (NEW.id, 0);
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER insert_service
AFTER INSERT ON Service
FOR EACH ROW
BEGIN
        INSERT INTO Status (sid, status, date) VALUES (NEW.sid, "Booked", CURDATE());
END;
//
DELIMITER ;

DELIMITER //

CREATE TRIGGER after_insert_payment
AFTER INSERT ON payment
FOR EACH ROW
BEGIN
    DECLARE feeAmount DOUBLE;
    DECLARE widValue INT;

    SELECT fee, wid INTO feeAmount, widValue FROM service WHERE sid = NEW.sid;

    UPDATE wAccount SET Amount = Amount + feeAmount WHERE wid = widValue;
END;
//

DELIMITER ;

DELIMITER //
CREATE TRIGGER after_withdraw_insert
AFTER INSERT ON withdraw
FOR EACH ROW
BEGIN
    UPDATE wAccount
    SET Amount = Amount - NEW.amount
    WHERE wid = NEW.wid;
END;
//
DELIMITER ;


select * from status;
Select * from Customer;
Select * from review;
Select * from Worker;
Select * from Customer;
Select * from Service;
select * from wAccount;
Select * from payment;






