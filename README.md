# Employee Management System

## Introduction
This Employee Management System supports functions like employee, branch, and group management, as well as tracking employee absences. Managers can utilize it to handle various HR tasks within the company.

The system's front end is built using HTML, CSS, and JavaScript technologies, integrating the Bootstrap framework and JQuery library to ensure a modern and responsive user interface. On the backend, the system uses Java as the primary programming language, coupled with Servlet technology to handle HTTP requests. Data storage and management are supported by a MySQL database, with JDBC technology applied for database operations.

Furthermore, the system adopts the DAO pattern and service layer architecture to separate business logic from data access code, enhancing the system's maintainability and scalability.

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

5. **Employee**

## Further Effects of Deletions
- **Branch manager:** When a manager is deleted, the branch they originally managed will be automatically assigned to another existing branch manager by the system.
- **Branch:** When a branch is deleted, the group they originally contained will also be deleted. The employee they originally contained will be automatically assigned to another existing group by the system.
- **Group:** When a group is deleted, the employee they originally contained will be automatically assigned to another existing group by the system.

## Technologies

### Front End
- **HTML/CSS**
- **JavaScript**
- **Bootstrap**
- **JQuery**
- **AJAX**

### Back End
- **Java**
- **JDBC**

### Database
- **MySQL**

### Others
- **Tomcat**
- **Maven**

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

## 簡介
這個人事管理系統支持員工、分公司、小组管理以及員工缺勤紀錄等功能，管理員可以透過他處理公司內各種人事業務。

系統的前端採用 HTML、CSS 和 JavaScript 技術構建，集成了 Bootstrap 框架和 JQuery 庫，確保用戶界面的現代性和響應式設計。在後端，系統使用 Java 作為主要編程語言，結合 Servlet 技術處理 HTTP 請求。數據存儲和管理由 MySQL 數據庫支持，同时應用了 JDBC 連接技術進行數據庫操作。

此外，系統採用了 DAO 模式和服務層架構來分離業務邏輯和資料存取程式碼，提高了系統的可維護性和擴展性。
## 角色與功能
1. **系統管理員:**
- 搜尋和更新分公司管理員、分公司、小組和員工的資訊 
- 添加和刪除分公司管理員、分公司、小組和員工
- 登記及查詢員工離退紀錄
- 搜尋和刪除員工缺勤紀錄Search and delete employees' absence records.

2. **分公司管理員:**
- 搜尋分公司管理員、分公司、小組和員工的資訊 
- 登記及查詢員工缺勤紀錄

3. **分公司:**
- 每間分公司都有一個分公司管理員
- 整間公司有若干個分公司
- 每間分公司有若干個小組

4. **小組:**
- 每個小組內有若干名員工

5. **員工**

## 刪除後進一步的影響
- **分公司管理員:** 在刪除一個分公司管理員之後，其原本管理的分公司將被系統自動分配給其他現有的管理員
- **分公司:** 在刪除一個分公司之後，其原本管理的小組將被系統自動刪除，而其原本管理的員工將被系統自動分配給其他現有的小組
- **小組:** 在刪除一個小組之後，其原本管理的員工將被系統自動分配給其他現有的小組

## 技術

### 前端
- **HTML/CSS**
- **JavaScript**
- **Bootstrap**
- **JQuery**
- **AJAX**

### 後端
- **Java**
- **JDBC**

### 資料庫
- **MySQL**

### 其他
- **Tomcat**
- **Maven**

## 安裝
要在您的本地機器上設置此項目，請按照以下步驟操作：

1. **克隆倉庫：**

2. **安裝所需庫：**
- 確保您已安裝 Java 及適當的 Java 服務器（如 Apache Tomcat）。
- 安裝項目中列出的任何其他依賴項。

3. **數據庫設置：**
- 根據項目中提供的模式設置 SQL 數據庫。
- 在項目文件中配置數據庫連接設置。

4. **構建並運行：**
- 編譯 Java 代碼。
- 在服務器上部署應用程序。
- 通過網絡瀏覽器在 `localhost:[port]/login.jsp` 訪問應用程序。

## 授權
[MIT 授權](LICENSE) 或如果適用，指定其他授權。
