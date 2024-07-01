# Proyecto de Ejemplo con Patrón Arquitectónico MVC y DAO

Este proyecto demuestra la implementación de un CRUD para las entidades `Usuario`, `Cliente`, `Venta`, `Factura`, `Inventario`, `Producto` y `Pedido` utilizando el patrón arquitectónico MVC y DAO.

## Requisitos del Sistema

- Java 11 o superior
- MySQL Server
- IDE como IntelliJ IDEA o Eclipse

## Configuración de la Base de Datos

1. Crear la base de datos y las tablas:
   - Ejecutar el script `database.sql` en tu servidor MySQL para crear la base de datos y las tablas necesarias.

2. Configurar la conexión a la base de datos:
   - Asegúrate de que las credenciales de la base de datos en `DBConnection.java` sean correctas.

## Ejecución del Proyecto

1. Importar el proyecto en tu IDE preferido (IntelliJ IDEA o Eclipse).
2. Compilar y ejecutar la clase `Main.java`.

## Contenido del Proyecto

### Modelo (package: model)

- `Usuario.java`
- `Cliente.java`
- `Venta.java`
- `Factura.java`
- `Inventario.java`
- `Producto.java`
- `Pedido.java`

### DAO (package: dao)

- `GenericDAO.java`
- `GenericDAOImpl.java`
- DAO específico para cada entidad (e.g., `UsuarioDAO.java`, `UsuarioDAOImpl.java`)

### Controladores (package: controller)

- Controlador específico para cada entidad (e.g., `UsuarioController.java`, `ClienteController.java`)

### Utilidades (package: util)

- `DBConnection.java` - Clase para manejar la conexión a la base de datos

### Principal (package: main)

- `Main.java` - Clase principal para probar las operaciones CRUD

## Ejemplo de Uso

El siguiente es un ejemplo de cómo ejecutar operaciones CRUD para las entidades. 

- Crear un nuevo usuario
- Leer un usuario
- Actualizar un usuario
- Eliminar un usuario
- Obtener todos los usuarios

## Capturas de Pantalla

![Captura de Pantalla 1](screenshots/captura1.png)
![Captura de Pantalla 2](screenshots/captura2.png)

## Script SQL

```sql
CREATE DATABASE tienda;

USE tienda;

CREATE TABLE Usuario (
    IDUsuario INT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Correo VARCHAR(100) NOT NULL,
    Contrasena VARCHAR(100) NOT NULL,
    Rol VARCHAR(50) NOT NULL
);

CREATE TABLE Cliente (
    IDCliente INT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Correo VARCHAR(100) NOT NULL,
    Direccion VARCHAR(200),
    Telefono VARCHAR(15)
);

CREATE TABLE Producto (
    IDProducto INT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Descripcion TEXT,
    Precio FLOAT NOT NULL,
    Stock INT NOT NULL
);

CREATE TABLE Pedido (
    IDPedido INT PRIMARY KEY,
    IDCliente INT,
    IDProducto INT,
    Cantidad INT NOT NULL,
    Fecha DATE NOT NULL,
    FOREIGN KEY (IDCliente) REFERENCES Cliente(IDCliente),
    FOREIGN KEY (IDProducto) REFERENCES Producto(IDProducto)
);

CREATE TABLE Venta (
    IDVenta INT PRIMARY KEY,
    Fecha DATE NOT NULL,
    Total FLOAT NOT NULL,
    IDUsuario INT,
    IDCliente INT,
    FOREIGN KEY (IDUsuario) REFERENCES Usuario(IDUsuario),
    FOREIGN KEY (IDCliente) REFERENCES Cliente(IDCliente)
);

CREATE TABLE Factura (
    IDFactura INT PRIMARY KEY,
    FechaEmision DATE NOT NULL,
    IDVenta INT,
    FOREIGN KEY (IDVenta) REFERENCES Venta(IDVenta)
);

CREATE TABLE Inventario (
    IDInventario INT PRIMARY KEY,
    FechaActualizacion DATE NOT NULL,
    IDProducto INT,
    Cantidad INT NOT NULL,
    FOREIGN KEY (IDProducto) REFERENCES Producto(IDProducto)
);
