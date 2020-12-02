# FE-LSD-CASE3

Frontend for Team C

- Andreas Guldborg Heick - cph-ah384@cphbusiness.dk
- Rasmus Jarnborg Friis - cph-rf43@cphbusiness.dk
- Mohammad Hariri - cph-mh682@cphbusiness.dk

Link to deployed solution:
[https://lsd-case-3-fe.herokuapp.com/](https://lsd-case-3-fe.herokuapp.com/)

[![Build Status](https://travis-ci.com/grem848/FE-LSD-CASE3.svg?branch=main)](https://travis-ci.com/grem848/FE-LSD-CASE3)

## Handover Documentation - Frontend

Our three separated projects are listed here:

- Contract: [https://github.com/moh682/LSD-Case3](https://github.com/moh682/LSD-Case3)
- Frontend: [https://github.com/grem848/FE-LSD-CASE3](https://github.com/grem848/FE-LSD-CASE3)
- Backend: [https://github.com/SimonBojesen/BA_LSD_CASE3](https://github.com/SimonBojesen/BA_LSD_CASE3)

The contract is what both teams have been using to follow the same structure of classes and methods. The contract is hosted on [packagecloud](https://packagecloud.io/lsdckmwn/lsdcontract) and is used as a dependency in both projects.

### General & How to use

The frontend project is a REST API, that allows for a client to sent requests to it. It was built using Spring Boot, and takes in JSON requests.

[We have created a Postman Collection, that can be used to send requests and receive responses.](https://github.com/grem848/FE-LSD-CASE3/blob/main/LSD-CASE3-frontend-Client.postman_collection.json)

### CI/CD

For continuous integration and continuous deployment, we have used a combination of Travis CI and Heroku.

For access to the Heroku app pipeline, you will need to be added by us.

We have set it up so Travis builds our project and checks if the build is valid, then if the build is successful Travis will then deploy to our Heroku app. For this purpose we created a Heroku app named lsd-case-3-fe that is our frontend project hosted in the cloud.

Heroku only deploys if Travis is successful.

**[Here is our Travis config:](https://github.com/grem848/FE-LSD-CASE3/blob/main/.travis.yml)**

```yml
language: java

jdk:
  - openjdk15

before_install:
  - chmod +x mvnw

script:
  - ./mvnw clean install

deploy:
  provider: heroku
  api_key: $HEROKU_API_KEY
  app:
    main: lsd-case-3-fe
```

This makes sure that our main branch builds and then deploys, making it so we only have to worry about coding.

### Branching Strategy

Heroku and GitHub provide us with branching.

Heroku has an app deployment pipeline, that allows for development, staging and production deployments.

- Development: When you are developing your app, and you need to see it working.

- Staging: Staging apps can be used to preview code changes and features before being deployed to production.

- Production: Production apps run your customer facing code.

These three steps allow us to branch our app, and deciding when to release, and allows us to test and review our apps before release.

On GitHub, we can use the branches for adding new features, something we mostly used during the setup of our contract.

### Monitoring & Logging

These two features are also provided and done by Heroku.
By selecting our app, we can view logs and monitor the metrics.

For logging we had to tell Spring Boot how, where and which logs to present to us. We did this here in our [application.properties](https://github.com/grem848/FE-LSD-CASE3/blob/main/src/main/resources/application.properties) file:

```properties
logging.file.name=src/main/resources/logs.log
logging.level.org.zalando.logbook = TRACE
logging.level.org.springframework.web=INFO
```

This creates a local log file and logs any responses and requests made, and their content, using the zalando.logbook dependency.

### SLA proposition
We will make sure of availability, and take responsibility for the service.

- Uptime - 99.99%
- Turn Around Time - up to 30 days
- Mean Time to Recovery - up to 30 days
