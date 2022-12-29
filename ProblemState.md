# Employee Management

## Problem Statement

The console version of employee management, which provides the CRUD (create, read, update and delete) operations for employees.

We need to implement the management system as follows:

- Display a greeting screen and list available operations.
- Select corresponding operation according to the prompts, and insert all necessary information to complete operation.
- When the operation is complete, you can continue other operations or exit the system.

Below is the greeting screen. Select corresponding number (1-5) to complete one operation. You can exit the system by selecting 6.

```shell
Employee Manager

1. List Employees   
2. Add Employee     
3. Retrieve Employee
4. Update Employee  
5. Delete Employee  
6. Exit

Enter menu selection
```

## Solution

The employee management should structure as follows. We use MVC and tiered design pattern to structure the system.

controller/EmployeeController provides functions as follows:

- Provide operations for employees.
- Delegate to EmployeeVew to display instructions.
- Delegate to EmployeeDao to operate on data-related tasks.

view/EmployeeView provides functions as follows:

- Prompt user to input information
- Display Instructions.

dao/EmployeeDao provides the actual operations on data-related tasks.

- Load from and write to employees to a file named employees.txt
- Use Map object to operate on employees in memory.

```shell
├───src
│   ├───main
│   │   └───java
│   │       └───com
│   │           └───example
│   │               │   Main.java
│   │               │
│   │               ├───controller
│   │               │       EmployeeController.java
│   │               │
│   │               ├───dao
│   │               │       EmployeeDao.java
│   │               │       EmployeeDaoImpl.java
│   │               │
│   │               ├───exception
│   │               │       EmployeeDaoException.java
│   │               │
│   │               ├───model
│   │               │       Employee.java
│   │               │
│   │               └───view
│   │                       EmployeeView.java
│   │                       UserIO.java
│   │                       UserIOConsoleImpl.java
```
