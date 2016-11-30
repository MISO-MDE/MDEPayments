/* Inserta Usuario principal Intermediario */
insert into pilauser
(user_id, email, password, userid, username, rol)
values (1, 'pagos@deuna.com', null, 'M00UYKY5EReZlnhzsHeEWG0Mhpn1', 'PagosAdmin', 'Intermediary');

/* Inserta Interseccion */
insert into pilauserintermediary 
values (1);

commit;

insert into pilasuperentity
values(1, 900539845, 'ESTABLECIMIENTO_EDUCACION_MEDIA', 'Oracle');

insert into pilauser
(user_id, email, password, userid, username, rol)
values (2, 'a@a.com', null, 'gZb2YS9yafhbPDKzTrW5MkGl92b2', 'Ivan', 'Intermediary');


insert into pilausersuperentity
values (1, 2);

/*
insert into pilausersuperentity
values (1, 1);

insert into pilaentity
values (1, 'ESTABLECIMIENTO_EDUCACION_MEDIA', 'Gomez',79132132, 'Jorge', 12, 12, 17000000, 'VEJEZ', 'BENEFICIARIO_UPC_ADICIONAL', null );

insert into pilaentity
values (2, 'ESTABLECIMIENTO_EDUCACION_MEDIA', 'Gomez',72000000, 'Jorge', 12, 12, 17000000, 'VEJEZ', 'BENEFICIARIO_UPC_ADICIONAL', null );


select * from PilaUserIntermediary pilauserin0_ inner join PilaUser pilauserin0_1_ on 
pilauserin0_.intermediary_id=pilauserin0_1_.user_id where pilauserin0_1_.userId='1'

select pilauserin0_.intermediary_id as user_id1_7_, pilauserin0_1_.email as email2_7_, pilauserin0_1_.password as password3_7_, pilauserin0_1_.rol as rol4_7_, pilauserin0_1_.userId as userId5_7_, pilauserin0_1_.username as username6_7_ from PilaUserIntermediary pilauserin0_ inner join PilaUser pilauserin0_1_ on pilauserin0_.intermediary_id=pilauserin0_1_.user_id 
where pilauserin0_1_.userId='1'


commit;
*/


select * from pilasuperentity;

select * from pilauser;


select * from pilausersuperentity;

select * from pilaentity;






Tabla Tipo Pension
Codigo integer
Desc

Tabla Tipo Pensionado
Codigo integer
Desc

Tabla Tipo Pagador
Codigo integer
Desc

Tabla 8
id
Codigo de Tabla Tipo Pension
Codigo de Tabla Tipo Pensionado

Tabla 6
id
Codigo de Tabla Tipo Pension
Codigo de Tabla Tipo Pagador

Tabla 3
id
Codigo de Tabla Tipo Pensionado
Codigo de Tabla Tipo Pagador

insert into tabla3
(1, 1, 1)

insert into tabla3
(2, 1, 2)

insert into tabla3
(3, 1, 3)

insert into tabla3
(4, 2, 2)

insert into tabla3
(5, 2, 3)

insert into tabla3
(6, 2, 3)


Entonces las validaciones son asi

Select * from tabla3 
where Tipo Pensionado=1 and
Tipo Pagador=04

Si el query regresa nulo entonces creamos un error tipo: A

Hacemos el query para las tablas 3, 6, 8










