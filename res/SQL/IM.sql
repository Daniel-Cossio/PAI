-- grupos para clasificación
CREATE TABLE groupp
(
    code_g TEXT PRIMARY KEY NOT NULL,
    name_g TEXT 

);


--subgrupos para clasificar 
CREATE TABLE subgroup
(
    code_sg TEXT PRIMARY KEY NOT NULL,
    name_sg TEXt,
    code_g TEXT, --foreing key to groupp

    CONSTRAINT FKSGTOG FOREIGN KEY (code_g) REFERENCES groupp(code_g) 
    ON DELETE SET NULL                  

);

-- productos para llevar la cuenta de estos
CREATE TABLE product
(
    code_p TEXT PRIMARY KEY NOT NULL,
    name_p TEXT,
    measure TEXT, --measure to use
    -- initial  DECIMAL(13,4), -- stock initial to month <- este es un multivaluado porque guarda los registros iniciales
    -- stock  DECIMAL(13,4), -- inventario inicial actual <- este se calcula por medio de la sumatoria generada de los registros
    code_sg TEXT, -- foreing key to subgroup
    CONSTRAINT FKPTOSG FOREIGN KEY (code_sg) REFERENCES subgroup (code_sg) 
    ON DELETE SET NULL
);

-- departamentos para las salidads
CREATE TABLE department
(
    code_d TEXT PRIMARY KEY NOT NULL,
    name_d TEXT
);

-- is the users in the rols to managment to system
CREATE TABLE userim     
(
    code_u TEXT PRIMARY KEY NOT NULL,
    name_u TEXT,
    password_u TEXT
);


-- Registro de movimientos (Estatico)
CREATE TABLE rmovement
(
    code_m int IDENTITY PRIMARY KEY NOT NULL,
    date_m DATE,
    code_invoice TEXT, --invoice code to detect fact or doc that do the movement
    type_m TEXT, --{in, out, adhin, adjout}
    quantity DECIMAL(13,4), 
    -- unit_pryceryce DECIMAL(13,4), <- se calcula a partir del precio total
    code_p TEXT, --fonring key to product
    code_u TEXT, -- foreing key to department

    CONSTRAINT FKMPRODUCT FOREIGN KEY (code_p) REFERENCES product (code_p) 
    ON DELETE SET NULL,
    CONSTRAINT FKUSER FOREIGN KEY (code_u) REFERENCES userim (code_u) 
    ON DELETE SET NULL

);
-- spetial RMovement

-- rmout, registry to movement out
CREATE TABLE rmout
(
    code_m int IDENTITY PRIMARY KEY NOT NULL,
    code_d TEXT,

    CONSTRAINT FKRMOUTTODEP FOREIGN KEY (code_d) REFERENCES department (code_d)
    ON DELETE CASCADE,
    CONSTRAINT FKRMOUTTOMOV FOREIGN KEY (code_m) REFERENCES rmovement (code_m)
    ON DELETE CASCADE
);

-- rmin, registry to movemento int
CREATE TABLE rmin
(
    code_m int IDENTITY PRIMARY KEY NOT NULL,
    account DECIMAL(13,4),
    total_pryce DECIMAL(13,4),

    CONSTRAINT FKMOV2 FOREIGN KEY (code_m) REFERENCES rmovement (code_m)
    ON DELETE CASCADE
);


-- Registro de Cierre de mes (storage date cloced month)
CREATE TABLE rclosemonth
(
    code_cm int IDENTITY PRIMARY KEY NOT NULL,
    date_cm DATE
);

-- Registor de stock initial 
CREATE TABLE rinitialstock
(
    code_m int IDENTITY NOT NULL,
    code_cm int IDENTITY NOT NULL,
    measure DECIMAL(13,4),

    PRIMARY KEY (code_m,code_cm),
    CONSTRAINT FKRINITOMOV FOREIGN KEY (code_m) REFERENCES rmovement(code_m)
    ON DELETE CASCADE,
    CONSTRAINT FKRINITOCM FOREIGN KEY (code_cm) REFERENCES rclosemonth (code_cm)
    ON DELETE CASCADE
);



--  ths are some epecial querys 
-- select name from sqlite_master where type = "table"; 


--