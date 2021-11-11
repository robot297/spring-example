# Sample Spring Boot API

## About the app

This is a simple Spring Boot app that showcases a basic pattern to build an API.

You can find the endpoint deployed on [Heroku](http://heroku.com/) and the url for the
endpoint is https://obot-api.herokuapp.com/.

To access the swagger documentation you can go to this url: https://obot-api.herokuapp.com/swagger-ui/index.html

To see how this app evolved over time, you can look at the pull requests here:
[https://github.com/robot297/spring-example/pulls](https://github.com/robot297/spring-example/pulls?q=is%3Apr+is%3Aclosed)

To get started, you can use the [Spring Initializer](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.6&packaging=jar&jvmVersion=1.8&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=web,mysql,h2,validation)
to generate the scaffolding for your new Spring project.

I've also included the use of [Docker](https://docs.docker.com/get-started/) to in case you wanted to see how your app
can be cloud ready (though this does not deploy to the cloud).

## Endpoints

To test the endpoints, it is recommended that you use [Postman](https://www.postman.com/).

| Endpoint | Web method | What to send | Expected Result |
| -------- | -------- | -------- | ------- |
| /health  | GET      | N/A | `App is OK` |
| /movie   | POST     | `{"movieName" : "Movie","rating" : 4}` | `{ "id": 1,"movieName": "Movie","rating": 4}` |
| /movie   | GET      | N/A |  `[{"id":1,"movieName":"null","rating":4}]`
