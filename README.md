# Library Management System

A backend-focused Library Management System built using Spring Boot, Hibernate, and H2/MySQL that provides complete CRUD functionality for managing authors, books, and categories through RESTful APIs.

This project demonstrates database-driven backend development, REST API design, and application-level data validation.

---

## Features

- CRUD operations for:
  - Authors  
  - Books  
  - Categories  
- REST APIs for storing, updating, retrieving, and deleting library data  
- Database persistence using Hibernate ORM  
- H2 used for development with easy switching to MySQL for production  
- Application-level data validation and consistency checks  
- Clean and scalable backend architecture  
- Fully testable using Postman  

---

## Technology Stack

### Backend
- Java  
- Spring Boot  
- Hibernate  
- REST APIs  
- Maven  

### Database
- H2 (Development)  
- MySQL (Production - Optional)  

### Tools and Version Control
- Git  
- GitHub  
- Postman (for API testing)  

---

## Setup Instructions

Follow the steps below to run this project locally.

### Prerequisites

- Java  
- Maven  
- Git  

---

### Application Setup

git clone https://github.com/Avisek9/library-management-system.git

cd library-management-system

mvn clean install  

mvn spring-boot:run  

The application will start on:

http://localhost:8080  

H2 Console (Optional):

http://localhost:8080/h2-console  

---

## API Documentation

### Author APIs (`/api/authors`)

| Method | Endpoint            | Description              |
|--------|---------------------|--------------------------|
| GET    | /api/authors        | Get all authors          |
| GET    | /api/authors/{id}   | Get author by ID         |
| POST   | /api/authors        | Create a new author      |
| PUT    | /api/authors/{id}   | Update author by ID      |
| DELETE | /api/authors/{id}   | Delete author by ID      |

---

### Book APIs (`/api/books`)

| Method | Endpoint           | Description             |
|--------|--------------------|-------------------------|
| GET    | /api/books         | Get all books           |
| GET    | /api/books/{id}    | Get book by ID          |
| POST   | /api/books         | Create a new book       |
| PUT    | /api/books/{id}    | Update book by ID       |
| DELETE | /api/books/{id}    | Delete book by ID       |

---

### Category APIs (`/api/categories`)

| Method | Endpoint                | Description                 |
|--------|--------------------------|------------------------------|
| GET    | /api/categories         | Get all categories          |
| GET    | /api/categories/{id}    | Get category by ID          |
| POST   | /api/categories         | Create a new category       |
| PUT    | /api/categories/{id}    | Update category by ID       |
| DELETE | /api/categories/{id}    | Delete category by ID       |

---

## Switching from H2 to MySQL

- Update database configuration in `application.properties`  
- Replace H2 JDBC URL with MySQL JDBC URL  
- Set MySQL username and password  
- Run the application again  

---

## Data Validation and Consistency

- Prevents operations on non-existing records  
- Ensures valid IDs before update and delete  
- Maintains consistency between authors, books, and categories  
- Application-level validation ensures safe CRUD operations  

---

## Future Enhancements

- User authentication and role-based access control  
- Borrowing and return system  
- Fine and penalty management  
- Reservation and waitlist system  
- Swagger API documentation  

---

## Author

Abhishek Sahu  
GitHub: https://github.com/your-github-username  
LinkedIn: https://linkedin.com/in/your-linkedin-username  

---

If you find this project useful, feel free to give it a star.
