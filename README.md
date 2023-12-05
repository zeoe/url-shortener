# Shorten URL Service

## Requirements
For building and running the application you need:

- Java 20 or higher
- Maven 3 or higher
- Docker

## How to run locally with Docker

Before the app can be started locally, the database must be started using a Docker image. To do this, run the following command in the root directory:
`docker-compose up -d`

To check if the database was started successfully you can use the command: `docker ps -a`

As soon as the database is running the application can start via:
- IDE: execute the `main` method in the `cloud.rio.cartright.Application` with profile local
- Shell: run `mvn spring-boot:run` in the root directory

## Database local
As database locally MongoDB is used. For access use following:
* User: mongodb
* Password: mongodb 

## Technical Information
### Mapstruct
MapStruct is a code generator that greatly simplifies the implementation of mappings between Java Beans like DTOs or entities based on a convention over configuration approach.

More information about Mapstruct and quick guide click [here](https://mapstruct.org/)

For more examples click [here](https://github.com/mapstruct/mapstruct-examples)

### Lombok
With the help of Lombok we can automatically generate java code like getter, setter or equals method and don't have to implement them by ourselves anymore

More information about Lombok click [here](https://projectlombok.org/features//)

### Spotless
Spotless is used as automatic code formatter. This allows us to achieve consistent code formatting across the entire application, since the check is done in the build.
Due to the fact that Spotless is included as a maven plugin, the automatic formatting can be started as follows:
* IDE: open maven plugin overview click on `spotless -> spotless:apply`
* Shell: run `mvn spotless:apply` in the root directory

More information about Spotless click [here](https://github.com/diffplug/spotless/tree/main/plugin-maven)

### Next Steps
* Implement auth with Keycloak
* Add unit and integration tests
* Extend exception handling for unexpected exceptions
* Add Logging
* Add ArchUnit
* Add Swagger