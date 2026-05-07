#  Taxi Service Management System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-007396?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

> A relational database-backed taxi booking system that manages users, taxis, trips, and billing end-to-end.

---

##  Overview

The Taxi Service Management System models a real-world taxi booking platform where users can register, book taxis, take trips, and receive auto-generated bills — all managed through a MySQL relational database connected to a Java application via JDBC.

The system revolves around four core entities: **User**, **Taxi**, **Trip**, and **Bill**.

---

##  System Description

- A **User** registers with their name, contact number, Aadhaar number, age, and gender. Each user gets a unique `User_id`, login ID, and password.
- A **Taxi** has a taxi ID, driver's number, registration number, and a booking status.
- A **Trip** is initiated when a user books a taxi for a pickup and drop location. Start time is recorded at booking; end time is **auto-updated** by the system when the trip completes.
- A **Bill** is auto-generated at the end of each trip with a unique `Bill_no`. Net amount is computed from trip duration, taxi price per hour, and any applicable promotional code.
- Users can save credit/debit card details for future payments. **Partial payment** at booking time is supported, with the balance collected at trip end.

---

##  Tech Stack

| Layer    | Technology                 |
|----------|----------------------------|
| Database | MySQL                      |
| Backend  | Java (JDBC)                |
| Driver   | `com.mysql.cj.jdbc.Driver` |
| Build    | Apache Maven               |

---

##  Database Design

### Entities & Key Attributes

**Users**
- `user_id` (PK), `name`, `age`, `phno`, `adhar_no`, `gender`

**Taxi**
- `taxi_id` (PK), `driver_no`, `reg_no`, `status`

**Trip**
- `trip_id` (PK), `entry` (start time), `b_location` (boarding), `d_location` (drop), `tdate`

**Bill**
- `bill_no` (PK), `user_id` (FK), `driver_id` (FK), `amount`, `net_amount`, `date`, `promo_code`

### Design Artifacts
- ER Diagram
- Relational Schema
- Normalization analysis

---

##  Java Backend — Key Methods (`DataBase.java`)

```java
// Establish JDBC connection
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB50", "root", "");

// Register a new user
Boolean registerUser(String name, String Adhar, String phone, String age, String gender)

// Create a new trip record
void newTrip(String etime, String block, String dlock, String tdate)

// Delete a trip by ID
Boolean deleteTrip(String tid)
```

---

##  Setup & Running

### Prerequisites
- MySQL Server installed and running
- Java JDK 8+
- MySQL Connector/J (JDBC driver)

### Steps

1. **Create the database**
   ```sql
   CREATE DATABASE DB50;
   USE DB50;
   -- Run the table creation scripts
   ```

2. **Configure the connection** in `DataBase.java`:
   ```java
   connection = DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/DB50", "root", "<your_password>");
   ```

3. **Build and run** the Maven project:
   ```bash
   mvn compile
   mvn exec:java
   ```

---

## 📝 Notes

- SQL queries currently use string concatenation — replace with **PreparedStatements** to prevent SQL injection in any real deployment.
- The database name `DB50` and empty root password are local development defaults and should be changed before deploying.

---

*Submitted as part of DBMS Lab coursework — Anagha R S*
