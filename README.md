# LiveOn Backend Core Java Project

# Milestone -1
### In Milestone-1, we will focus on implementing the backend logic and functionalities to support the Product CRUD operations.

## Product Model:
#### Design a Product model to represent the properties of a product, such as name, description, price, aboutproduct, rating, images list  and  product type relevant attributes.


## Product Table Schema
| Column       | Data Type           | Constraints                   | Description                                      |
|--------------|---------------------|-------------------------------|--------------------------------------------------|
| product_id   | INT                 | AUTO_INCREMENT, PRIMARY KEY   | Unique identifier for the product                |
| productName  | VARCHAR(255)        | NOT NULL                      | Name of the product                              |
| vehicle_type | ENUM('Bike','Car')  | NOT NULL                      | Type of vehicle the product is meant for         |
| price        | DOUBLE              | NOT NULL                      | Price of the product                             |
| rating       | INT                 | NOT NULL                      | Rating of the product (e.g., user reviews)       |
| aboutProduct | TEXT                | NOT NULL                      | Brief overview or summary of the product         |
| description  | TEXT                | NOT NULL                      | Detailed description of the product              |


## ProductImages Table Schema

| Column      | Data Type | Constraints                            | Description                               |
|-------------|-----------|---------------------------------------|-------------------------------------------|
| id          | INT       | PRIMARY KEY, AUTO_INCREMENT            | Unique identifier for each image          |
| product_Id  | INT       | NOT NULL, FOREIGN KEY (Product)        | References the associated product's ID    |
| imageUrl    | VARCHAR   | NOT NULL                              | URL of the image associated with product  |
