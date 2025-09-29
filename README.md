# User Management API

REST API for user management built with Spring Boot.

## Features

- User CRUD operations
- Sorting and filtering
- User authentication
- Data validation
- Password encryption (AES-256)

## Requirements

- Java 11
- Maven 3.6+
- Docker (optional)

## Installation

1. Clone the repository
2. Build with Maven: `mvn clean package`
3. Run: `java -jar target/user-api-1.0.0.jar`

## Docker

```bash
docker build -t user-api .
docker run -p 8080:8080 user-api
