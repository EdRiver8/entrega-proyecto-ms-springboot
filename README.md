
# 💇‍♀️ Sistema de Gestión de Ventas - Peluquería

## 📝 Descripción del Proyecto

Este proyecto consiste en el desarrollo de un sistema de gestión de ventas para una tienda de productos de peluquería. Está diseñado para facilitar:

- El registro de ventas  
- Administración del inventario  
- Gestión del personal  
- Obtención de reportes clave para la toma de decisiones

Tecnologías usadas:

- **Spring Boot** como framework principal  
- **JPA** para persistencia  
- **H2** como base de datos en memoria para un entorno de prueba ágil y simple

---

## 📋 Reglas de Negocio

### Empleados
- **RN1**: Cada venta debe estar asociada a un empleado que la haya realizado.  
- **RN2**: No se puede registrar un empleado sin su nombre y al menos un apellido.

### Productos
- **RN3**: Todo producto debe tener un nombre, precio, cantidad en stock y fecha de vencimiento si aplica.  
- **RN4**: No se puede vender un producto con stock igual a cero.  
- **RN5**: Un producto puede pertenecer a una o más categorías.  
- **RN6**: No se pueden registrar productos con precio o stock negativo.

### Categorías
- **RN7**: Cada categoría debe tener un nombre único.  
- **RN8**: No se deben borrar categorías si tienen productos asignados.

### Ventas
- **RN9**: Una venta debe tener una fecha, un total y estar asociada a un empleado.  
- **RN10**: El total de la venta debe ser igual a la suma de (cantidad × precio unitario) de los productos vendidos.

### Detalle de Ventas
- **RN11**: Cada línea debe estar asociada a una venta y a un producto.  
- **RN12**: No se puede registrar un detalle con cantidad cero o negativa.  
- **RN13**: El precio unitario debe reflejar el precio del producto en ese momento.

### Stock y Vencimiento
- **RN14**: Al vender, se debe disminuir el stock.  
- **RN15**: No se deben vender productos vencidos.

---

## 📊 Reportes Disponibles

✅ Top 5 productos más vendidos  
✅ Empleados que han realizado ventas  
✅ Total de ventas por día  
✅ Productos con stock por debajo de 10 unidades  
✅ Stock disponible por categoría de producto  

---

## 📂 Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/dom/pelu/
│   │       ├── controller/       # Controladores REST
│   │       ├── model/            # Entidades JPA
│   │       ├── repository/       # Repositorios Spring Data
│   │       ├── service/          # Lógica de negocio
│   │       │   └── serviceIMP/   # Implementaciones de servicios
│   │       └── dto/              # Data Transfer Objects
│   │           └── reporteDTO/   # DTOs específicos para reportes
│   └── resources/
│       ├── application.properties
│       ├── data.sql              # Datos iniciales
│       └── schema.sql            # Script de esquema base de datos
```

---

## ⚙️ Instrucciones de Instalación

### 📦 Prerrequisitos

* Java 21
* Maven
* IDE (IntelliJ o VSCode)

### ▶️ Pasos para ejecutar

1. Clonar el repositorio:

bash
git clone https://github.com/santiago23212/entrega-proyecto-ms-springboot.git



3. Ejecutar con JetBrains 



4. Acceder a la consola H2 en el navegador:


http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:pelu_db
Usuario: sa
Contraseña: (vacía)

## 📮 Colección de APIs (Postman)

Puedes importar la colección de pruebas desde el archivo `Pelu.postman_collection.json`.  
Incluye endpoints para registrar empleados, ventas, productos, detalles de venta, y generar reportes estratégicos.

| Funcionalidad                  | Método | Endpoint                            | Descripción                                           |
|-------------------------------|--------|-------------------------------------|-------------------------------------------------------|
| Ventas por día                | GET    | `/api/reportes/ventas-por-dia`     | Reporte del total de ventas agrupadas por día        |
| Stock por categoría           | GET    | `/api/reportes/stock-por-categoria`| Muestra el stock total disponible por categoría       |
| Top 5 productos vendidos      | GET    | `/api/reportes/top5-productos`     | Lista los 5 productos más vendidos                    |
| Productos con bajo stock      | GET    | `/api/reportes/productos-bajo-stock`| Muestra productos con stock menor a 10               |
| Empleados con ventas          | GET    | `/api/reportes/empleados-con-ventas`| Muestra empleados que han realizado ventas           |
| Crear venta                   | POST   | `/api/ventas`                       | Registra una nueva venta                              |
| Crear producto                | POST   | `/api/productos`                    | Agrega un nuevo producto al inventario                |
| Crear empleado                | POST   | `/api/empleados`                    | Registra un nuevo empleado                            |
| Crear detalle de venta        | POST   | `/api/detalles`                     | Agrega detalles (productos) a una venta               |

---

## 📊 Diagrama de Entidades

```text
[Empleado] 1---N [Venta] 1---N [DetalleVenta] N---1 [Producto] N---N [Categoría]

[Producto] N---N [ProductoCategoría] N---N [Categoría]
```

### Campos de las entidades:

- **Empleado**(documento_empleado, nombre_empleado, apellido1_empleado, apellido2_empleado)  
- **Venta**(codigo_venta, documento_empleado_venta, fecha_venta, total_venta)  
- **DetalleVenta**(codigo_detalle, codigo_venta_detalle, codigo_producto_detalle, cantidad_producto_detalle, precio_unitario_detalle)  
- **Producto**(codigo_producto, nombre_producto, precio_producto, stock_producto, fecha_vencimiento_producto)  
- **Categoría**(codigo_categoria, nombre_categoria)  
- **ProductoCategoría**(codigo_producto_pc, codigo_categoria_pc)  
