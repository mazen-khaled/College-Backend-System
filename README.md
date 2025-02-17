# College Student Management System (Backend)

This is a Spring Boot-based backend application for managing student data in a college system. It provides RESTful APIs to perform CRUD operations on student records.

## Features

- **Create Student**: Add a new student to the system.
- **Read Student**: Retrieve student details by ID or fetch all students.
- **Update Student**: Modify existing student data.
- **Delete Student**: Remove a student from the system by ID.
- **Email Validation**: Ensures no duplicate email addresses are registered.

## Technologies Used

- **Spring Boot**: Backend framework for building the application.
- **Spring Data JPA**: For database operations and ORM.
- **H2 Database**: In-memory database for development (can be replaced with MySQL, PostgreSQL, etc.).
- **Maven**: Build automation and dependency management.
- **RESTful APIs**: Exposes endpoints for CRUD operations.

## API Endpoints

| HTTP Method | Endpoint                | Description                              |
|-------------|-------------------------|------------------------------------------|
| `GET`       | `/v1/students`          | Get all students.                        |
| `GET`       | `/v1/students/{id}`     | Get a student by ID.                     |
| `POST`      | `/v1/students`          | Add a new student.                       |
| `PUT`       | `/v1/students`          | Update an existing student.              |
| `DELETE`    | `/v1/students/{id}`     | Delete a student by ID.                  |

## Getting Started

### Prerequisites

- Java 17 or higher.
- Maven 3.x.x.
- An IDE (e.g., IntelliJ IDEA, Eclipse).

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/mazen-khaled/College-Backend-System.git
   cd College-Backend-System
   
2. **Clone the repository**:
   ```bash
   mvn clean install
   
3. **Run the application**:
   ```bash
   mvn spring-boot:run

## Example Requests
**Add a New Student**
```bash
curl -X POST http://localhost:8080/v1/students \
-H "Content-Type: application/json" \
-d '{
    "studentName": "Mazen Khaled",
    "studentEmail": "Mazen.Khaled@example.com",
    "studentDOB": "2001-03-14",
    "studentGPA": 3.8
}'
```

**Get All Students**
```bash
curl -X GET http://localhost:8080/v1/students
```

**Get Student by ID**
```bash
Copy
curl -X GET http://localhost:8080/v1/students/1
```

**Update Student**
```bash
curl -X PUT http://localhost:8080/v1/students \
-H "Content-Type: application/json" \
-d '{
    "studentId": 1,
    "studentName": "Mazen Khaled",
    "studentEmail": "Mazen.Khaled@example.com",
    "studentDOB": "2000-01-01",
    "studentGPA": 3.8
}'
```
**Delete Student by ID**
```bash
curl -X DELETE http://localhost:8080/v1/students/1
```

## Project Structure
src/main/java
```
├── com.example.College_System
│   ├── CollegePackage
│   │   ├── Student
│   │   │   ├── ControllerLayer
│   │   │   │   └── StudentControl.java
│   │   │   ├── DataBaseLayer
│   │   │   │   └── Student.java
│   │   │   ├── DatabaseConfig
│   │   │   │   └── StudentConfig.java
│   │   │   ├── ReposatoryLayer
│   │   │   │   └── StudentRepository.java
│   │   │   └── ServiceLayer
│   │   │       └── StudentService.java
│   └── CollegeSystemApplication.java
