# Employee Management System

## Introduction
An employee management system designed to facilitate the management of employee information within an organization. This system is built using Java, JSP, Servlets, CRUD operations, and SQL.

## Roles
1. **System manager:**
- Search and update informations about branch manger, branch, group and employees. 
- Create and delete branch manger, branch, group and employees.
- Move out employees and search their move out records.
- Search and delete employee absence records.

2. **Branch manager:**
- Search informations about branch manger, branch, group and employees. 
- Register and search employee absence records.

3. **Branch:**
- Each branch has a branch manager.
- At least one group in each branch.

4. **Group:**
- At least one employee in each group.

5. **Employee:**

## Features
- **Create:** Add new employee records.
- **Read:** View existing employee details.
- **Update:** Modify the details of existing employees.
- **Delete:** Remove employee records from the system.

## Technologies
- Java
- JSP (JavaServer Pages)
- Servlets
- CRUD Operations
- SQL

## Installation
To set up this project on your local machine, follow these steps:

1. **Clone the Repository:**

2. **Install Required Libraries:**
- Make sure you have Java and an appropriate Java server (like Apache Tomcat) installed.
- Install any other dependencies that are listed in the project.

3. **Database Setup:**
- Set up a SQL database according to the schema provided in the project.
- Configure the database connection settings in the project files.

4. **Build and Run:**
- Compile the Java code.
- Deploy the application on the server.
- Access the application through a web browser at `localhost:[port]/EmployeeManagementSystem`.

## Usage
After installing the system, you can perform the following operations:

1. **Add Employee:**
- Navigate to the 'Add Employee' section.
- Fill in the employee details and submit.

2. **View Employees:**
- Go to the 'View Employees' section to see a list of all employees.

3. **Edit/Delete Employee:**
- Use the 'Edit' option next to each employee to update their details.
- Use the 'Delete' option to remove an employee from the system.

## Contribution
Contributions to this project are welcome. To contribute:
1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Create a new Pull Request.

## License
[MIT License](LICENSE) or specify another license if applicable.
