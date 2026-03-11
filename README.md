# LiterAlura

Proyecto de consola en **Java + Spring Boot** para administrar libros y autores.

## Funcionalidades

- Agregar libros con su autor.
- Buscar libros por título.
- Evita duplicar autores y mantiene la cantidad de descargas (inicializada en 0).

## Tecnologías usadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Hibernate

## Cómo ejecutar

1. Configura tu base de datos PostgreSQL en `application.properties`.
2. Ejecuta la app desde IntelliJ o por consola:

```bash
mvn spring-boot:run
