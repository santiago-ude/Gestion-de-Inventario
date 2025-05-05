# 🗃️ Gestión de Inventario

Este proyecto es una **API REST** desarrollada con Spring Boot que permite realizar la gestión básica de un inventario, incluyendo operaciones CRUD sobre **productos**, **categorías** y **proveedores**. Pensada para facilitar la administración clara y eficiente del stock y el origen de los productos.

## 🛠 Tecnologías utilizadas

- Java 
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger (OpenAPI 3)

## 🚀 Cómo correr el proyecto

1. Asegurarse de tener **MySQL** instalado y corriendo.
2. Crear una base de datos llamada `gestiondeinventario`:

```sql
CREATE DATABASE gestiondeinventario;
```

3. Clonar este repositorio:

```bash
git clone https://github.com/tu-usuario/gestion-inventario.git
```

4. Configurar el archivo `application.properties` con tus credenciales de MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestiondeinventario
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
```

5. Ejecutar la aplicación desde tu IDE o con:

```bash
./mvnw spring-boot:run
```

6. Acceder a la documentación Swagger en:

```
http://localhost:8080/inventoryManagment/api/v1/swagger-ui/index.html
```

(⚠️ Si no carga, revisar posibles conflictos con el GlobalExceptionHandler o errores de configuración.)

## 📦 Endpoints disponibles

### 🗂 Categorías

- `GET /categories`: obtener todas las categorías
- `POST /categories`: crear una nueva categoría
- `PUT /categories/{id}`: actualizar una categoría existente
- `DELETE /categories/{id}`: eliminar una categoría

### 🧾 Productos

- `GET /products`: listar productos
- `POST /products`: crear producto (requiere ID de categoría y proveedor)
- `PUT /products/{id}`: actualizar producto
- `DELETE /products/{id}`: eliminar producto

### 👨‍💼 Proveedores

- `GET /suppliers`: listar proveedores
- `POST /suppliers`: crear proveedor
- `PUT /suppliers/{id}`: actualizar proveedor
- `DELETE /suppliers/{id}`: eliminar proveedor

## 📄 Documentación Swagger

![image](https://github.com/user-attachments/assets/488b57a9-5cb5-4a31-a19f-483a9c016d42)


---

## 📌 Próximamente

- Dockerización del proyecto.
- Interfaz frontend para facilitar el consumo de la API.
- Mejoras en la validación y control de errores.
