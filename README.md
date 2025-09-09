
# TaskGuard - Enterprise Task Management System

## Overview
TaskGuard is a robust, secure, and scalable task management application built using Domain-Driven Design (DDD) principles and modern enterprise Java technologies.

## 🚀 Technologies Stack

### Backend
- **Framework**: Spring Boot 3.5.5
- **Language**: Java 21
- **ORM**: Spring Data JPA
- **Database**: PostgreSQL
- **Security**: Spring Security
- **Authentication**: JWT (JSON Web Tokens)

### Key Dependencies
- Hibernate Validator
- Lombok
- dotenv-java
- Spring Web MVC

## 🏗️ Architecture

### Domain-Driven Design (DDD)
TaskGuard follows Domain-Driven Design principles, emphasizing:
- Ubiquitous Language
- Bounded Contexts
- Rich Domain Models
- Separation of Concerns

#### Architectural Layers
1. **Presentation Layer**: REST Controllers
2. **Application Layer**: Service Components
3. **Domain Layer**: Core Business Logic
4. **Persistence Layer**: JPA Repositories
5. **Infrastructure Layer**: Cross-cutting Concerns

### Design Patterns
- Repository Pattern
- Service Layer Pattern
- DTO (Data Transfer Object) Pattern
- Dependency Injection

## 🔒 Security Features
- JWT-based Authentication
- Password Encryption
- Secure Endpoint Protection

## 📦 Database
- PostgreSQL Database
- Hibernate ORM

## 🚀 Getting Started

### Prerequisites
- Java 21 JDK
- Maven
- PostgreSQL

### Configuration
1. Clone the repository
2. Configure `.env` file with database credentials
3. Run database migrations
4. Build the project: `mvn clean install`
5. Run the application: `mvn spring-boot:run`

## 📝 Environment Variables
- `DB_URL`: Database Connection URL
- `DB_USERNAME`: Database Username
- `DB_PASSWORD`: Database Password

## 🤝 Contributing
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request