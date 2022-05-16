# ProyectoDAW
Entrega final proyecto DAW

Manual de despliegue

##Despliegue a partir de Docker:

Requerimientos:
• Docker

Los nombres de las 3 imágenes que necesitaremos son:
• klabitos/imgbbdd4
• klabitos/backmeteown3
• klabitos/ vue_tipo3_parte25

Comenzaremos creando una red donde desplegaremos los contenedores, para ello desde nuestro terminal docker ejecutaremos lo siguiente:

** docker create network appmeteown** 

Para ejecutar nuestra imagen de la base de datos:

docker run -d --network appmeteown --name mi_mysql -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=meteown_proyecto -e MYSQL_PASSWORD=123456 -p 3307:3306 klabitos/img_bbdd4

Después, para entrar en ese contenedor:

** docker exec -it mi_mysql mysql -uroot -p** 

Nos pedirá una contraseña, que será 123456. (En caso de fallar, esperar 1 minuto y volver a intentar). Ahora crearemos un usuario escribiendo tres comandos:

** create user 'mysqluser' identified by 'secret';
GRANT ALL PRIVILEGES ON *.* TO 'mysqluser'@'%';
exit;** 

Ahora que tenemos desplegada la base de datos de manera correcta seguimos con el back:

** docker run -d --network appmeteown --name back -p 8080:8080 klabitos/backmeteown3** 

Por último, desplegaremos el front.

** docker run -d --rm --name appmeteown_front --network appmeteown -p 8081:8080 klabitos/vue_tipo3_parte25** 

Ahora desde el navegador podremos acceder al proyecto con localhost:8081/

##Despliegue a partir de archivos en GitHub:

Requerimientos para un funcionamiento óptimo:
• MySQL Workbench y server
• Eclipse Enterprise Edition con Spring Boot
• VUE3 Cli
• Visual Studio
• Node. js version 8.9 o superior

Con los archivos de GitHub desplegaremos la aplicación de manera local. Para ello, en primer lugar, importaremos la base de datos, usando el script que se incluye. Luego en nuestro proyecto back habrá que configurar la contraseña de la base de datos adecuada al usuario, para ello modificaremos el application.propperties.

Para el back, importaremos en eclipse el proyecto como Maven, y lo ejecutaremos con Spring Boot.
Para el front, abriremos el proyecto con Visual Studio, instalaremos las dependencias con** npm install**  y ejecutaremos ** npm run serve** .

El back habrá sido desplegado en el puerto 8080, el front en el 8081, por lo que podremos acceder a la web en localhost:8081/
