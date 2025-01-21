# :coffee: challenge-foro-hub 🍪:

## Funcionamiento

Esta API se centra principalmente en los tópicos, y debe permitir a los usuarios:

```
✓ Crear un nuevo tópico
✓ Mostrar todos los tópicos creados
✓ Mostrar un tópico específico
✓ Actualizar un tópico
✓ Eliminar un tópico
```

Es lo que normalmente conocemos como **CRUD:** `Crear, Consultar, Actualizar y Eliminar` `(CREATE, READ, UPDATE, DELETE)` usando un framework que facilitará mucho nuestro trabajo.

## Objetivo

El objetivo es implementar una API REST con las siguientes funcionalidades:

```
✓ API con rutas implementadas siguiendo las mejores prácticas del modelo REST.
✓ Validaciones realizadas según las reglas de negocio
✓ Implementación de una base de datos relacional para la persistencia de la información
✓ Servicio de autenticación/autorización para restringir el acceso a la información.
```

## Especificaciones del proyecto

Java JDK: versión 17 en adelante
Maven: versión 4
Spring Boot: versión 3
MySQL: versión 8

### Dependencias

```
✓ Lombok
✓ Spring Web
✓ Spring Boot DevTools
✓ Spring Data JPA
✓ Flyway Migration
✓ MySQL Driver
✓ Validation
✓ Spring Security
```

## Diagrama de Base de Datos

Para crear un tópico necesitan la siguiente información:
```
✓ id
✓ título
✓ mensaje
✓ fecha de creación
✓ status (estado del tópico)
✓ autor
✓ curso
```

## Conocimientos necesarios

```
1. Manejo Spring Boot y IDE IntelliJ.
2. Manejo Spring Data JPA.
3. Mapeo y modelado de entidades.
4. Validación de datos de las peticiones de clientes HTTP.
5. Consumo endpoints mediante Insomnia.
6. Construcción y consumo de querries personalizadas JPQL.
7. Uso de Spring security.
8. Generación y validacion de JWT (Json Web Tokens).
```
