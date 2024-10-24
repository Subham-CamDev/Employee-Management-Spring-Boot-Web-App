# Employee Management REST API

This project is a simple Employee Management system that allows you to create, update, search, and delete employee records via a REST API built using Spring Boot, Hibernate, and MySQL. It also incorporates Spring Security for authentication and authorization, allowing users to sign up and perform authenticated requests. The application is deployed on Apache Tomcat.

## Features

- **Create Employee**: Add a new employee to the database.
- **Update Employee**: Modify the details of an existing employee.
- **Read Employee**: Get the details of a specific employee.
- **Read All Employees**: Retrieve a list of all employees.
- **Search Employees**: Search for employees based on name or department.
- **Delete Employee**: Remove an employee from the database.
- **User Authentication**: Users can sign up and authenticate themselves via Spring Security to access the API.

## Technologies Used

- **Spring Boot**: Framework for building Java-based web applications.
- **Hibernate**: ORM framework to interact with MySQL database.
- **MySQL**: Database used to store employee data.
- **Spring Security**: Used for securing the API with user authentication.
- **Apache Tomcat**: Server used to deploy the application.
- **Postman**: Used for API testing and generating collections of API requests.

- ## API Endpoints

| HTTP Method | Endpoint               | Description                     |
|-------------|------------------------|---------------------------------|
| `POST`      | `/api/employee`        | Create a new employee           |
| `PUT`       | `/api/employee/{id}`   | Update an employee by ID        |
| `GET`       | `/api/employee/{id}`   | Get employee details by ID      |
| `GET`       | `/api/employee`        | Get all employees               |
| `GET`       | `/api/employee/search/{parameter}` | Search employees by name or department or DOB |
| `DELETE`    | `/api/employee/{id}`   | Delete an employee by ID        |

## Authentication

- Users must first sign up using the `/register` endpoint.
- After signing up, use the login credentials (username and password) to authenticate requests via Basic Authentication.

### Authentication Endpoints

| HTTP Method | Endpoint   | Description     |
|-------------|------------|-----------------|
| `POST`      | `/register`  | Sign up a user  |

### Configure MySQL database in the `application.properties` file (usually located in `src/main/resources`):

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=root
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```
### There are two tables present in the MySQL database, one is Employee table for handling all the employee related database operations and, the other table is Users table that will contain all the user credentials.

### Run the Spring Application from your IDE 

### Access the REST API at `http://localhost:8080`.
