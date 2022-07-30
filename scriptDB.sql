CREATE DATABASE sistemaNomina;
USE sistemaNomina;
CREATE TABLE EMPLEADOS (
id int not null auto_increment,
nombre varchar(50) not null,
apellido varchar(50) not null,
valor_hora_extra float,
auxilio_transporte tinyint not null,
salario_empleado float not null,
cedula varchar(25) not null unique,
primary key (id));

INSERT INTO EMPLEADOS (nombre, apellido, valor_hora_extra, auxilio_transporte, salario_empleado)
VALUES ("Heider","suares",1000000,0, 5000000),
		("Yohana","castro",500000,1,3000000),
        ("Jader","rodriguez",20000000,0,6000000),
        ("Lisbeth","gonzales",500000,1,3000000),
        ("Yhony","martinez",null,0,5000000),
        ("Natalia","barrios",500000,1,5000000);
        
SELECT * FROM EMPLEADOS;

