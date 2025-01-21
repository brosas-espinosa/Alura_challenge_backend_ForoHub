# **ForoHub API REST**

## Índice

1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Estado del Proyecto](#estado-del-proyecto)
3. [Demostración de Funciones y Aplicaciones](#demostración-de-funciones-y-aplicaciones)
4. [Acceso al Proyecto](#acceso-al-proyecto)
5. [Tecnologías Utilizadas](#tecnologías-utilizadas)

---

## Descripción del Proyecto

El proyecto **ForoHub** tiene como objetivo crear una API REST para gestionar un foro donde los usuarios puedan interactuar, crear, modificar y eliminar tópicos (temas) de discusión. La API está desarrollada utilizando **Spring Boot** y se conecta a una base de datos MySQL para almacenar los tópicos. Además, la API incluye una funcionalidad de autenticación con **JWT (JSON Web Tokens)** para asegurar que solo los usuarios autenticados puedan realizar operaciones sobre los tópicos.

### Funcionalidades Principales:
- **Crear un nuevo tópico**
- **Mostrar todos los tópicos**
- **Mostrar un tópico específico**
- **Actualizar un tópico existente**
- **Eliminar un tópico**
- **Autenticación de usuarios mediante JWT**

## Estado del Proyecto

Este proyecto está en su fase funcional completa y proporciona una API REST operativa con autenticación y la capacidad de gestionar tópicos en un foro.

- **Autenticación**: Implementada mediante JWT.
- **Operaciones CRUD**: Completo para tópicos.
- **Base de Datos**: MySQL, con migraciones gestionadas por Flyway.

## Demostración de Funciones y Aplicaciones

La API permite realizar las siguientes operaciones con endpoints REST:

- **Crear un Tópico** (POST `/tópicos`):
  ```json
  {
    "titulo": "Problema con el curso de Java",
    "mensaje": "No puedo entender el concepto de clases.",
    "autor": "Juan Perez",
    "curso": "Java para Principiantes"
  }


## Tecnologías Utilizadas
- Java 17: Lenguaje de programación principal.
- Spring Boot 3: Framework para desarrollo de aplicaciones Java.
- Spring Security: Para la autenticación y autorización de usuarios.
- JWT (JSON Web Tokens): Para la autenticación segura.
- Spring Data JPA: Para la interacción con la base de datos.
- Flyway: Para la gestión de migraciones de base de datos.
- MySQL: Sistema de gestión de bases de datos.
- Maven: Para la gestión de dependencias.