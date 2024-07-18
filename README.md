# Pokémon API SOAP Spring Boot Application

Este proyecto es una aplicación Spring Boot que consume la PokeAPI para obtener información sobre Pokémon y expone un servicio SOAP para acceder a estos datos. Además, almacena las consultas realizadas en una base de datos en memoria H2.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Web
- Spring Web Services (SOAP)
- Spring Cloud OpenFeign
- H2 Database
- JAXB
- Maven

## Requisitos

- JDK 17 o superior
- Maven 3.6 o superior

## Configuración del Proyecto

### 1. Clonar el repositorio

```bash 
git clone <URL_DEL_REPOSITORIO>
cd pokeapi
```

### 2. Compilar y ejecutar la aplicación
```bash
mvn clean spring-boot:run
```
### 3. Acceder al servicio SOAP
El WSDL del servicio SOAP está disponible en la siguiente URL:

```bash
http://localhost:8080/ws/pokemons.wsdl
```
Puedes exportarlo a algún software como soapui para probar los servicios.
### 4. Acceder a la consola H2
La consola H2 está disponible en la siguiente URL:

```bash
http://localhost:8080/h2-console
```
### Utiliza los siguientes detalles de conexión:

- URL JDBC: jdbc:h2:mem:testdb
- Nombre de usuario: sa
- Contraseña: password
### Estructura del Proyecto
 #### El proyecto sigue una arquitectura de tres capas:

- Capa de Presentación: Controladores REST y SOAP
- Capa de Servicio: Lógica de negocio
- Capa de Persistencia: Repositorios JPA
### Estructura de Directorios
```
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── pokemon
│   │               ├── config
│   │               │   └── WebServiceConfig.java
│   │               ├── controller
│   │               │   └── PokemonController.java
│   │               ├── model
│   │               │   └── Pokemon.java
│   │               ├── repository
│   │               │   └── PokemonRepository.java
│   │               ├── service
│   │               │   └── PokemonService.java
│   │               ├── client
│   │               │   ├── PokeApiClient.java
│   │               │   └── PokemonResponse.java
│   │               └── endpoint
│   │                   └── PokemonEndpoint.java
│   ├── resources
│   │   ├── application.properties
│   │   └── pokemon.xsd
└── test
    └── java
        └── com
            └── example
                └── pokemon
                    ├── controller
                    │   └── PokemonControllerTest.java
                    ├── service
                    │   └── PokemonServiceTest.java
                    └── client
                        └── PokeApiClientTest.java