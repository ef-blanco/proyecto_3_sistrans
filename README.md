Instrucciones para la instalación de la app:

1. Clonar el repositorio en Visual Studio Code a el ambiente de su preferencia
2. Revisar que el archivo .properties tenga estos campos:
   spring.data.mongodb.uri=mongodb://ISIS2304C15202510:uKApKXtrAvnq@157.253.236.88:8087/
   spring.data.mongodb.database=ISIS2304C15202510

3. Abrir en mongoDB la base de datos con la uri del archivo properties para verificar los cambios en la DB
4. Importar las colecciones de Postman de la carpeta collecciones para probar el CRUD y lso RFCs
5. Correr la aplicacion desde DemoAplication.java y usar Postman para probar las operaciones CRUD y los RFCs (los cambios se deberían reflejar en MongoDB)
