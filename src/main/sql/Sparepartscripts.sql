-- CREATE DATABASE IF NOT EXISTS liveonbackend2;
use liveonbackend2;
CREATE TABLE Sparepart (
-- product_id change into id
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (255) NOT NULL UNIQUE,
vehicle_type enum('Bike','Car') not null,
price DOUBLE NOT NULL,
rating INT NOT NULL,
description varchar(500) NOT NULL,
 sparepartstatus  TINYINT DEFAULT 1
);
 select * from Sparepart;
-- DROP TABLE Sparepart;
CREATE TABLE SparePartImages (
-- img_id for image table
    img_id INT PRIMARY KEY AUTO_INCREMENT,
 --   product_Id change into SparePart_Id
    SparePart_Id INT NOT NULL,
    imageUrl TEXT NOT NULL,
    FOREIGN KEY (SparePart_Id) REFERENCES Sparepart(id)
);
 select * from SparePartImages;

-- DROP TABLE SparePartImages;
DELIMITER &&
CREATE  PROCEDURE `InsertSparepart`(
IN name VARCHAR(255),
IN vehicle_type enum('Bike','Car'),
IN price DOUBLE,
IN rating INT,
IN description VARCHAR(500),
IN SparepartImagesList TEXT -- Comma-separated list of image URLs
)
BEGIN
 
    INSERT INTO Sparepart (
        name,
        vehicle_type,
        price,
        rating,
        description
    ) VALUES (
        name,
        vehicle_type,
        price,
        rating,
        description
    );
     -- Get the auto-generated id of the newly inserted row
    SET @id = LAST_INSERT_ID();
    -- Insert sparepartsImages into the sparepartsImages table
    SET @SparepartImagesList = SparepartImagesList;
    WHILE CHAR_LENGTH(@SparepartImagesList) > 0 DO
        SET @imageUrl = SUBSTRING_INDEX(@SparepartImagesList, ',', 1);
        INSERT INTO SparePartImages (SparePart_Id, imageUrl) VALUES (@id, @imageUrl);
        SET @SparepartImagesList = SUBSTRING(@SparepartImagesList, CHAR_LENGTH(@imageUrl) + 2);
    END WHILE;
END &&
DELIMITER;
DELIMITER &&
CREATE  PROCEDURE `UpdateSpare_part`(
 IN sparePartsIdin INT ,
IN name VARCHAR(255),
IN vehicle_type enum('Bike','Car'),
IN price DOUBLE,
IN rating INT,
IN description VARCHAR(500),
IN SparepartImagesList TEXT -- Comma-separated list of image URLs
)
BEGIN
   
   UPDATE Sparepart SET
		  name =name,
        vehicle_type = vehicle_type,
        price = price,
        rating = rating,
        description = description
        WHERE
       id = sparePartsIdin;
    DELETE FROM SparePartImages WHERE SparePart_Id = sparePartsIdin;
    -- Insert productImages into the table
    SET @SparepartImagesList = SparepartImagesList;
    WHILE CHAR_LENGTH(@SparepartImagesList) > 0 DO
        SET @imageUrl = SUBSTRING_INDEX(@SparepartImagesList, ',', 1);
        INSERT INTO SparePartImages (SparePart_Id, imageUrl) VALUES (sparePartsIdin, @imageUrl);
        SET @SparepartImagesList= SUBSTRING(@SparepartImagesList, CHAR_LENGTH(@imageUrl) + 2);
    END WHILE;
END &&
DELIMITER ;

DELIMITER &&
CREATE PROCEDURE DeleteSparePart(
   IN sparePartsIdin INT
)
BEGIN
    -- Set the sparepartStatus to FALSE (0) for the given 
    UPDATE Sparepart
    SET sparepartstatus = 0
    WHERE id = sparePartsIdin;
END &&
DELIMITER &&;
 SELECT sp.*, spi.imageUrl
 FROM Sparepart sp
LEFT JOIN SparePartImages spi ON sp.id = spi.SparePart_Id;
 WHERE sp.vehicle_type = 'Bike'
 GROUP BY sp.id;
SELECT
    sp.*,
    (SELECT GROUP_CONCAT(imageUrl) FROM SparePartImages spi WHERE spi.SparePart_Id = sp.id) AS imageUrls FROM Sparepart sp;
END && 
DELIMITER ;
 select * from USER;
CREATE TABLE USER (
id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(35) NOT NULL,
    lastname VARCHAR(35) NOT NULL,
    gender enum('Male','Female') not null,
    mobile BIGINT NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
      status  TINYINT DEFAULT 1
);
SELECT sp.*, (
    SELECT GROUP_CONCAT(imageUrl) 
    FROM SparePartImages spi 
    WHERE spi.SparePart_Id = sp.id
) AS imageUrls
FROM Sparepart sp
WHERE sp.sparepartstatus = 1;

CREATE TABLE Orders (
    orderID INT PRIMARY KEY AUTO_INCREMENT,
    sparepart_id INT NOT NULL,
    user_id INT NOT NULL,
    DateAdded TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    street_address VARCHAR(255),
    city VARCHAR(255),
    postal_code VARCHAR(20),
    orderStatus VARCHAR(20), 
    paymentMethod VARCHAR(20), 
   FOREIGN KEY (sparepart_id) REFERENCES Sparepart(id),
    FOREIGN KEY (user_id) REFERENCES USER(id) 
);
 select * from Orders;
 CREATE TABLE Partners (
    partnerId INT AUTO_INCREMENT PRIMARY KEY,
    shopName VARCHAR(255),
    shopNumber BIGINT,
    shopLicenceNumber VARCHAR(255),
    streetAddress VARCHAR(255),
    city VARCHAR(255),
    postalCode VARCHAR(20), 
    vehicleType VARCHAR(50),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    gender VARCHAR(10), 
    email VARCHAR(255),
    number BIGINT,
    password VARCHAR(255)
);
 select * from Partners;

 CREATE TABLE appointments (
    bookingId INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
    bookingDate DATE,
    bookingTime TIME,
    vehicletype VARCHAR(255),
    vehicleservice VARCHAR(255),
    streetAddress VARCHAR(255),
    city VARCHAR(255),
    postalCode VARCHAR(20),
  --  bookingstatus varchar(15) NOT NULL DEFAULT 'Pending',
       FOREIGN KEY (user_id) REFERENCES USER(id) 
);
 select * from appointments;
-- DROP TABLE appointments;

SELECT a.bookingId, a.user_id, a.bookingDate, a.bookingTime, a.vehicletype, a.vehicleservice, 
       a.streetAddress, a.city, a.postalCode, 
       u.firstname, u.lastname, u.gender, u.mobile, u.email
FROM appointments a
JOIN USER u ON a.user_id = u.id;

-- this is the code

SELECT
    o.orderID,
    MAX(o.DateAdded) AS orderDate,
    MAX(u.firstname) AS userFirstName,
    MAX(u.lastname) AS userLastName,
    MAX(u.gender) AS userGender,
    MAX(u.mobile) AS userMobile,
    MAX(u.email) AS userEmail,
    MAX(sp.name) AS sparepartName,
    MAX(sp.vehicle_type) AS sparepartVehicleType,
    MAX(sp.price) AS sparepartPrice,
    MAX(sp.rating) AS sparepartRating,
    MAX(sp.description) AS sparepartDescription,
    MAX(o.street_address) AS orderAddress,
    MAX(o.city) AS orderCity,
    MAX(o.postal_code) AS orderPostalCode,
    MAX(o.orderStatus) AS orderStatus,
    MAX(o.paymentMethod) AS paymentMethod,
    MAX(spi.img_id) AS imageId,
    MAX(spi.imageUrl) AS sparepartImageUrl
FROM Orders AS o
INNER JOIN USER AS u ON o.user_id = u.id
INNER JOIN Sparepart AS sp ON o.sparepart_id = sp.id
LEFT JOIN SparePartImages AS spi ON sp.id = spi.SparePart_Id
GROUP BY o.orderID;

