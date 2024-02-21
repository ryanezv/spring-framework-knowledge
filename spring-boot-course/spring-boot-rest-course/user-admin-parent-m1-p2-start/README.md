# Module 1 -  This is the codebase for Module 1
For more details, check the source code.

Notion Link: https://www.notion.so/Lecci-n-Manejo-de-excepciones-y-c-digos-de-estado-HTTP-2079f23208044dcda04aaa4060d06918?pvs=4

# Lección - Manejo de excepciones y códigos de estado HTTP.

### Objetivo

Para esta lección, el objetivo es que los estudiantes comprendan y puedan implementar un manejo efectivo de excepciones y códigos de estado HTTP en sus aplicaciones Spring Boot. 

### ¿Que temas vamos a aprender?

**Manejo de Excepciones:**

- Implementar un manejo global de excepciones utilizando `@ControllerAdvice` para centralizar la lógica de manejo de excepciones en toda la aplicación.
- Personalizar respuestas de error para diferentes tipos de excepciones, como devolver mensajes de error claros y códigos de estado HTTP apropiados.
- Configurar Excepciones globales en nuestra API. 

**Códigos de Estado HTTP:**

- Familiarizarse con los códigos de estado HTTP comunes y su significado.
- Tratar respuestas de error HTTP 4XX.
- Tratar respuestas de error HTTP 5XX.
- Utilizar códigos de estado HTTP adecuados en las respuestas de la aplicación según la situación, asegurándose de que las respuestas reflejen correctamente el estado de la operación.

**Mejoras y Buenas Prácticas:**

- Configurar todas las respuestas correctas al cliente final.

### Readme para la clase

**Nota:** Para Windows debes ejecutar el comando en la última versión de PowerShell. Si tienes duda, revisa el manual de herramientas.

------

**Comando**

Mac, Linux o Windows

`curl https://start.spring.io`

**Descripción**

Al ejecutar este comando estás accediendo al servicio web de Spring Initializer para obtener información sobre cómo configurar un nuevo proyecto de Spring Boot directamente desde la línea de comandos de tu terminal. Esto es útil para automatizar la creación de proyectos o para obtener detalles de configuración específicos. Spring Initializer es una herramienta en línea que permite a los desarrolladores generar proyectos de Spring Boot con configuraciones personalizadas, incluyendo dependencias, versión de Spring Boot, lenguaje de programación, etc.

------

**Comando**

Mac o Linux

```
curl https://start.spring.io/starter.tgz \
-d bootVersion=3.1.1 \
-d groupId=com.apixcloud.app \
-d artifactId=user-admin-parent-m1-p2-start \
-d dependencies=web \
-d version=0.1.0-SNAPSHOT \
-d type=maven-project \
-d baseDir=user-admin-parent-m1-p2-start \
| tar -xzvf - && cd user-admin-parent-m1-p2-start
```

Windows. Paso 1

```
curl https://start.spring.io/starter.zip `
-d bootVersion=3.1.1 `
-d groupId=com.apixcloud.app `
-d artifactId=user-admin-parent-m1-p2-start `
-d dependencies=web `
-d version=0.1.0-SNAPSHOT `
-d type=maven-project `
-d baseDir=user-admin-parent-m1-p2-start `
-o user-admin-parent-m1-p2-start.zip `
```

Windows. Paso 2

```
Expand-Archive -Path user-admin-parent-m1-p2-start.zip -DestinationPath .\
```

**Descripción**

Este comando utiliza `curl` para generar un proyecto de Spring Boot desde Spring Initializer, utilizando las configuraciones especificadas, y luego descomprime el archivo ZIP del proyecto en el directorio local. Esto nos permite generar rápidamente proyectos de Spring Boot con las dependencias y configuraciones deseadas desde la línea de comandos.

- `curl https://start.spring.io/starter.zip`: Este comando utiliza `curl` para realizar una solicitud HTTP GET a `https://start.spring.io/starter.zip`. 

- `-d bootVersion=3.1.1`: Aquí se especifica una opción `-d`, que se utiliza para enviar datos en la solicitud HTTP. En este caso, se está enviando el parámetro `bootVersion` con el valor `3.1.1`. Esto indica que queremos generar un proyecto de Spring Boot con la versión 3.1.1 de Spring Boot.

- `-d groupId=com.apixcloud.app`: Este parámetro indica el ID del grupo para el proyecto. En este caso, se establece como `com.apixcloud.app`.

- `-d artifactId=user-admin-parent-m1-p2-start`: Este parámetro indica el ID del artefacto para el proyecto. En este caso, se establece como `user-admin-parent-m1-p2-start`.

- `-d dependencies=web`: Aquí se especifican las dependencias que queremos incluir en el proyecto. En este caso, se incluye la dependencia `web`, que proporciona soporte para la creación de aplicaciones web con Spring Boot.

- `-d version=0.1.0-SNAPSHOT`: Este parámetro especifica la versión del proyecto. En este caso, se establece como `0.1.0-SNAPSHOT`.

- `-d type=maven-project`: Este parámetro indica el tipo de proyecto que queremos generar. En este caso, se especifica que queremos un proyecto de tipo Maven.

- `-d baseDir=user-admin-parent-m1-p2-start`: Este parámetro especifica el directorio base para el proyecto. En este caso, se establece como `user-admin-parent-m1-p2-start`.

- `-o user-admin-parent-m1-p2-start.zip`: Con esta opción, `curl` guarda la respuesta de la solicitud HTTP en un archivo local llamado `user-admin-parent-m1-p2-start.zip`.

- En MAC o Linux

  `| tar -xzvf - && cd user-admin-parent-m1-p2-start`

  En Windows: 

  `| Expand-Archive -Path user-admin-parent-m1-p2-start.zip -DestinationPath .\user-admin-parent-m1-p2-start`

  Después de que `curl` descargue el archivo ZIP del proyecto, el operador de canal (`|`) redirige la salida de `curl` para descomprimir el archivo ZIP en el directorio actual, utilizando el nombre de archivo `user-admin-parent-m1-p2-start.zip` y extrayendo los archivos en la carpeta `.\user-admin-parent-m1-p2-start`.

------

Esto que :

Entrar al archivo pom.xml del proyecto creado “user-admin-parent-m1-p2-start” y agregar la siguiente linea: Donde va ? despues de que? 

```xml
<packaging>pom</packaging>
```

------

**Comando**

Mac o Linux

```
curl https://start.spring.io/starter.tgz \
-d bootVersion=3.1.1 \
-d groupId=com.apixcloud.commons \
-d artifactId=commons-m1-p2-start \
-d dependencies=web,lombok,actuator \
-d version=0.1.0-SNAPSHOT \
-d type=maven-project \
-d baseDir=commons \
| tar -xzvf - && cd commons
```

Windows. Paso 1

```
curl https://start.spring.io/starter.zip `
-d bootVersion=3.1.1 `
-d groupId=com.apixcloud.commons `
-d artifactId=commons-m1-p2-start `
-d dependencies=web,lombok,actuator `
-d version=0.1.0-SNAPSHOT `
-d type=maven-project `
-d baseDir=commons `
-o commons.zip
```

Windows. Paso 2

```
Expand-Archive -Path commons.zip -DestinationPath .\
```

**Descripción**

PAra que

- `curl https://start.spring.io/starter.zip`: Este comando utiliza `curl` para realizar una solicitud HTTP GET a `https://start.spring.io/starter.zip`. 

- `-d bootVersion=3.1.1`: Aquí se especifica una opción `-d`, que se utiliza para enviar datos en la solicitud HTTP. En este caso, se está enviando el parámetro `bootVersion` con el valor `3.1.1`. Esto indica que queremos generar un proyecto de Spring Boot con la versión 3.1.1 de Spring Boot.

- `-d groupId=com.apixcloud.app`: Este parámetro indica el ID del grupo para el proyecto. En este caso, se establece como `com.apixcloud.app`.

- `-d artifactId=user-admin-parent-m1-p2-start`: Este parámetro indica el ID del artefacto para el proyecto. En este caso, se establece como `user-admin-parent-m1-p2-start`.

- `-d dependencies=web`: Aquí se especifican las dependencias que queremos incluir en el proyecto. En este caso, se incluye la dependencia `web`, que proporciona soporte para la creación de aplicaciones web con Spring Boot.

- `-d version=0.1.0-SNAPSHOT`: Este parámetro especifica la versión del proyecto. En este caso, se establece como `0.1.0-SNAPSHOT`.

- `-d type=maven-project`: Este parámetro indica el tipo de proyecto que queremos generar. En este caso, se especifica que queremos un proyecto de tipo Maven.

- `-d baseDir=user-admin-parent-m1-p2-start`: Este parámetro especifica el directorio base para el proyecto. En este caso, se establece como `user-admin-parent-m1-p2-start`.

- `-o user-admin-parent-m1-p2-start.zip`: Con esta opción, `curl` guarda la respuesta de la solicitud HTTP en un archivo local llamado `user-admin-parent-m1-p2-start.zip`.

- En MAC o Linux

  `| tar -xzvf - && cd user-admin-parent-m1-p2-start`

  En Windows: 

  `| Expand-Archive -Path user-admin-parent-m1-p2-start.zip -DestinationPath .\user-admin-parent-m1-p2-start`

  Después de que `curl` descargue el archivo ZIP del proyecto, el operador de canal (`|`) redirige la salida de `curl` para descomprimir el archivo ZIP en el directorio actual, utilizando el nombre de archivo `user-admin-parent-m1-p2-start.zip` y extrayendo los archivos en la carpeta `.\user-admin-parent-m1-p2-start`.