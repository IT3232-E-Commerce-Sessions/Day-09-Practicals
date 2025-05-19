# Day-09-Practicals

A Spring Boot application for managing departments, employees, and projects with JPA/Hibernate relationships.

## Features

- **Department Management**
  - CRUD operations for departments
  - Track establishment dates
  - One-to-Many relationship with Employees

- **Employee Management**
  - CRUD operations for employees
  - Track employee details (name, age, salary, gender)
  - Many-to-One relationship with Department
  - Many-to-Many relationship with Projects

- **Project Management**
  - CRUD operations for projects
  - Track project costs
  - Many-to-Many relationship with Employees

## Technologies

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Maven
- Mysql Driver



## API Documentation

### Department Endpoints

| Method | Endpoint         | Description            |
|--------|-----------------|------------------------|
| GET    | /dept           | Get all departments    |
| GET    | /dept/{id}      | Get department by ID   |
| POST   | /dept           | Create new department  |
| PUT    | /dept/{id}      | Update department      |
| DELETE | /dept/{id}      | Delete department      |

### Employee Endpoints

| Method | Endpoint              | Description           |
|--------|----------------------|-----------------------|
| GET    | /employees           | Get all employees     |
| GET    | /employees/{empNo}   | Get employee by ID    |
| POST   | /employees           | Create new employee   |
| PUT    | /employees/{empNo}   | Update employee       |
| DELETE | /employees/{empNo}   | Delete employee       |

### Project Endpoints

| Method | Endpoint         | Description           |
|--------|-----------------|-----------------------|
| GET    | /projects       | Get all projects      |
| GET    | /projects/{id}  | Get project by ID     |
| POST   | /projects       | Create new project    |
| PUT    | /projects/{id}  | Update project        |
| DELETE | /projects/{id}  | Delete project        |
