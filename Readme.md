*E-Commerce Web Application*

This project is a simple e-commerce web application built with Spring Boot, Spring Security, and a MySQL database. It provides functionality for user registration, authentication, product listing, category management, and a basic shopping cart system.

Features
User Registration & Authentication:
Users can register for an account and log in using their credentials. Passwords are stored securely using hashing.

JWT-Based Security:
Authenticated requests are protected by JSON Web Tokens. After logging in, clients receive a JWT token to include in subsequent requests.

Category & Product Management:
The application includes endpoints to list categories and products, create new categories, update or delete existing ones, and retrieve product details.

Shopping Cart Functionality:
Authenticated users can view their shopping cart, add products, update product quantities, and clear their cart.

Technologies Used
Backend:

Java 11+
Spring Boot
Spring Security
Hibernate/JPA
MySQL
Maven for build and dependency management
Database:

MySQL database for persistent storage of users, products, categories, and shopping cart items.
Security:

JWT tokens for authentication
Role-based access for secure endpoints
Prerequisites
Java 11+
Maven 3.6+
MySQL 5.7+ or 8.0+
Ensure you have a MySQL database running and accessible.

-----------------------------------------------------------------------------------------------------------
I was only able to finish all bugs in All products, finish all thing Category and Everything shopping car except for 
shopping cart controller. I had problems with it and had to comment everything out.