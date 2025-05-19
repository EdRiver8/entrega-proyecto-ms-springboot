DROP TABLE IF EXISTS detalle_venta CASCADE;
DROP TABLE IF EXISTS productos_categorias CASCADE;
DROP TABLE IF EXISTS productos CASCADE;
DROP TABLE IF EXISTS categorias CASCADE;
DROP TABLE IF EXISTS ventas CASCADE;
DROP TABLE IF EXISTS empleados CASCADE;

CREATE TABLE empleados (
    documento_empleado BIGINT PRIMARY KEY,
    nombre_empleado TEXT,
    apellido1_empleado TEXT,
    apellido2_empleado TEXT
);

CREATE TABLE ventas (
    codigo_venta BIGINT PRIMARY KEY AUTO_INCREMENT,
    fecha_venta DATE,
    total_venta NUMERIC,
    documento_empleado BIGINT REFERENCES empleados(documento_empleado)
);

CREATE TABLE productos (
    codigo_producto BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre_producto TEXT,
    precio_producto NUMERIC,
    stock_producto INTEGER,
    fecha_vencimiento DATE
);

CREATE TABLE categorias (
    codigo_categoria BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre_categoria TEXT
);

CREATE TABLE productos_categorias (
    codigo_producto BIGINT REFERENCES productos(codigo_producto),
    codigo_categoria BIGINT REFERENCES categorias(codigo_categoria),
    PRIMARY KEY (codigo_producto, codigo_categoria)
);
CREATE TABLE detalle_venta (
    codigo_detalleventa BIGINT PRIMARY KEY AUTO_INCREMENT,
    cantidad_producto INTEGER,
    precio_unitario NUMERIC,
    codigo_venta BIGINT REFERENCES ventas(codigo_venta),
    codigo_producto BIGINT REFERENCES productos(codigo_producto)
);


