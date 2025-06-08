# Quiz Application

A Spring Boot REST API for managing users and quizzes backed by a MySQL database.

## Technology Stack

* **Java**: Java 8
* **Spring Boot**: 2.7.x
* **ORM**: Spring Data JPA / Hibernate
* **Database**: MySQL 8+
* **Build Tool**: Maven
* **Validation**: Hibernate Validator
* **Connection Pool**: HikariCP

## Project Structure

```
quiz-application/
├── src/
│   ├── main/
│   │   ├── java/com/quiz/application/
│   │   │   ├── QuizApplication.java       # main entrance
│   │   │   ├── controller/       # REST controllers
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   ├── entity/           # JPA entities
│   │   │   ├── exception/        # Custom exceptions & handlers
│   │   │   ├── repository/       # Spring Data repositories
│   │   │   ├── service/          # Service interfaces & implementations
│   │   │   └── util/             # Response utility
│   │   └── resources/
│   │       └── application.properties
│   └── test/                    # Unit & integration tests
├── database/
│   ├── quiz_database.sql       # Schema DDL
│   └── sample_data.sql         # Sample records
├──  Quiz_Application_API_Tests.postman_collection.json
├── pom.xml
└── README.md                   # This file
```

## Prerequisites

* Java 8 JDK installed
* Maven 3.x installed
* MySQL 8.x server running

## Setup Instructions

1. **Clone the repository**:

   ```bash
   git clone <repository-url>
   cd quiz-application
   ```

2. **Create the database**:

   ```sql
   -- In MySQL client or Workbench
   SOURCE database/quiz_database.sql;
   SOURCE database/sample_data.sql;
   ```

3. **Configure database credentials**:
   Edit `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/quiz_application?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=YOUR_DB_PASSWORD
   ```

4. **Build the project**:

   ```bash
   mvn clean package
   ```

5. **Run the application**:

   ```bash
   mvn spring-boot:run
   ```

   or

   ```bash
   java -jar target/quiz-application-1.0.0.jar
   ```

6. **Verify health endpoint**:

   ```bash
   curl http://localhost:8080/health
   # Should return: OK
   ```

## API Endpoints

### User Management

| Method | Endpoint                                   | Description                |
| ------ | ------------------------------------------ | -------------------------- |
| POST   | `/user`                                    | Create a new user          |
| DELETE | `/user?userId={id}`                        | Delete an existing user    |
| PATCH  | `/user/{userId}/status?activate={boolean}` | Activate or suspend a user |
| GET    | `/user`                                    | Get all users              |
| GET    | `/user?userId={id}`                        | Get a user by ID           |

### Quiz Management

| Method | Endpoint            | Description                     |
| ------ | ------------------- | ------------------------------- |
| GET    | `/quiz?userId={id}` | Get all quizzes taken by a user |

## Response Format

All endpoints return a JSON object with the following structure:

```json
{
  "success": true | false,
  "message": "error or null",
  "data": <object or array>,
  "timestamp": "2025-06-08T..."
}
```

## Testing

1. **Postman Collection**: Import `postman/Quiz_Application_API_Tests.postman_collection.json`.
2. **Run tests**: Execute requests for all endpoints, including error cases.
3. **Review responses**: Ensure correct HTTP status codes and JSON structure.


