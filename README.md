
API made to [customers register fronten](https://github.com/luisscarlos/customer-register-web) that allows to create customers.


## Tecnologies and tools

 - **[Spring Boot](https://spring.io/projects/spring-boot)**
 - **[Spring Data JPA](https://spring.io/projects/spring-data-jpa#overview)** 
- **[Hibernate](https://hibernate.org/orm/)**
- **[Lombok](https://projectlombok.org/)**
- **[Docker](https://www.docker.com/)**
- **[PostgreSQL](https://www.postgresql.org/)**
- **[Swagger](https://swagger.io/)**


### Features
- Create, edit and delete a customer.
- List all customers.
- Search a customer by name
- Create, edit or delete a comment to a customer.


## Run Locally

- Clone the project

```bash
  git clone https://github.com/luisscarlos/customer-register-api.git
```
- Run docker with terminal in root folder to start database
```bash
  docker-compose up -d
```

- Import cloned project to your preferred IDE
- Run the file CustomerRegisterApplication.java

API documentation can be found at http://localhost:8080 after application starts, and below.

-Postman collection file can be found in root folder with the name Customers Register.postman_collection.json.
## License

[MIT](https://choosealicense.com/licenses/mit/)

