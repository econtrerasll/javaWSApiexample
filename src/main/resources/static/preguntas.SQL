-- a) Cuál sería el query para mostrar la marca y modelos de todos los equipos del usuario Jose Cabrera (Celulares y Routers)
select * from (
                  select r.marca_router marca,r.modelo_router modelo from Routers r where r.id_user = (SELECT u.id_user FROM usuarios u WHERE u.nombre ='jose' AND u.apellido ='cabrera')
                  union all
                  select c.marca marca,c.modelo modelo from Celulares c where c.id_user = (SELECT u.id_user FROM usuarios u WHERE u.nombre ='jose' AND u.apellido ='cabrera')
              );

--b) Cuál sería el query para mostrar los celulares de Hernesto Fernandez
select c.marca marca,c.modelo modelo from Celulares c where c.id_user = (SELECT u.id_user FROM usuarios u WHERE u.nombre ='hernesto' AND u.apellido ='fernandez');
--c) Cuál sería el query para mostrar los router de Miguel Perez
select r.marca_router marca,r.modelo_router modelo from Routers r where r.id_user = (SELECT u.id_user FROM usuarios u WHERE u.nombre ='miguel' AND u.apellido ='perez');
-- d) Cuál sería el query para mostrar el nombre y el apellido de la persona que tiene el equipo cisco T2556
SELECT u.nombre ,u.apellido  FROM usuarios u WHERE u.id_User in (
    select r.id_User id from routers r where r.marca_router = 'cisco'and r.modelo_router ='t2556'
    union
    select c.id id from celulares c where c.marca = 'cisco'and c.modelo ='t2556'
);