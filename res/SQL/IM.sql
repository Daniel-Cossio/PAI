CREATE TABLE groupp
(
    codeG VARCHAR(10) PRIMARY KEY NOT NULL,
    nameG VARCHAR(30)

);

CREATE TABLE subgroup
(
    codeSG VARCHAR(10) PRIMARY KEY NOT NULL,
    nameSG VARCHAR(30),
    codeG VARCHAR(10), --foreing key to groupp

    CONSTRAINT FKGROUP FOREIGN KEY (codeG) REFERENCES groupp(codeG) 
    ON DELETE SET NULL

);

CREATE TABLE product
(
    codeP VARCHAR(10) PRIMARY KEY NOT NULL,
    nameP VARCHAR(30),
    measure varchar(15), --measure to use
    initial  DECIMAL(13,4), -- stock initial to month
    stock  DECIMAL(13,4), -- inventario inicial actual
    codeSG VARCHAR(10), -- foreing key to subgroup

    CONSTRAINT FKSUBGROUP FOREIGN KEY (codeSG) REFERENCES subgroup (codeSG) 
    ON DELETE SET NULL
);

CREATE TABLE department
(
    codeD VARCHAR(10) PRIMARY KEY NOT NULL,
    nameD varchar(40)
);

CREATE TABLE movement
(
    codeM int IDENTITY PRIMARY KEY NOT NULL,
    dateM DATE,
    codeInvoice VARCHAR(20), --invoice code to detect fact or doc that do the movement
    typeM VARCHAR(15), --{in, out, adhin, adjout}
    quantity DECIMAL(13,4),
    total DECIMAL(13,4),
    unitPryce DECIMAL(13,4),
    codeP VARCHAR(10), --fonring key to product
    codeD VARCHAR(10) -- foreing key to department

);


-- is the users in the rols to managment to system
CREATE TABLE userIM
(
    codeU VARCHAR(10) PRIMARY KEY NOT NULL,
    nameU VARCHAR(60),
    passwordU VARCHAR (30)
);
