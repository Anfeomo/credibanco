
# Prueba Tecnica Bank ink

## Descripción
Este proyecto es una aplicación desarrollada con Java Spring Boot. Las instrucciones a continuación detallan cómo empaquetar la aplicación utilizando Maven y desplegarla utilizando Docker Compose.

## Requisitos Previos
Antes de iniciar, asegúrate de tener instaladas las siguientes herramientas:

- Java JDK 11 o superior
- Maven 3.6.3 o superior
- Docker
- Docker Compose

## Instrucciones de Despliegue

### 1. Clonar el Repositorio
Primero, clona el repositorio del proyecto a tu máquina local:


### 2. Empaquetar la Aplicación
Utiliza el wrapper de Maven para limpiar y empaquetar la aplicación sin ejecutar las pruebas:

```./mvnw clean package -DskipTests```
Este comando generará un archivo JAR en el directorio target.

### 3. Construir y Desplegar con Docker Compose
Una vez empaquetada la aplicación, utiliza Docker Compose para construir las imágenes de Docker y desplegar los contenedores:

```docker-compose up --build```

### Archivos Importantes
`docker-compose.yml`
Este archivo define los servicios de Docker que se utilizarán para desplegar la aplicación. Asegúrate de que esté configurado correctamente para tu entorno.

`application.properties`
El archivo de propiedades de configuración de Spring Boot. Asegúrate de que contenga las configuraciones necesarias para tu entorno, como las configuraciones de la base de datos y otras variables de entorno.

### Acceso a la Aplicación
Una vez que Docker Compose haya terminado de construir y desplegar los contenedores, la aplicación debería estar accesible en el puerto especificado en el archivo docker-compose.yml. Por defecto, puede ser http://localhost:8080
