-- Creación de la tabla CLIENTE
CREATE TABLE CLIENTE (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         NOMBRE VARCHAR(255),
                         APELLIDO VARCHAR(255),
                         DNI INT
);

-- Creación de la tabla PRODUCTO
CREATE TABLE PRODUCTO (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          pr_Nombre VARCHAR(255),
                          pr_Caracteristicas VARCHAR(255) UNIQUE,
                          pr_Stock INT,
                          pr_Precio DOUBLE
);

-- Creación de la tabla VENTA
CREATE TABLE VENTA (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       fecha VARCHAR(255) UNIQUE,
                       cliente_id INT,
                       cantidad_Total_Productos INT,
                       importe_Total DOUBLE,
                       FOREIGN KEY (cliente_id) REFERENCES CLIENTE(id)
);

-- Creación de la tabla DETALLEVENTA
CREATE TABLE DETALLE_VENTA (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              cliente_id INT,
                              venta_id BIGINT,
                              producto_id INT,
                              pr_Caracteristicas VARCHAR(255),
                              cantidad_vendida INT,
                              pr_Precio DOUBLE,
                              importe_Total DOUBLE,
                              FOREIGN KEY (cliente_id) REFERENCES CLIENTE(id),
                              FOREIGN KEY (venta_id) REFERENCES VENTA(id),
                              FOREIGN KEY (producto_id) REFERENCES PRODUCTO(id),
                              FOREIGN KEY (pr_Caracteristicas) REFERENCES PRODUCTO(pr_Caracteristicas)
);