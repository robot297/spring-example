# Sample Spring Boot API

## About the app

This is a simple Spring Boot app that showcases a basic pattern to build an API.

You can find the endpoint deployed on [Heroku](http://heroku.com/) and the url for the
endpoint is https://obot-api.herokuapp.com/.

To see how this app evolved over time, you can look at the pull requests here:
https://github.com/robot297/spring-example/pulls

## Endpoints

To test the endpoints, it is recommended that you use [Postman](https://www.postman.com/).

| Endpoint | Web method | What to send | Expected Result |
| -------- | -------- | -------- | ------- |
| /health  | GET      | N/A | `App is OK` |
| /movie   | POST     | `{"movieName" : "Movie","rating" : 4}` | `{ "id": 1,"movieName": "Movie","rating": 4}` |
