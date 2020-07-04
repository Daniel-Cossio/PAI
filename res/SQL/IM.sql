-- grupos para clasificación
CREATE TABLE groupp
(
    code_g VARCHAR(10) PRIMARY KEY NOT NULL,
    name_g VARCHAR(30)

);

--subgrupos para clasificar 
CREATE TABLE subgroup
(
    code_sg VARCHAR(10) PRIMARY KEY NOT NULL,
    name_sg VARCHAR(30),
    code_g VARCHAR(10), --foreing key to groupp

    CONSTRAINT FKGROUP FOREIGN KEY (code_g) REFERENCES groupp(code_g) 
    ON DELETE SET NULL

);

-- productos para llevar la cuenta de estos
CREATE TABLE product
(
    code_p VARCHAR(10) PRIMARY KEY NOT NULL,
    name_p VARCHAR(30),
    measure varchar(15), --measure to use
    -- initial  DECIMAL(13,4), -- stock initial to month <- este es un multivaluado porque guarda los registros iniciales
    -- stock  DECIMAL(13,4), -- inventario inicial actual <- este se calcula por medio de la sumatoria generada de los registros
    code_sg VARCHAR(10), -- foreing key to subgroup
    CONSTRAINT FKSUBGROUP FOREIGN KEY (code_sg) REFERENCES subgroup (code_sg) 
    ON DELETE SET NULL
);

-- departamentos para las salidads
CREATE TABLE department
(
    code_d VARCHAR(10) PRIMARY KEY NOT NULL,
    name_d varchar(40)
);

-- Registro de movimientos (Estatico)
CREATE TABLE rmovement
(
    code_m int IDENTITY PRIMARY KEY NOT NULL,
    date_m DATE,
    code_invoice VARCHAR(20), --invoice code to detect fact or doc that do the movement
    type_m VARCHAR(15), --{in, out, adhin, adjout}
    quantity DECIMAL(13,4), 
    total_pryce DECIMAL(13,4), --(precio total)
    -- unit_pryceryce DECIMAL(13,4), <- se calcula a partir del precio total
    code_p VARCHAR(10), --fonring key to product
    code_d VARCHAR(10), -- foreing key to department

    CONSTRAINT FKMPRODUCT FOREIGN KEY (code_p) REFERENCES product (code_p) 
    ON DELETE SET NULL,
    CONSTRAINT FKMDEPARTMENT FOREIGN KEY (code_d) REFERENCES department (code_d) 
    ON DELETE SET NULL

);

-- Registro de inventario (Dinamic)
CREATE TABLE rstock
(
    code_st int IDENTITY PRIMARY KEY NOT NULL,
    date_st DATE,
    total_pryce DECIMAL(13,4), 
    quantity DECIMAL(13,4),
    code_p VARCHAR(10),

    CONSTRAINT FKRSPRODUCT FOREIGN KEY (code_p) REFERENCES product (code_p) 
    ON DELETE SET NULL
);

-- Registro de Cierre de mes (storage date cloced month)
CREATE TABLE rclosemonth
(
    code_cm IDENTITY PRIMARY KEY NOT NULL,
    date_cm DATE
);

-- Registor de stock initial 
CREATE TABLE rinitialstock
(
    code_p VARCHAR(10) NOT NULL,
    code_cm VARCHAR(10) NOT NULL,
    measure DECIMAL(13,4),
    total_pryce DECIMAL(13,4),

    PRIMARY KEY (code_p,code_cm),
    CONSTRAINT FKISPRODUCT FOREIGN KEY (code_p) REFERENCES product (code_p)
    ON DELETE CASCADE,
    CONSTRAINT FKISCLOSEMONTH FOREIGN KEY (code_cm) REFERENCES rclosemonth (code_cm)
    ON DELETE CASCADE
    
);

-- is the users in the rols to managment to system
CREATE TABLE userIM
(
    code_u VARCHAR(10) PRIMARY KEY NOT NULL,
    name_u VARCHAR(60),
    password_u VARCHAR (30)
);
