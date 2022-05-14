#Dockerfile para crear una imagen basada en mysql
FROM mysql:5.7.17

#Se copian los scripts desde la carpeta en la que estén al directorio dentro del contenedor
#En este ejemplo no se va a mapear mediante volúmenes ni a bindear la bbdd.
COPY ./scriptSQL/ /docker-entrypoint-initdb.d/

#En el arranque del contenedor habrá que indicar los datos referidos a la bbdd como variables de entorno
#Por ejemplo:
#docker run -d --network appmeteown --name mi_mysql -e MYSQL_ROOT_PASSWORD=923195053 -e MYSQL_DATABASE=meteown_proyecto -e MYSQL_PASSWORD=923195053 -p 3307:3306 klabitos/img_bbdd