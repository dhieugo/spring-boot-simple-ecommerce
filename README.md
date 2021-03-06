# ECommerce app

### High-level

![high-level](/docs/topology.png)

### Database 

![database](/docs/db.png)


This database can help to store multiple product attributes easily. It can be improved to the product variation.

### Libraries and Framework

Backend
- Spring Boot
- Spring Data (JPA)
- H2 database

Frontend
- Angular 13 
- Bootstrap

### Folder Structure

`product` - It's the backend API to store the product

`frontend` - Tt's the single page application which is using Angular

### How to run the application

There are two parts

1) Backend - It's maven project. You just need to run the project with port 8080(default)

Navigate to the `product` folder. You run this command to lunch the API

```
mvn spring-boot:run
```

I have added some data so we can review the product on the client facing app.

2) Frontend - There is an README file in the `frontend` folder. 

- Navigate to the `frontend` folder

- Install all node dependecies `yarn install` or `npm install` in the frontend folder

- `npm start` - Then you can access to the web app `localhost:4200`

### API docs

You can access to the swagger to see the API contract

```
http://localhost:8080/swagger-ui.html
```