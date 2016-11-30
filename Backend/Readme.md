### MISO-MDE    -   PILA

```

En esta carpeta esta el proyecto backend plantilla
Contiene
Un proyecto esqueleto con dos servicios REST usando Jersey Ver 2.22.2
Todas las librerias necesarias para soportar REST y JSON como entrada y salida de los servicios

Instrucciones Instalacion Back End

USAR ECLIPSE NEON JEE DEVELOPER

El directorio Backend es en si mismo un work space

1) Descargar la informacion de GitHub
2) Abrir Neon y usar como work space este mismo directorio Back End Ej ../Pila/PagosTemplate/Backend
3) Importar Existing Projects into work space
4) Seleccionar la bandera Esconder Proyectos ya existentes en el work space
5) Run para importar los proyectos
6) Bajar o usar la aplicacion Apache Tomcat: Se probo con apache-tomcat-8.0.24
7) En servers crear un nuevo servidor apache tomcat v8.0 y seleccionar la ruta de instalacion ubicada en el punto anterior
8) Ya en GIT como parte de este repositorio hay unos archivos de configuracion del web server: Solo se modifico el archivo para adicionar banderas de CORS (Manejo de peticiones cross dominio) Usar el archivo del respositorio GIT o asegurarse que ene el archivo web.xml esten las instrucciones de Filter (Ver mas abajo)
9) En la raiz del proyecto click derecho maven --> update project
10) En la raiz del proyecto click derecho --> Run As Maven Build al aparecer la ventana escribir en goals:
clean install
11) Ejecutar Run y seleccionar el servidor tomcat
*Posibles Errores: Si al hacer esto maven coloca un error es necesario volver a repetir el paso 9 y volver a correr
12) Una vez sube el servidor probar con este URL para asegurar que todo esta corriendo: 
http://localhost:8080/PilaPayments/test/rest 
Aparece HelloWorld

13 Verificar que en el archivo web.xml del servidor tomcat aparecen los siguientes filtros o de lo contrario copiarlos:

<filter>
<filter-name>CorsFilter</filter-name>
<filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
<init-param>
<param-name>cors.allowed.origins</param-name>
<param-value>*</param-value>
</init-param>
<init-param>
<param-name>cors.allowed.methods</param-name>
<param-value>GET,POST,HEAD,OPTIONS,PUT</param-value>
</init-param>
<init-param>
<param-name>cors.allowed.headers</param-name>
<param-value>Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers</param-value>
</init-param>
<init-param>
<param-name>cors.exposed.headers</param-name>
<param-value>Access-Control-Allow-Origin,Access-Control-Allow-Credentials</param-value>
</init-param>
<init-param>
<param-name>cors.support.credentials</param-name>
<param-value>true</param-value>
</init-param>
<init-param>
<param-name>cors.preflight.maxage</param-name>
<param-value>10</param-value>
</init-param>
</filter>
<filter-mapping>
<filter-name>CorsFilter</filter-name>
<url-pattern>/*</url-pattern>
</filter-mapping>

```
