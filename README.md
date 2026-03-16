# Sistema de Gestión de Inventario

Sistema backend para la gestión de inventario, proveedores, órdenes de compra y ventas.

Este proyecto fue desarrollado como práctica de desarrollo backend utilizando **Java y Spring Boot**. El sistema permite administrar operaciones comunes de inventario dentro de una empresa, incluyendo el registro de productos, proveedores, órdenes de compra y ventas.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- API REST

---

## Descripción del sistema

El sistema expone una **API REST** que permite gestionar distintas operaciones relacionadas con el control de inventario.

Entre sus funcionalidades principales se encuentran:

- Gestión de productos
- Gestión de proveedores
- Registro de órdenes de compra
- Registro de ventas
- Control del movimiento de inventario

La aplicación sigue una **arquitectura en capas**, separando las responsabilidades entre controladores, servicios, repositorios y modelos de dominio.

---

## Entidades principales

El sistema se estructura a partir de las siguientes entidades:

- **Producto**
- **Proveedor**
- **Orden de Compra**
- **Venta**

Estas entidades interactúan para mantener un registro del movimiento de stock dentro del sistema.

---

## Estructura del proyecto
src
├── controller
├── service
├── repository
├── model
└── config


Capas de la aplicación:

- **Controller** → Manejo de las peticiones HTTP de la API
- **Service** → Lógica de negocio
- **Repository** → Acceso a la base de datos
- **Model** → Entidades del dominio

---

## Ejemplos de endpoints

| Método | Endpoint | Descripción |
|------|------|------|
| GET | /productos | Obtener todos los productos |
| POST | /productos | Crear un nuevo producto |
| GET | /proveedores | Obtener proveedores |
| POST | /ordenes-compra | Registrar una orden de compra |
| POST | /ventas | Registrar una venta |

---

## Ejecución del proyecto

Clonar el repositorio:
git clone https://github.com/GonzaloMoyano/Sistema_Inventario.git

Ingresar al directorio del proyecto:
cd Sistema_Inventario

Ejecutar la aplicación:
./mvnw spring-boot:run

La API se iniciará en:
http://localhost:8080

---

## Mejoras futuras

Algunas posibles mejoras para el sistema incluyen:

- Implementar autenticación y autorización con JWT
- Contenerización utilizando Docker
- Documentación de la API con Swagger / OpenAPI
- Alertas automáticas de stock bajo
- Migración a arquitectura de microservicios

---

## Autor

Gonzalo Moyano  

Estudiante de Ingeniería en Sistemas enfocado en desarrollo Backend con Java y Spring 


