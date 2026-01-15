
# 🛒 Ecommerce API – Spring Boot

API RESTful de comercio electrónico desarrollada con **Spring Boot** que permite gestionar usuarios, productos, categorías, carrito de compras y órdenes.

Proyecto backend orientado a arquitectura limpia, seguridad con JWT y persistencia en MySQL.

---

## 🚀 Funcionalidades

- 👤 Registro y login de usuarios (JWT)
- 🛍️ CRUD de productos
- 🗂️ Gestión de categorías
- 🛒 Carrito de compras
- 📦 Órdenes de compra
- 🔐 Autenticación y autorización por roles
- 🗄️ Persistencia con MySQL

---

## 🛠️ Tecnologías

- Java 21  
- Spring Boot  
- Spring Data JPA  
- Spring Security  
- JWT  
- MySQL  
- Maven  

---

## 🧭 Arquitectura

Controller → Service → Repository → Database


API RESTful siguiendo buenas prácticas y separación de responsabilidades.

---

## 📌 Endpoints principales

| Recurso | Endpoint |
|-------|---------|
| Auth | POST `/api/auth/register` |
| Auth | POST `/api/auth/login` |
| Categorías | GET `/api/categories` |
| Productos | GET `/api/products` |
| Carrito | POST `/api/cart/add` |
| Ordenes | POST `/api/orders` |

---

## ▶️ Cómo ejecutar

1️⃣ Clonar:
```bash
git clone https://github.com/CeleCH/ecommerce-api.git

2️⃣ Crear base de datos:
CREATE DATABASE ecommerce_db;

3️⃣ Configurar application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
server.port=8081

4️⃣ Ejecutar:
mvn spring-boot:run

🧪 Pruebas

Puedes probar los endpoints con:

Postman

Insomnia

Thunder Client (VS Code)

Ejemplo:
GET http://localhost:8081/api/products

🏆 Estado

✔ Funcional
✔ Persistente
✔ Seguridad JWT
✔ Listo para producción académica

Desarrollado por Celeste Cuba 💙
Backend Developer – Spring Boot