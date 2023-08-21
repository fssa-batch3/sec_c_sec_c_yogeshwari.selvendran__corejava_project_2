use yogeshwari_selvendran_corejava_project;

CREATE TABLE Sparepart (
-- product_id change into id
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (255) NOT NULL,
vehicle_type enum('Bike','Car') not null,
price DOUBLE NOT NULL,
rating INT NOT NULL,
description TEXT NOT NULL
);

CREATE TABLE SparePartImages (
-- img_id for image table
    img_id INT PRIMARY KEY AUTO_INCREMENT,
 --   product_Id change into SparePart_Id
    SparePart_Id INT NOT NULL,
    imageUrl TEXT NOT NULL,
    FOREIGN KEY (SparePart_Id) REFERENCES Sparepart(id)
);

DELIMITER &&
CREATE  PROCEDURE `InsertSparepart`(
IN name VARCHAR(255),
IN vehicle_type enum('Bike','Car'),
IN price DOUBLE,
IN rating INT,
IN description TEXT,
IN SparepartImagesList TEXT -- Comma-separated list of image URLs
)
BEGIN
    -- Insert the data into the Ground table
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
IN namein VARCHAR(255),
IN vehicle_typein enum('Bike','Car'),
IN pricein DOUBLE,
IN ratingin INT,
IN descriptionin TEXT,
IN SparepartImagesListin TEXT -- Comma-separated list of image URLs
)
BEGIN
    -- Insert the data into the Ground table
   UPDATE Sparepart SET
		  name =namein,
        vehicle_type = vehicle_typein,
        price = pricein,
        rating = ratingin,
        description = descriptionin
        WHERE
       id = sparePartsIdin;
    DELETE FROM SparePartImages WHERE SparePart_Id = sparePartsIdin;
    -- Insert productImages into the GroundImages table
    SET @SparepartImagesList = SparepartImagesListin;
    WHILE CHAR_LENGTH(@SparepartImagesList) > 0 DO
        SET @imageUrl = SUBSTRING_INDEX(@SparepartImagesList, ',', 1);
        INSERT INTO SparePartImages (SparePart_Id, imageUrl) VALUES (sparePartsIdin, @imageUrl);
        SET @SparepartImagesList= SUBSTRING(@SparepartImagesList, CHAR_LENGTH(@imageUrl) + 2);
    END WHILE;
END &&
DELIMITER ;
 -- DROP PROCEDURE IF EXISTS UpdateGround;
DELIMITER &&
CREATE PROCEDURE DeleteSpareParts(
    IN sparePartsIdin INT
)
BEGIN
    DELETE FROM SparePartImages WHERE SparePart_Id = sparePartsIdin;
    DELETE FROM Sparepart WHERE id = sparePartsIdin;
END &&
DELIMITER &&

 SELECT sp.*, spi.imageUrl
 FROM Sparepart sp
LEFT JOIN SparePartImages spi ON sp.id = spi.SparePart_Id;
 WHERE sp.vehicle_type = 'Bike'
 GROUP BY sp.id;
SELECT
    sp.*,
    (SELECT GROUP_CONCAT(imageUrl) FROM SparePartImages spi WHERE spi.SparePart_Id = sp.id) AS imageUrls
FROM Sparepart sp;

