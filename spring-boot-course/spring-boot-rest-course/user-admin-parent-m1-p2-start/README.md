# Módulo 1 - Práctica 2 - Manejo de excepciones y códigos de estado HTTP.

### Antes de comenzar

El siguiente comando será útil para acceder al servicio web de Spring Initializer y visualizar toda la información sobre las opciones disponibles para configurar un nuevo proyecto de Spring Boot directamente desde la línea de comandos de tu terminal.

```text
Mac/Linux/Windows

curl https://start.spring.io
```

### Paso 1. Creación y configuración de proyectos

Proyecto **user-admin-parent-m1-p2-start**

```
Mac/Linux

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

```
Windows paso 1

curl https://start.spring.io/starter.zip `
-d bootVersion=3.1.1 `
-d groupId=com.apixcloud.app `
-d artifactId=user-admin-parent-m1-p2-start `
-d dependencies=web `
-d version=0.1.0-SNAPSHOT `
-d type=maven-project `
-d baseDir=user-admin-parent-m1-p2-start `
-o user-admin-parent-m1-p2-start.zip

Windows paso 2

Expand-Archive -Path user-admin-parent-m1-p2-start.zip -DestinationPath .\
```

Abriremos el proyecto en nuestro entorno de desarrollo integrado (IDE) y procederemos a modificar el archivo pom.xml mediante la adición de la siguiente línea de código XML:

```xml
<packaging>pom</packaging>
```

Proyecto **commons**

```
Mac o Linux

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

```
Windows. Paso 1

curl https://start.spring.io/starter.zip `
-d bootVersion=3.1.1 `
-d groupId=com.apixcloud.commons `
-d artifactId=commons-m1-p2-start `
-d dependencies=web,lombok,actuator `
-d version=0.1.0-SNAPSHOT `
-d type=maven-project `
-d baseDir=commons `
-o commons.zip

Windows. Paso 2

Expand-Archive -Path commons.zip -DestinationPath .\
```

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

Ejecutar el comando para construir nuestro proyecto:

```
mvn clean install
```

Proyecto **users-service**

```
Mac o Linux

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

```
Windows. Paso 1

curl https://start.spring.io/starter.zip `
-d bootVersion=3.1.1 `
-d groupId=com.apixcloud.users `
-d artifactId=user-service-m1-p3-start `
-d dependencies=web,devtools,actuator `
-d version=0.1.0-SNAPSHOT `
-d type=maven-project `
-d baseDir=users-service `
-o users-service.zip

Windows. Paso 2

Expand-Archive -Path users-service.zip -DestinationPath .\
```

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



------



### Recursos adicionales

##### Maven “finalName”

https://maven.apache.org/plugins/maven-jar-plugin/jar-mojo.html#finalName

##### Semántica de versionado

https://semver.org/













# Module 1 -  This is the codebase for Module 1

For more details, check the source code.

Notion Link: https://www.notion.so/Lecci-n-Manejo-de-excepciones-y-c-digos-de-estado-HTTP-2079f23208044dcda04aaa4060d06918?pvs=4
