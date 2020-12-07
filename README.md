# FE-LSD-CASE3

Frontend for Team C

- Andreas Guldborg Heick - cph-ah384@cphbusiness.dk
- Rasmus Jarnborg Friis - cph-rf43@cphbusiness.dk
- Mohammad Hariri - cph-mh682@cphbusiness.dk

Link to deployed solution:
[https://lsd-case-3-fe.herokuapp.com/](https://lsd-case-3-fe.herokuapp.com/)

[![Build Status](https://travis-ci.com/grem848/FE-LSD-CASE3.svg?branch=main)](https://travis-ci.com/grem848/FE-LSD-CASE3)

## Handover Documentation

Our three separated projects are listed here:

- Contract: [https://github.com/moh682/LSD-Case3](https://github.com/moh682/LSD-Case3)
- Frontend: [https://github.com/grem848/FE-LSD-CASE3](https://github.com/grem848/FE-LSD-CASE3)
- Backend: [https://github.com/SimonBojesen/BA_LSD_CASE3](https://github.com/SimonBojesen/BA_LSD_CASE3/tree/main)

The contract is what both teams have been using to follow the same structure of classes and methods. The contract is hosted on [packagecloud](https://packagecloud.io/lsdckmwn/lsdcontract) and is used as a dependency in both projects.

### General & How to use

We recommend using the hosted solution, which is has a link above.

#### To request access to the Heroku app and view our deployed Heroku setup please contact us, remember you are required to have a Heroku account

If you want to look at the project locally, follow these simple steps:

- Clone the project
- Open your preferred IDE and the project
- Build
- Run
- API is now hosted on localhost:8080

The frontend project is a REST API, that allows for a client to sent requests to it. It was built using Spring Boot, and takes in JSON requests. The backend project takes care of database and business logic, and has setup a RMI service that the frontend can communicate with.

[We have created a Postman Collection, that can be used to send requests and receive responses, join it by clicking here.](https://app.getpostman.com/join-team?invite_code=8d814a09b48d50ff68a6c40616dc665c)

### CI/CD

For continuous integration and continuous deployment, we have used a combination of Travis CI and Heroku.

For access to the Heroku app pipeline, you will need to be added by us.

We have set it up so Travis builds our project and checks if the build is valid, then if the build is successful Travis will then deploy to our Heroku app. For this purpose we created a Heroku app named lsd-case-3-fe that is our frontend project hosted in the cloud.

Heroku only deploys if Travis builds the project successfully.

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

[View Heroku's Subscription Agreement here](https://www.heroku.com/policy/salesforce-heroku-msa)

#### Service Description

The service must provide the functionality to see and book cars and manage bookings.
We will make sure of availability, and take responsibility for the service functionality.

#### Uptime/availability (percentage of all time) - 90%

Heroku takes care of the deployment of our application, so any issues with their services is not our responsibility, and will require you to contact Heroku. The Heroku dyno container keeps our application alive, and takes care of all monitoring and logging. To monitor the application, contact us for access.

#### Mean response time (average time to serve answer) - up to 7 business days

If you have questions or need answers on anything concerning the application, contact us and we will return to you within a 7 business days.

#### Mean time to recover ( time to recover after outage) - up to 7 business days

During an outage or an error with the application, you are welcome to contact us, we will respond within 7 business days. For Heroku issues contact them.

#### Failure frequency (number of failures/ timeouts over time) - 1-5 failures/week

If you experience a higher failure frequency, please contact us and we will return to you within 7 business days. For Heroku issues contact them.

<br>

### Contact us

If you have any questions feel free to contact us at cph-rf43@cphbusiness.dk, and we will return to you within 7 business days.

###### Fixes, changes and any reports or documentation will ONLY be provided upon contact with our support center.
