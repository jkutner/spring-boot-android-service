# Spring Boot Android Demo

This is a demo application intended for use with my blog post on [Creating Backend APIs for Android Apps with Heroku and Retrofit](http://jkutner.github.io/2016/08/18/android-backend-api-heroku-retrofit.html).

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

Or follow these steps, after installing the [Heroku Toolbelt](https://toolbelt.heroku.com/), to deploy from the CLI:

```sh-session
$ git clone https://github.com/kissaten/spring-boot-android-service
$ cd spring-boot-android-service
$ git checkout -t origin/db
$ heroku create --addons heroku-postgresql
$ git push heroku master
$ heroku open
```
