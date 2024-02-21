# Module 1 -  This is the codebase for Module 1
For more details, check the source code.

Notion Link: https://www.notion.so/Lecci-n-Manejo-de-excepciones-y-c-digos-de-estado-HTTP-2079f23208044dcda04aaa4060d06918?pvs=4

# Lección - Manejo de excepciones y códigos de estado HTTP.

## Objetivo

Para esta lección, el objetivo es que los estudiantes comprendan y puedan implementar un manejo efectivo de excepciones y códigos de estado HTTP en sus aplicaciones Spring Boot. 

## ¿Que temas vamos a aprender?

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

## Contenido

### 1. Creación de proyectos

**Comando**

**Nota:** Para Windows debes ejecutar el comando en la última versión de PowerShell. Si tienes duda, revisa el manual de herramientas.

Mac, Linux o Windows

```
curl https://start.spring.io
```

**Descripción**

Al ejecutar este comando estás accediendo al servicio web de Spring Initializer para obtener información sobre cómo configurar un nuevo proyecto de Spring Boot directamente desde la línea de comandos de tu terminal. Esto es útil para automatizar la creación de proyectos o para obtener detalles de configuración específicos. Spring Initializer es una herramienta en línea que permite a los desarrolladores generar proyectos de Spring Boot con configuraciones personalizadas, incluyendo dependencias, versión de Spring Boot, lenguaje de programación, etc.

------

**Comando**

**Nota:** Para Windows debes ejecutar el comando en la última versión de PowerShell. Si tienes duda, revisa el manual de herramientas.

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

------

**Comando**

Mac o Linux

```
curl https://start.spring.io/starter.tgz \
-d bootVersion=3.1.1 \
-d groupId=com.apixcloud.users \
-d artifactId=user-service-m1-p3-start \
-d dependencies=web,devtools,actuator \
-d version=0.1.0-SNAPSHOT \
-d type=maven-project \
-d baseDir=users-service \
| tar -xzvf - && users-service
```

Windows. Paso 1

```
curl https://start.spring.io/starter.zip `
-d bootVersion=3.1.1 `
-d groupId=com.apixcloud.users `
-d artifactId=user-service-m1-p3-start `
-d dependencies=web,devtools,actuator `
-d version=0.1.0-SNAPSHOT `
-d type=maven-project `
-d baseDir=users-service `
-o users-service.zip
```

Windows. Paso 2

```
Expand-Archive -Path users-service.zip -DestinationPath .\
```

------

**Descripción**

- `curl https://start.spring.io/starter.zip`: Este comando utiliza `curl` para realizar una solicitud HTTP GET a `https://start.spring.io/starter.zip`. 

- `-d bootVersion`: Aquí se especifica una opción `-d`, que se utiliza para enviar datos en la solicitud HTTP. En este caso, se está enviando el parámetro `bootVersion` con el valor `3.1.1`. Esto indica que queremos generar un proyecto de Spring Boot con la versión 3.1.1 de Spring Boot.

- `-d groupId: Este parámetro indica el ID del grupo para el proyecto.

- `-d artifactId: Este parámetro indica el ID del artefacto para el proyecto.

- `-d dependencies: Aquí se especifican las dependencias que queremos incluir en el proyecto. 

- `-d version`: Este parámetro especifica la versión del proyecto. 

- `-d type`: Este parámetro indica el tipo de proyecto que queremos generar. 

- `-d baseDir`: Este parámetro especifica el directorio base para el proyecto. 

- `-o archivo.extensión`: Con esta opción, `curl` guarda la respuesta de la solicitud HTTP en un archivo local con su respectiva extensión.

- En MAC o Linux

  `| tar -xzvf`

  En Windows: 

  `| Expand-Archive -Path archivo.zip -DestinationPath .\archivo`

  Después de que `curl` descargue el archivo ZIP del proyecto, el operador de canal (`|`) redirige la salida de `curl` para descomprimir el archivo ZIP en el directorio actual, utilizando el nombre de archivo y extrayendo los archivos en la carpeta raíz.

### 2. Configuración de los proyectos 

**user-admin-parent-m1-p2-start**

Abriremos el proyecto en nuestro entorno de desarrollo integrado (IDE) y procederemos a modificar el archivo pom.xml mediante la adición de la siguiente línea de código XML:

```xml
<packaging>pom</packaging>
```

**commons**

Abriremos el proyecto en nuestro entorno de desarrollo integrado (IDE) y editaremos el archivo pom.xml, reemplazando el bloque `parents` con el siguiente código XML:

```xml
<parent>
    <groupId>com.apixcloud.app</groupId>
    <artifactId>user-admin-parent-m1-p3-start</artifactId>
    <version>0.1.0-SNAPSHOT</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

Ahora bien, sobre el mismo archivo pom.xml, agregaremos un bloque que se muestra a continuación en el código XML:

```xml
<build>
		<finalName>commons-${version}</finalName>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <filtering>true</filtering>
        </resource>
    </resources>

    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

Este bloque nos va a permitir modificar la manera en que Spring Boot construye nuestro archivo JAR.

**users-service**

Abriremos el proyecto en nuestro entorno de desarrollo integrado (IDE) y editaremos el archivo pom.xml como se muestra a continuación en el código XML:

```xml
<build>
		<finalName>users-service-${version}</finalName>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <filtering>true</filtering>
        </resource>
    </resources>

    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

Este bloque nos va a permitir modificar la manera en que Spring Boot construye nuestro archivo JAR.

### 2. Construcción de los proyectos 

**commons**

Ejecutar el comando para construir nuestro proyecto:

```
mvn clean install
```





## Recursos adicionales

##### Maven “fileName”

https://maven.apache.org/plugins/maven-jar-plugin/jar-mojo.html#finalName

##### Versioning Semantic

https://semver.org/

