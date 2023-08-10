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

## Dtabace Design
![Screenshot (149)](https://github.com/fssa-batch3/sec_c_sec_c_yogeshwari.selvendran__corejava_project_2/assets/116252201/27cc2bdc-f98a-45a0-b0ab-020002c464a0)

