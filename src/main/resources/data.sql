-- Empleados
INSERT INTO empleados (documento_empleado,nombre_empleado, apellido1_empleado, apellido2_empleado) VALUES
        (1234567890,'Laura', 'Gómez', 'Ramírez'),
        (1234567891,'Carlos', 'Pérez', 'López'),
        (1234567892,'Valentina', 'Martínez', 'Sánchez');


-- Categorías
INSERT INTO categorias (nombre_categoria) VALUES
        ('Cuidado Capilar'),
        ('Coloración'),
        ('Estilizado'),
        ('Tratamientos'),
        ('Accesorios');

-- Productos
INSERT INTO productos (nombre_producto, precio_producto, stock_producto, fecha_vencimiento) VALUES
        ('Shampoo Reparador', 25000, 30, '2026-06-01'),
        ('Acondicionador Hidratante', 23000, 25, '2026-06-01'),
        ('Tinte Rojo Intenso', 18000, 40, '2025-12-31'),
        ('Spray Fijador', 15000, 35, '2026-01-01'),
        ('Mascarilla Capilar Nutritiva', 28000, 20, '2026-04-15'),
        ('Peine de Carbono', 9000, 50, NULL),
        ('Secador Profesional 2200W', 150000, 10, NULL);

-- Productos - Categorías
INSERT INTO productos_categorias (codigo_producto, codigo_categoria) VALUES
        (1, 1), -- Shampoo -> Cuidado Capilar
        (2, 1), -- Acondicionador -> Cuidado Capilar
        (3, 2), -- Tinte -> Coloración
        (4, 3), -- Spray -> Estilizado
        (5, 4), -- Mascarilla -> Tratamientos
        (6, 5), -- Peine -> Accesorios
        (7, 5); -- Secador -> Accesorios

-- Ventas
INSERT INTO ventas (fecha_venta, total_venta, documento_empleado) VALUES
        ('2025-05-01', 73000, 1234567890),
        ('2025-05-02', 180000, 1234567891);

-- Detalle Venta
INSERT INTO detalle_venta (cantidad_producto, precio_unitario, codigo_venta, codigo_producto) VALUES
        (2, 25000, 1, 1), -- 2 Shampoos
        (1, 23000, 1, 2), -- 1 Acondicionador
        (1, 150000, 2, 7), -- 1 Secador
        (2, 9000, 2, 6); -- 2 Peines