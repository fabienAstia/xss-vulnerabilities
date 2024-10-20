# Welcome to the _xss-vulnerabilities_ workshop 

Install the project, try some xss vulnerabilities and fix them !

This project uses : Java Spring Boot, Maven, PostgreSql and Vue.js.

## Installation
### DataBase
Create your DB and and connect it to a new project `xss-vulnerabilities-database`.
```sql
CREATE DATABASE xss_database;
```
When your project and your database are connected, run these scripts :

1 - `Shema.ddl.sql`

2 - `Script.dml.sql`

### Backend
1 - With Eclipse (or your favorite IDE) open the project in directory `xss-vulnerabilities-business`.
> Note: import and choose `Existing Maven Project`

 2- Create a directory `resources` in `src/main` and create a file `application.properties`.
 
 Structure : 
 
 ![image](https://github.com/user-attachments/assets/970c39f8-0dcd-419e-b42e-9b254fb0e2f4)

 
 3- In `application.properties`, fill :
 ```
spring.application.name=xss-vulnerabilities-business
spring.datasource.url=jdbc:postgresql://localhost:<port>/<name-database>
spring.datasource.username=<your-user-name>
spring.datasource.password=<your-password>

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
 ```
 
 4- Run as `Spring Boot App`

### Front-end
Open `xss-vulnerabilities-view` with Visual Studio Code (or other).

Run 
```bash
npm install
```
And launch the server :
```bash
npm run dev
```

The project is installed. :tada:
