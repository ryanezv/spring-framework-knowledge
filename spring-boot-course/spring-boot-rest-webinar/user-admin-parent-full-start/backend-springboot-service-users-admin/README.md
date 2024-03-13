# User Admin Service

## Pasos para ejecutar el proyecto:
Ubicarte en la raiz del folder 'backend-springboot-service-users-admin' y ejecutar los siguientes comandos:
mvn clean install
mvn spring-boot:run

## Stack tech

- Editor: Visual Studio Code with Spring Boot Extension Pack
- Programming language : Java 17 LTS
- Framework: Spring Boot 3.1 (using Spring Initializer)
- Dependency manager: Maven 3+
- Logs manager: SLF4J (using Logback)
- Calls to web services: Spring WebFlux using Webclient API
- Architecture pattern: RestFull
- Especification to exchange JSON structures: Jackson library
- Security: OAuth2, JWT
- Repository: CodeCommit in AWS (Git)
- Application deployment: Docker, Spring Tomcat
- AWS Stack: ECS, Parameters Store, Cloud Watch and CodeCommit.
- Base de datos: H2, MySQL
- Serialization and Deserialization: Gson 2+ (of Google)
- Resilience to service invocation: Webclient API
- Database connection: Spring JDBC
- API Documentation: Open API 3.0
- Service Availability: Spring Actuator and Health Checks custom
- Pattern design: Controller-Service-Repository, TO, Factory, Builder.