# Employee Management System

## Introduction
An employee management system designed to facilitate the management of employee information within an organization. This system is built using Java, JSP, Servlets, CRUD operations, and SQL.

## Roles and Functions
1. **System manager:**
- Search and update informations about branch managers, branches, groups and employees. 
- Create and delete branch managers, branches, groups and employees.
- Move out employees and search their move out records.
- Search and delete employees' absence records.

2. **Branch manager:**
- Search informations about branch managers, branches, groups and employees. 
- Register and search employees' absence records.

3. **Branch:**
- Each branch has a branch manager.
- There are several branches in this organization.
- At least one group in each branch.

4. **Group:**
- At least one employee in each group.

5. **Employee:**

## Further Effects of Deletions
- **Branch manager:** When a manager is deleted, the branch they originally managed will be automatically assigned to another existing branch manager by the system.
- **Branch:** When a branch is deleted, the group they originally contained will also be deleted. The employee they originally contained will be automatically assigned to another existing group by the system.
- **Group:** When a group is deleted, the employee they originally contained will be automatically assigned to another existing group by the system.

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
- Access the application through a web browser at `localhost:[port]/login.jsp`.

## License
[MIT License](LICENSE) or specify another license if applicable.
