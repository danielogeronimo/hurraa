alter table fabricante modify column tipo varchar(30);

update fabricante set tipo = 'HARDWARE' where tipo = '1';
update fabricante set tipo = 'SOFTWARE' where tipo = '2';
update fabricante set tipo = 'HARDWARE_SOFTWARE' where tipo = '3';
