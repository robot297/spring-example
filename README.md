# Sample Spring Boot API

## About the app

This is a simple Spring Boot app that showcases a basic pattern to build an API.

You can find the endpoint deployed on [Heroku](http://heroku.com/) and the url for the
endpoint is https://obot-api.herokuapp.com/.

To see how this app evolved over time, you can look at the pull requests here:
https://github.com/robot297/spring-example/pulls

To get started, you can use the [Spring Initializer](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.6&packaging=jar&jvmVersion=1.8&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=web,mysql,h2,validation)
to generate the scaffolding for your new Spring project.

## Endpoints

To test the endpoints, it is recommended that you use [Postman](https://www.postman.com/).

| Endpoint | Web method | What to send | Expected Result |
| -------- | -------- | -------- | ------- |
| /health  | GET      | N/A | `App is OK` |
| /movie   | POST     | `{"movieName" : "Movie","rating" : 4}` | `{ "id": 1,"movieName": "Movie","rating": 4}` |
