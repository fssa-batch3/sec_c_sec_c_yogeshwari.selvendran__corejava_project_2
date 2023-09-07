# LiveOn Backend Core Java Project

# Vehicle Breakdown Assistance & Spare Parts Website
## Problem Statement
Have you ever been in a situation where you were out with a family member, and suddenly your bike or vehicle refused to start? It can be a frustrating and inconvenient experience, especially when you're stuck on a highway far from home. In such moments, quick and reliable assistance is essential.


## Solution
Our project offers a comprehensive solution to the problem of vehicle breakdowns. Not only do we provide prompt breakdown assistance, but we also offer a range of spare parts for sale on our website. Our goal is to minimize inconvenience and ensure your safety, whether it's getting you back on the road quickly or helping you find the right spare parts for your vehicle.


## Key Features
- **Fast Response**: We understand the stress of being stranded. Our breakdown assistance service guarantees a rapid response to get you moving again as soon as possible.
- **24/7 Availability**: Breakdowns can occur at any time. We operate 24/7 to ensure you have access to assistance when you need it most.
- **Skilled Mechanics**: Our team comprises experienced and skilled mechanics who can handle various types of breakdowns.
- **On-Site Repairs**: Whenever possible, we aim to fix the issue on-site to save you the trouble of towing your vehicle.
- **Towing Service**: In cases where on-site repairs aren't feasible, we provide reliable towing services to transport your vehicle to a repair shop.
- **Spare Parts Store**: Visit our website to browse and purchase a wide range of spare parts for your vehicle. We offer competitive prices and convenient shipping options.

## Purchasing Spare Parts
1. Visit our website at https://deploy-preview-1--livez-on.netlify.app/index.html.
2. Browse our selection of spare parts for your vehicle.
3. Add items to your cart and proceed to checkout.
4. Choose your preferred shipping method.
5. Complete the payment process.
6. Sit back and wait for your spare parts to arrive at your doorstep.

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
