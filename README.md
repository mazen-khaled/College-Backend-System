# College Management System

## 📋 Overview
This **College Management System** is a full-stack application developed using **Spring Boot** for the backend and **HTML, CSS, JavaScript** for the frontend. It is designed to handle student information such as registration, profile management, and authentication.

The system enables administrators and users to:
- Register new students.
- Retrieve student information by ID or email.
- Update student profiles.
- Delete student records.
- Handle login functionality with password verification.

## 🚀 Features
### Backend (Spring Boot)
- **CRUD Operations** for managing student data.
- **JPA Repository** integration for seamless database communication.
- **Email Validation** to ensure unique student emails.
- **Exception Handling** for missing or invalid data.
- **CORS Configuration** for secure cross-origin requests.

### Frontend
- User-friendly login and sign-up forms.
- Profile display and update functionality.
- Dynamic interaction using JavaScript for form validation and profile updates.

## 🏗️ Project Structure
```
com.example.College_System
│
├── CollegePackage.Student
│   ├── ControllerLayer         # REST controllers
│   ├── DataBaseLayer           # Student entity and database models
│   ├── DatabaseConfig          # Database and CORS configuration
│   ├── ReposatoryLayer         # JPA repository for database operations
│   └── ServiceLayer            # Business logic services
│
├── Frontend
│   ├── HTML_Files              # Login and profile pages
│   ├── CSS_Files               # Styling for pages
│   └── JS_Files                # JavaScript for interactivity
```

## 🔧 Technologies Used
- **Backend:** Java, Spring Boot, JPA, Hibernate
- **Frontend:** HTML, CSS, JavaScript
- **Database:** H2 Database (in-memory)
- **Build Tool:** Maven

## 🛠️ Installation & Setup
### Prerequisites
- Java JDK 17+
- Maven

### Backend Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/college-management-system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd college-management-system
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Frontend Setup
1. Open the HTML files directly in your browser, or use a local server (e.g., **Live Server** extension in VSCode).

## 📖 API Endpoints
| Method | Endpoint               | Description                         |
|--------|------------------------|-------------------------------------|
| GET    | `/v1/students`        | Retrieve all students               |
| GET    | `/v1/students/id/{id}`| Get student by ID                   |
| GET    | `/v1/students/email/{email}` | Get student by email         |
| POST   | `/v1/students`        | Add a new student                   |
| PUT    | `/v1/students`        | Update an existing student          |
| DELETE | `/v1/students/{id}`   | Delete student by ID                |

## 🎯 Usage Example
**POST** Add New Student:
```json
{
  "studentName": "Mazen Khaled",
  "studentEmail": "kmazen275@gmail.com",
  "studentPassword": "1234",
  "studentDOB": "2001-03-14",
  "studentGPA": 3.5
}
```

**GET** Retrieve Student by ID:
```
GET /v1/students/id/1
```

## 💡 Future Improvements
- Role-based authentication (Admin, Student).
- Enhanced frontend with React or Angular.
- Implement JWT-based authentication.

## 📬 Contact
For questions or feedback:
- Email: [kmazen275@gmail.com](mailto:kmazen275@gmail.com)

Enjoy using the **College Management System**! 🎓
