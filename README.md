# LiveOn Backend Core Java Project

# Milestone -1
### In Milestone-1, we will focus on implementing the backend logic and functionalities to support the Sparepart CRUD operations.

## Product Model:
#### Design a Sparepart model to represent the properties of a spare part, such as name, description, price, rating, images list, and product type relevant attributes.


## Product Table Schema
| Column        | Type              | Constraints                   |
|---------------|-------------------|-------------------------------|
| id            | INT               | AUTO_INCREMENT, PRIMARY KEY   |
| name          | VARCHAR (255)     | NOT NULL                      |
| vehicle_type  | ENUM('Bike','Car')| NOT NULL                      |
| price         | DOUBLE            | NOT NULL                      |
| rating        | INT               | NOT NULL                      |
| description   | TEXT              | NOT NULL                      |

## ProductImages Table Schema
| Column         | Type         | Constraints                                |
|----------------|--------------|--------------------------------------------|
| img_id         | INT          | PRIMARY KEY, AUTO_INCREMENT                |
| SparePart_Id   | INT          | NOT NULL, FOREIGN KEY (SparePart_Id)       |
| imageUrl       | TEXT         | NOT NULL                                   |

## Database Design
![Screenshot (152)](https://github.com/fssa-batch3/sec_c_sec_c_yogeshwari.selvendran__corejava_project_2/assets/116252201/23c42d64-4c10-4705-96a2-3a326cfcedf8)
