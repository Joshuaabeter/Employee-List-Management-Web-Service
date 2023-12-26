# Employee-List-Management-Web-Service

This project implements a RESTful web service for managing a list of employees using Java Spring Boot. The service provides CRUD (Create, Read, Update, Delete) functionality

                       DESIGN
To build this service, I first needed to create an Employee class in Java Spring Boot. This included private variables for each field, such as first_name, last_name, employee_id, email, and title. Additionally, it included setter and getter methods for each of these variables. Then, I had to create an EmployeeManager class that managed the full list of employees. Next, we created an EmployeeService class that will hold the business logic. Finally, we created an EmployeeController class, the class responsible for controlling the entries to the database using the GET, POST, DELETE, and PUT commands.

       USING THE RESTful WEB API 
Users could use the GET command to acquire the full list of user data, while the POST command was used to add an individual user. Additionally, the DELETE command could be used to delete an entry, and the PUT command allowed users to update an existing entry. Advanced rest client was used to check all these requests.

For the RESTful WEB API, to get the full list of employees, we could send a GET request to the service and receive a response in the format:
jsonCopy code:
  {
      "employee_id": "string",
      "first_name": "string",
      "last_name": "string",
      "email": "string",
      "title": "string"
    },
For individual employees, we could send the POST command to add a new employee, use the DELETE command to delete an employee, and the PUT command to update an employee using employee ID. These commands were structured as follows:

HTTPs://localhost:8080/employee/employee_id

TEST
 
Finally, I wrote unit tests to see the controller's performance 
