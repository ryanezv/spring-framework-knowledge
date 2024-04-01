Spring Boot Webclient and OAuth2
========================

## Description

Oauth2.0 integration using Spring Boot and Webclient implementation.

## What you need

* Okta account or any provider OAuth2.0

* Spring Boot 3.1.1

* Spring modules: Oauth2-client, web and webflux

* Tomcat Server (Embebed)

## Quickstart

#### Step 01: Create a Spring Boot application with Spring Initializer <https://start.spring.io>

curl https://start.spring.io/starter.tgz \
-d bootVersion=3.1.1 \
-d artifactId=client \
-d dependencies=oauth2-client, web, webflux \
-d type=maven-project \
-d baseDir=client-webclient \
| tar -xzvf - && cd client-webclient

#### Step 02: Configure de application

- Use the InMemoryReactiveClientRegistrationRepository class, it loads the Okta client registration and packages it in an in-memory client.
- @Scheduled annotation to trigger a request each five seconds

#### Step 03: Run

./mvnw spring-boot:run

#### Additional comments

- CommandLineRunner interface, the method run() is executed once Spring Boot is fully loaded.
- @Scheduled annotation, this annotation allows for a variety of scheduling options, including CRON-style scheduling. It also allows the use of WebClient in all its non-blocking glory.
- Webflux dependency is necessary to add support the Webclient class.