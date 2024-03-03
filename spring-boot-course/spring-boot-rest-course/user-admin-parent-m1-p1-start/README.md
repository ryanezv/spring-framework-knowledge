# Módulo 1 - Práctica 1 - Proyecto Multi-Module con Maven.

### Antes de comenzar

Asegurarnos de tener Maven instalado:

```
mvn --version
```

### Paso 1. Creación y configuración de proyectos

Proyecto **user-admin-parent-m1-p1-start**

En este proyecto tendremos todas las configuraciones y dependencias que queremos que los módulos hijos herenden. Ejecutaremos la siguiente línea de comando para que se pueda generar el proyecto Maven.

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

Abriremos el proyecto en nuestro entorno de desarrollo integrado (IDE) y procederemos a modificar el archivo pom.xml mediante la adición de la siguiente línea de código XML.

```xml
<packaging>pom</packaging>
```

De igual manera comentaremos la línea de comando.

```xml
<!--packaging>jar</packaging-->
```



------



### Recursos adicionales

##### M

https

##### Sem

http













# Module 1 -  This is the codebase for Module 1

For more details, check the source code.

Notion Link: https://www.notion.so/Lecci-n-Proyecto-Multi-Module-con-Maven-d85b06d3a7094589913ccf95428ec700?pvs=4
