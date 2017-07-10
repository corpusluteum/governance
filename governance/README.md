# Example RESTful Api with React and Spring
---

**Application Name:** Governance

Governance is an example RESTful application that uses React for client and Spring Boot as backend service. 

**MySQL create script with initial data:** [db_governance.sql](files/db_governance.sql)

**Governance ER Diagram:**

![Governance ER](/files/databaseShcema.png)

**TODO:**

* Add client side input validation, toast notification and loader effect
* Add RESTful fail checks both for client and server side
* May add service interfaces
* Add client tests


## Server Application

**Techs:** Spring Boot as RESTful backend, Maven, Hibernate, MySQL
	
**RESTful API Address:** http://localhost:8080

**Simple endpoints - Employee**
 * HTTP GET 	: "localhost:8080/employee/list" getting all employees.
 * HTTP GET 	: "localhost:8080/employee/list/{id}" get an employee by id.
 * HTTP POST	: "localhost:8080/employee/add" create a new employee.
 * HTTP PUT 	: "localhost:8080/employee/update/{id}" update an existing employee.
 * HTTP DELETE : "localhost:8080/employees/delete/{id}" delete an employee by id.


**Maven Run Configurations**

`clean spring-boot:run`: clean and run Spring Boot application


## Client Application

This project template was built with [Create React App](https://github.com/facebookincubator/create-react-app). (**requires Node**)

**Techs:** React, react-bootstrap, axios for http requests, and several react components.

**Installing dependencies**

run `npm install` in the client application root directory.

**Scripts**

`npm start` : Runs the app in development mode.

`npm run build` : Builds the app for production to the build folder.

**App URL:** http://localhost:3000


