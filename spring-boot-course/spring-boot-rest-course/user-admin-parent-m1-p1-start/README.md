

# Módulo 1 - Práctica 1 - Proyecto Multi-Module con Maven.

### Antes de comenzar

Asegurarnos de tener Maven instalado:

```
mvn --version
```

### Paso 1. Creación y configuración de proyectos

Proyecto **user-admin-parent-m1-p1-start**

En este proyecto tendremos todas las configuraciones y dependencias que queremos que los módulos hijos hereden. Ejecutaremos la siguiente línea de comando para que se pueda generar el proyecto Maven.

```
Mac/Linux

mvn archetype:generate -DgroupId=com.apixcloud.app -DartifactId=user-admin-parent-m1-p1-start -DarchetypeVersion=1.0 -DinteractiveMode=false
```

```
Windows 

mvn archetype:generate "-DgroupId=com.apixcloud.app" "-DartifactId=user-admin-parent-m1-p1-start" "-DarchetypeVersion=1.0" "-DinteractiveMode=false"
```

Vamos a posicionarnos en la carpeta dentro del proyecto donde se encuentra el archivo pom.xml.

```
cd user-admin-parent-m1-p1
```

Abriremos el proyecto en nuestro entorno de desarrollo integrado (IDE) Visual Studio Code y procederemos a actualizar el archivo pom.xml con las siguientes modificaciones:

Primeramente agregaremos la siguiente línea:

```xml
<packaging>pom</packaging>
```

De igual manera comentaremos la línea:

```xml
<!--packaging>jar</packaging-->
```

Opcionalmente y como una buena práctica se pueden agregar los siguiente bloques de información a manera de descripción para el proyecto:

```xml
<licenses>
	<license>
		<name>MIT License</name>
		<url>http://www.opensource.org/licenses/mit-license.php</url>
		<distribution>repo</distribution>
	</license>
</licenses>

<developers>
    <developer>
        <email>yanezv.ricardo@gmail.com</email>
        <name>Ricardo Yanez</name>
        <url>https://github.com/ryanezv</url>
        <id>ryanezv</id>
    </developer>
</developers>
```

Estas serán todas las configuraciones para el proyecto padre en el archivo pom.xml.

Proyecto **commons**

En este momento nos encontramos dentro de la carpeta del proyecto padre **user-admin-parent-m1-p1** en esta misma carpeta, vamos a crear el proyecto **commons** con la siguiente línea de código:

```
Mac/Linux

mvn archetype:generate -DgroupId=com.apixcloud.commons -DartifactId=commons -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.0 -DinteractiveMode=false
```

```
Windows 

mvn archetype:generate "-DgroupId=com.apixcloud.commons" "-DartifactId=commons" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DarchetypeVersion=1.0" "-DinteractiveMode=false"
```

Proyecto **users-service**

```
Mac/Linux

mvn archetype:generate -DgroupId=com.apixcloud.commons -DartifactId=commons -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.0 -DinteractiveMode=false
```

```
Windows 

mvn archetype:generate "-DgroupId=com.apixcloud.users" "-DartifactId=users-service" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DarchetypeVersion=1.0" "-DinteractiveMode=false"
```

Proyecto **web-app**

```
Mac/Linux

mvn archetype:generate -DgroupId=com.apixcloud.commons -DartifactId=commons -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.0 -DinteractiveMode=false
```

```
Windows 

mvn archetype:generate "-DgroupId=com.apixcloud.webapp" "-DartifactId=web-app" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DarchetypeVersion=1.0" "-DinteractiveMode=false"
```

Con los comandos ejecutados anteriormente para crear los proyectos **commons**, **users-project** y **web-app**, Automáticamente, Maven busca el proyecto padre y realiza la modificación de la configuración en el archivo pom.xml.

Si abres el archivo pom.xml del proyecto **user-admin-parent-m1-p1-start***, podrás ver los módulos generados de sus proyectos hijos:

 ```xml
 <modules>
     <module>commons</module>
     <module>users-service</module>
     <module>web-app</module>
 </modules>
 ```

Ahora bien, si accedes a los proyectos hijos, por ejemplo a **commons**:

```
cd commons
```

Podremos observar la configuración del proyecto padre que se agregó automáticamente al crear a los hijos:

```xml
<parent>
	<groupId>com.apixcloud.app</groupId>
    <artifactId>user-admin-parent-m1-p1-start</artifactId>
    <version>1.0-SNAPSHOT</version>
</parent>
```

### Paso 2. Construcción y empaquetado del proyecto

Ahora, vamos a construir el paquete completo en la carpeta del proyecto padre, de esta manera se creará el archivo jar que podemos importar en los proyectos donde lo necesitemos. Dentro de la carpeta del proyecto padre **user-admin-parent-m1-p1**:

```
Mac/Linux
mvn package -Dmaven.test.skip=true

Windows 
mvn package "-Dmaven.test.skip=true"
```

Una vez ejecutados los comandos anteriores, podemos observar en cada uno de los proyectos, los archivos .jar generados por Maven.

Nosotros podemos cambiar la forma en que Maven empaqueta nuestro proyecto, por ejemplo, podemos indicarle que el empaquetado sea un WAR y no un archivo JAR, vamos a ver un ejemplo para el proyecto **web-app**:

Dentro de la carpeta del proyecto **web-app**, en el archivo pom.xml, vamos a agregar lo siguiente:

```xml
<packaging>war</packaging>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.4.0</version>
            <configuration>
               <failOnMissingWebXml>false</failOnMissingWebXml>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Ahora bien, una vez terminado de editar el pom.xml, nos posicionamos en la carpeta root del proyecto **user-admin-parent-m1-p1** y vamos a correr la siguiente línea de comando:

```
mvn clean install
```

Podremos ver como el proyecto **web-app** se empaquete en un archivo WAR.

### Paso 3. Codificación

En el proyecto **user-admin-parent** en el archivo pom.xml vamos a agregar el siguiente bloque:

```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>3.1.1</version>
  <relativePath/> <!-- lookup parent from repository -->
</parent>

<properties>
	<!-- non-dependencies -->
	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	<java.version>17</java.version>
</properties>
```

Dentro del proyecto **users-service** usaremos el proyecto **commons** como módulo. Para ello, agregaremos en el archivo pom.xml del proyecto **users-service** la siguiente dependencia:

```jsx
<dependency>
    <groupId>com.apixcloud.commons</groupId>
    <artifactId>commons</artifactId>
    <version>0.1.0-SNAPSHOT</version>
</dependency>
```

En el proyecto **users-service** crearemos un controlador como clase java en el paquete **com.apixcloud.users**:

```java
package com.apixcloud.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.apixcloud.users")
@RequestMapping("/api")
@RestController
public class ControllerUsers {

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static void main(String[] args) {
        SpringApplication.run(ControllerUsers.class, args);
    }
}
```

En el proyecto **commons** crearemos la clase **Utils**  en el paquete **com.apixcloud.commons.utils**:

```java
package com.apixcloud.commons.utils;

public class MappingsUtil {
    
    public final static String basePath = "/api";
    public final static String health = "/health";
}
```



------



### Recursos adicionales

##### Maven Quickstart:

https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

##### Maven guide:

https://books.sonatype.com/mvnref-book/reference/index.html

##### Advance multi-module with Spring Boot:

https://github.com/spring-projects/spring-boot













# Module 1 -  This is the codebase for Module 1

For more details, check the source code.

Notion Link: https://www.notion.so/Lecci-n-Proyecto-Multi-Module-con-Maven-d85b06d3a7094589913ccf95428ec700?pvs=4
