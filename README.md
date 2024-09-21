# Crud_api

Crud_api permite manipular las operaciones básicas de agregar, actualizar, consultar y eliminar productos de una base de datos y operando con una tabla en específico.

<h1>Recursos</h1>

1) Instalar Java JDK 23
2) base de datos de Mysql
3) Crear la base de datos y la tabla.

  `create database crud_app;` <br>
  
  `use crud_app;` <br>
  
  `create table producto(
  id int not null auto_increment primary key,
  nombre varchar(100) not null,
  descripcion text,
  precio decimal(10,3) not null,
  cantidad_en_stock int not null
  );` <br>

4) Abrir el proyecto con IntelliJ o NetBeans y ejecutar la clase principal `CrudJdk23Application`
5) Configurar el archivo application.properties ubicando en `src/main/resourcesapplication.properties`. Dentro del archivo se debe configurar la url de la base de datos, usuario y contraseña.

<h1>Puesta en Marcha</h1>

Una vez ejecutado el entorno se podrá acceder mediante la ruta `localhost:8080/api/v1/products`.

Dentro de la ruta se podrán ejecutar los métodos:

## SaveOrUpdate [POST : localhost:8080/api/v1/products]
- Agrega elementos a la tabla enviando un json como por ejemplo:
`{
    "nombre": "Peras",
    "descripcion": "Bolsa de Peras x 6",
    "precio": 1000,
    "cantidad_en_stock": 20
}`   

## Borrar Producto [DELETE : localhost:8080/api/v1/products/{id}]
- Mediante la url reemplazando {id} por el número del id del producto se eliminará el registro de la tabla.

## Productos [GET : http://localhost:8080/api/v1/products ]
- Consulta todos los productos de la tabla.

## Producto [GET : http://localhost:8080/api/v1/products/{id} ]
- Mediante la url reemplazando {id} por el número del id del producto se listará el registro específico.

## Suma Productos [GET : http://localhost:8080/api/v1/products/sumaProductos]
- Calcula el valor en bodega de cada producto (stock * precio unitario) y realiza la suma de todos los totales para obtener el valor general del inventario.
