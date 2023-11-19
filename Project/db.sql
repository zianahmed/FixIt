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
    rating double,
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

CREATE TABLE Review (
wid INT,
cid INT,
date date,
Rating INT,
review TEXT
);

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


Select * from Customer;
Select * from review;
Select * from Worker;
Select * from Customer;
Select * from Service;
truncate table service;

Select s.sid as 's',c.name as 'customer',w.name as 'worker',s.date as 'date',w.phoneNo as 'wphone',s.addr as 'address',s.details as 'detail',s.fee as 'fee'
FROM Service s 
Inner Join Worker w on s.wid=w.id
Inner Join Customer c ON c.id=s.cid
where s.cid=1 AND status="Pending" 




