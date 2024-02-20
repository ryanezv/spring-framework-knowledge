# **MANUAL DE INSTALACIÓN DE HERRAMIENTAS**

A continuación te mostraremos las herramientas fundamentales que te permitirán desarrollar, desplegar y mantener aplicacionesbasadas en Spring Boot a lo largo del curso. Éstas son herramientas clave que utilizarás a lo largo de este viaje de aprendizaje.

Antes de comenzar, asegúrate de conocer la arquitectura y la versión de tu sistema operativo. Puedes verificaresta información en la configuración del sistema.

## **MAC**

### **JDK JAVA**

Comenzamos con el más importante que es el Kit de Desarrollo de Software (SDK por sus siglas en inglés) para java, el JDK es esencial para el desarrollo java. Asegúrate de seguir cada paso cuidadosamente.

##### **Paso 1: Descargar el JDK**

1. Accede al sitio web oficial de Oracle: https://www.oracle.com/mx/java/technologies/downloads/.

   ![Texto Alternativo](img/mac/jdk/img0.png)

2. En la sección "JDK Development Kit 17.0.9 downloads", te da las siguientes opciones:

   ![Texto Alternativo](img/mac/jdk/img1.png)

3. Vamos a seleccionar x64 Compressed Archive.

   ![Texto Alternativo](img/mac/jdk/img2.png)

4. Acepta los términos de la licencia y descarga el instalador.

##### **Paso 2: Extraer el Archivo tar.gz**

1. Abre la Terminal en tu Mac. Puedes encontrarla en la carpeta de Aplicaciones bajo la carpeta Utilidades, o usar Spotlight (Cmd + Espacio y luego escribe "Terminal").

   ![Texto Alternativo](img/mac/jdk/img3.png)

2. Navega al directorio donde descargaste el archivo tar.gz. Puedes usar el comando cd para cambiar de directorio.

   ![Texto Alternativo](img/mac/jdk/img4.png)

3. Ejecuta el siguiente comando para extraer el contenido del archivo tar.gz: ` tar -xvf [nombre_archivo]` . 

   - `-x`: Esta opción indica a `tar` que queremos extraer archivos del archivo .tar.
   - `-v`: Esta opción activa el modo "verbose" (detallado), lo que significa que `tar` mostrará información detallada sobre los archivos que está extrayendo mientras trabaja.
   - `-f`: Esta opción se utiliza para especificar el nombre del archivo tar del cual queremos extraer los archivos.

   ![Texto Alternativo](img/mac/jdk/img5.png)

   ![Texto Alternativo](img/mac/jdk/img6.png)

##### **Paso 3: Configurar las Variables de Entorno**

1. Abre el archivo .zshrc o .bash_profile en un editor de texto (por ejemplo, usando nano o vim) ` nano ~/.zshrc`.

2. Agrega las siguientes líneas al final del archivo para configurar las variables de entorno:

   ` export JAVA_HOME=/ruta/del/directorio/donde/extraiste/jdk17`

   ` export PATH=$JAVA_HOME/bin:$PATH`

   ![Texto Alternativo](img/mac/jdk/img7.png)

3. Guarda los cambios y cierra el editor.

4. Ejecuta el siguiente comando para aplicar los cambios: ` source ~/.zshrc` .

##### **Paso 4: Verificar la Instalación**

1. En la Terminal, ejecuta el siguiente comando para verificar que el JDK se ha instalado correctamente: ` java --version`

2. Deberías ver información sobre la versión de Java instalada, que debería ser la versión 17.

   ![Texto Alternativo](img/mac/jdk/img8.png)

¡Felicidades! Has instalado con éxito el JDK de Java en tu sistema.

### **SPRING TOOLS SUITE**

Spring Tool Suite (STS), una herramienta integral diseñada para facilitar el desarrollo de aplicaciones basadas en el framework Spring y puedes configurarlo en tu IDE favorito (Eclipse, Visual Studio Code, o Theia). De igual manera existe el paquete "Eclipse (Bundle)" que es una distribución especializada de Eclipse que incluye por default el Spring Tools Suite, lo que evita la necesidad de configurar Eclipse manualmente con los complementos y herramientas necesarios para trabajar con proyectos Spring.

Para el curso, procederemos con la instalaciónde Visual Studio Code, seguido por la incorporación del Spring Tool Suite (STS) como extensión en VS Code. 

#### Visual Studio Code + Spring Tool Suite(STS)

##### **Paso 1: Instalar Visual Studio Code**

1. Accede al sitio oficial de Visual Studio Code: https://code.visualstudio.com/.

2. Haz clic en el botón de descarga Download Mac Universal.

   ![Texto Alternativo](img/mac/vsc/img1.png)

3. Se descargará un archivo .zip que contiene la aplicación.

   **![Texto Alternativo](img/mac/vsc/img2.png)**

##### **Paso 2: Instalar Visual Studio Code**

1. Abre el Finder y navega a la carpeta donde se descargó el archivo .zip. Normalmente, esto será la carpeta "Descargas" a menos que hayas especificado otra ubicación.

   ![Texto Alternativo](img/mac/vsc/img3.png)

2. Descomprime el archivo .zip. 

3. Localiza la aplicación "Visual Studio Code" con el ícono de VS Code.

4. Arrastra la aplicación a la carpeta "Aplicaciones" para instalar Visual Studio Code en tu sistema.

   ![Texto Alternativo](img/mac/vsc/img4.png)

##### **Paso 3: Abrir Visual Studio Code**

1. Abre el Finder y escribe Visual Studio Code.
   
   **![Texto Alternativo](img/mac/vsc/img5.png)**

2. Haz clic sobre la aplicación para abrirla.

   ![Texto Alternativo](img/mac/vsc/img6.png)

##### **Paso 2: Instalar la Extensión de Spring Boot en Visual Studio Code**

1. En VS Code, ve a la pestaña de "Extensions" (icono de cuatro cuadrados en la barra lateral izquierda) o presiona `Cmd + Shift + X`.

2. En la barra de búsqueda,escribe"Spring Boot Extension Pack".

   **![Texto Alternativo](img/mac/vsc/img7.png)**

3. Encuentra la extensión proporcionada por VMware y haz clic en "Install" para instalar el paquete de extensiones.

   **![Texto Alternativo](img/mac/vsc/img8.png)**

4. Después de la instalación, es posible que se te pida que reinicies VS Code. Asegúrate de guardar cualquier trabajo antes de hacerlo.

##### **Paso 3: Configurar la Extensión de Spring Boot**

1. Una vez reiniciado VS Code, en la barra de búsqueda vas a escribir `>Spring Initializr` y deberás poder visualizar esas opciones.

   **![Texto Alternativo](img/mac/vsc/img9.png)**

2. Con esto ya tenemos configurada la extensión para comenzar a editar proyectos Spring Boot en Visual Studio Code.

¡Felicidades! Has instalado Visual Studio Code en tu macOS. Ahora estás listo para comenzar a desarrollar proyectos utilizando este poderoso editor de código fuente.

### **PostgreSQL**

Este manual te guiará a través del proceso de instalación de PostgreSQL, un potente sistema de gestión de bases de datos relacionales, en tu entorno macOS. Asegúrate de seguir cada paso cuidadosamente para lograr una instalación exitosa.

##### **Paso 1: Descargar PostgreSQL**

1. Abre tu navegador web y dirígete al sitio oficial de PostgreSQL en https://www.postgresql.org/download/macosx/.

   ![Texto Alternativo](img/mac/postgresql/img1.png)

2. Selecciona la versión más reciente de PostgreSQL para macOS.

   ![Texto Alternativo](img/mac/postgresql/img2.png)

3. Una vez seleccionada, haz clic en el enlace de descarga correspondiente. Esto descargará un archivo .dmg que contiene el instalador de PostgreSQL.

   ![Texto Alternativo](img/mac/postgresql/img3.png)

##### **Paso 2: Instalar PostgreSQL**

1. Navega a la carpeta donde se descargó el archivo .dmg (generalmente la carpeta "Descargas").

2. Haz doble clic en el archivo .dmg descargado. Esto montará el disco de instalación de PostgreSQL.

   ![Texto Alternativo](img/mac/postgresql/img4.png)

3. Abre el disco y ejecuta el archivo de instalación. Serás guiado a través de un asistente de instalación. Da los permisos pertinentes para iniciar con la instlación.

   ![Texto Alternativo](img/mac/postgresql/img5.png)

   ![Texto Alternativo](img/mac/postgresql/img6.png)

4. Se iniciará el asistente de instalación.

   ![Texto Alternativo](img/mac/postgresql/img7.png)

5. Se te pedirá que elijas una ubicación para la instalación.

   ![Texto Alternativo](img/mac/postgresql/img8.png)

6. En la sección de los componentes que deseas instalar se encuentran las herramientas de línea de comandos y las bibliotecas de desarrollo, por lo seleccionaremos todas:

   1. PostgreSQL Server: Es el motor de la base de datos PostgreSQL. Incluye el servidor que gestiona las conexiones de los clientes, ejecuta las consultas SQL y administra el almacenamiento de los datos. Este componente es esencial y siempre se instala, ya que también incluye bibliotecas y herramientas adicionales necesarias para el desarrollo de aplicaciones que utilizan PostgreSQL.

   2. Command Line Tools: Herramientas de línea de comandosque facilitan la administración y el uso de PostgreSQL. Incluye utilidadescomo psql para interactuar directamente con la base de datos desde la línea de comandos. Útil para administradores y desarrolladores que prefieren trabajardesdela terminal.

   3. pgAdmin(o Herramienta de Administración Gráfica):Una interfaz gráfica de usuario para administrar y visualizar bases de datos PostgreSQL. Permite realizar tareas administrativas, ejecutar consultas y gestionar objetos de la base de datos de manera visual. Recomendado para aquellos que prefieren una interfaz gráfica para administrar bases de datos.

   4. Stack Builder: Una herramienta que permite agregar extensiones y complementos a PostgreSQL. Puedes usar Stack Builder para instalar herramientas adicionales, controladores de conexión y otros complementos que puedan ser necesarios. Las herramientas para el curso lasveremos más adelanteen el punto 10.

7. 

   ![Texto Alternativo](img/mac/postgresql/img9.png)

8. Elige la ubicación de instalación de la data y haz clic en `Siguiente`.

   ![Texto Alternativo](img/mac/postgresql/img10.png)

9. Establece una contraseña para el super usuario (postgres). Asegúrate de recordar esta contraseña, ya que la necesitarás más adelante. 

   ![Texto Alternativo](img/mac/postgresql/img11.png)

10. Configura el puerto de escucha. Deja el valor predeterminado (5433) a menos que haya conflictos con otros servicios.

    ![Texto Alternativo](img/mac/postgresql/img12.png)

11. Selecciona la configuración regional a ser usada, en nuestro caso dejaremos la Región por defecto.

    ![Texto Alternativo](img/mac/postgresql/img13.png)

12. A continuaciónse muestra un resumen de instalación.

    ![Texto Alternativo](img/mac/postgresql/img14.png)

13.  A continuación se muestra un mensaje donde ya se encuentra listo para instalar, da clic en "Siguiente" y comienza la instalación.

    ![Texto Alternativo](img/mac/postgresql/img15.png)

    ![Texto Alternativo](img/mac/postgresql/img16.png)

14. Al completar la instalación, te muestra una leyenda para inicializar la configuración de Stack Builder, la mantienes seleccionada y das clic en `Terminar`.

    ![Texto Alternativo](img/mac/postgresql/img17.png)

15. Te pedirá nuevamente los permisos para la instalación.

    ![Texto Alternativo](img/mac/postgresql/img18.png)

16. Se abrirá la ventana de configuración de Stack Builder, seleccionamos la versión y el puerto que instalamos y damos clicen `Siguiente`.

    ![Texto Alternativo](img/mac/postgresql/img19.png)

17. En la siguiente pantalla seleccionaremos la opción `pgJDBC v42.6.0-1` que permite la conectividad Java a PostgreSQL mediante JDBC.

    ![Texto Alternativo](img/mac/postgresql/img20.png)

    ![Texto Alternativo](img/mac/postgresql/img21.png)

18. Seleccionamos la ruta de descarga y damos clicen `Next` y se abrirá otra ventana para permitir saltarte la instalación, dejamos sin check la opción Skip intallation y damos clic en `Next`.

    ![Texto Alternativo](img/mac/postgresql/img22.png)

    ![Texto Alternativo](img/mac/postgresql/img23.png)

19. Se inicializa el instalador del JDBC.

    ![Texto Alternativo](img/mac/postgresql/img24.png)

20. Seleccionamos la ruta de instalación damos clic en `Next`.

    ![Texto Alternativo](img/mac/postgresql/img25.png)

21. Confirmamos la instalación dando clic en `Next`.

    ![Texto Alternativo](img/mac/postgresql/img26.png)

22. Finalizamos con éxito la instalación.

    ![Texto Alternativo](img/mac/postgresql/img27.png)

    ![Texto Alternativo](img/mac/postgresql/img28.png)

**Paso 3: Configurar las Variables de Entorno**

1. Abre el archivo .zshrc o .bash_profile en un editor de texto (por ejemplo, usando nano o vim)                   ` nano ~/.zshrc`.

   ![Texto Alternativo](img/mac/postgresql/img29.png)

2. Agrega las siguientes líneas para incluir las herramientas de PostgreSQL en tu PATH 

   ` export PATH=$PATH:[ruta_tu_instalacion]/bin`

   ![Texto Alternativo](img/mac/postgresql/img32.png)

3. Guarda los cambios y recarga la configuración del shell.

##### **Paso 4: Verificar instalación**

1. Abre la Terminal en tu macOS y ejecuta el siguiente comando para conectarse a PostgreSQL: 

   `psql -U postgres -p 5433` e ingresarás tu contraseña (Paso 2-punto 5).

   ![Texto Alternativo](img/mac/postgresql/img33.png)

2. Si puedes iniciar sesión sin errores, la instalación fue exitosa.

   ![Texto Alternativo](img/mac/postgresql/img34.png)

¡Enhorabuena! Has completado con éxito la instalación de PostgreSQL. Este logro marca un paso adicional hacia la configuración completa de nuestro entorno para comenzar el curso. ¡Estamos listos para avanzar!

### **Postman**

Postman es una plataforma colaborativa que proporciona un entorno completo para el desarrollo y pruebade APIs. Esta herramientanos permite crear, compartir, probar y documentar microservicios de manera eficiente.

##### **Paso 1: Descargar Postman**

1. Abre tu navegador web y visita el sitio oficial de Postman en https://www.postman.com/downloads/.

2. Haz clic en el botón que corresponda al procesador de tu equipo de cómputo.

   ![Texto Alternativo](img/mac/postman/img1.png)

3. Se descargará un archivo comprimido (generalmente un archivo .zip).

##### **Paso 2: Instalar Postman**

1. Navega a la carpeta donde se descargó el archivo .zip (generalmente la carpeta "Descargas").

   ![Texto Alternativo](img/mac/postman/img3.png)

2. Descomprime el archivo zip. 

3. Localiza la aplicación "Postman" con el ícono de Postman.

   ![Texto Alternativo](img/mac/postman/img4.png)

4. Arrastra la aplicación a la carpeta "Aplicaciones" para completar la instalación.

   ![Texto Alternativo](img/mac/postman/img5.png)

##### **Paso 3: Iniciar Postman**

1. Abre el Finder y escribe Postman y autoriza su ejecución.

   ![Texto Alternativo](img/mac/postman/img6.png)

   ![Texto Alternativo](img/mac/postman/img7.png)
2. En la primera ejecución, Postman te pedirá que inicies sesión o crees una cuenta. Puedes optar por hacerlo o simplemente cerrar la ventana para acceder a Postman sin iniciar sesión.

   ![Texto Alternativo](img/mac/postman/img8.png)

¡Felicidades! Has instalado Postman con éxito. 

### **cURL**

cURL es una herramienta de línea de comandos que permite transferir datos utilizando diversos protocolos, como HTTP, HTTPS, FTP, entre otros.

##### **Paso 1: Instalar Homebrew (si no está instalado) **

1. Verifica si Homebrew está instalado ejecutando el siguiente comando: `brew --version`. 

   ![Texto Alternativo](img/mac/curl/img6.png)

2. Si Homebrew no está instalado, instálalo con el siguiente comando: `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`.

3. Sigue las instrucciones que aparecerán durante la instalación.


##### **Paso 2: **Instalar cURL

1. Después de instalar Homebrew, puedes instalar cURL con el siguiente comando: 

   `brew install curl`.

   ![Texto Alternativo](img/mac/curl/img7.png)

   ![Texto Alternativo](img/mac/curl/img2.png)

   ![Texto Alternativo](img/mac/curl/img3.png)

**Paso 3: Verificar la Instalación**

1. Verifica que cURL se haya instalado correctamente ejecutando: `curl --version`.

2. Deberías ver la información de la versión de cURL instalada.

   ![Texto Alternativo](img/mac/curl/img4.png)

¡Felicidades! Has instalado cURL en tu sistema. Ahora ya podemos utilizar esta potente herramienta para realizar transferencias de datos desde la línea de comandos a lo largo del curso.

### APACHE **MAVEN**

Apache Maven es una poderosa herramienta de gestión de proyectos y construcción de software utilizada principalmente para proyectos Java.

##### **Paso 1: **Descargar Apache Maven

1. Visita el sitio web oficial de Apache Maven (https://maven.apache.org/download.cgi) y descarga la última versión de Maven. 

   ![Texto Alternativo](img/mac/maven/img1.png)

2. Selecciona el archivo binario ZIP y descárgalo en tu Mac.

   ![Texto Alternativo](img/mac/maven/img2.png)

**Paso 2: Extraer el Archivo ZIP**

1. Una vez que se complete la descarga, abre la Terminal y navega hasta el directorio donde se descargó el archivo ZIP de Maven. 

2. Utiliza el siguiente comando para extraer el archivo ZIP: `unzip apache-maven-3.9.6-bin.zip`

   ![Texto Alternativo](img/mac/maven/img3.png)

3. Reemplaza "apache-maven-3.9.6-bin.zip" con el nombre del archivo ZIP que descargaste y la versión específica de Maven que estás instalando..

**Paso 3: Mover Maven a la Carpeta de Aplicaciones**

1. Después de extraer el archivo ZIP, tendrás una carpeta llamada "apache-maven-3.9.6". 

   ![Texto Alternativo](img/mac/maven/img4.png)

2. Mueve esta carpeta a la carpeta de Aplicaciones usando el siguiente comando: 

   `sudo mv apache-maven-3.9.6 /Applications`

   ![Texto Alternativo](img/mac/maven/img6.png)

3. Se te pedirá ingresar tu contraseña de administrador.

   ![Texto Alternativo](img/mac/maven/img7.png)

**Paso 4: Configurar Variables de Entorno**

1. Abre el archivo ".zshrc" en tu editor de texto favorito. Puedes usar Nano con el siguiente comando:

   `nano ~/.zshrc`

   ![Texto Alternativo](img/mac/maven/img8.png)

   ![Texto Alternativo](img/mac/maven/img9.png)

2. Agrega las siguientes líneas al final del archivo:

   `export M2_HOME=/Applications/apache-maven-3.9.6`

   `export PATH=$PATH:$M2_HOME/bin`

   ![Texto Alternativo](img/mac/maven/img10.png)

3. Guarda el archivo y ciérralo.

4. Para aplicar los cambios realizados en las variables de entorno, ejecuta el siguiente comando en la Terminal: `source ~/.zshrc`

   ![Texto Alternativo](img/mac/maven/img11.png)

5. Esto recargará el archivo de perfil y aplicará los cambios.

**Paso 5: Verificar la Instalación**

1. Para verificar que Maven se haya instalado correctamente, ejecuta el siguiente comando en la Terminal: `mvn -v`.

2. Deberías ver información sobre la versión de Maven instalada.

   ![Texto Alternativo](img/mac/maven/img12.png)

¡Felicidades! Has instalado Apache Maven en tu sistema. Ahora podremos comenzar a utilizar Maven para gestionar los proyectos del curso de manera eficiente.

### **OPEN SSL**

OpenSSL es una herramienta de código abierto que se utiliza para implementar protocolos de seguridad SSL/TLS en aplicaciones web y de red.

##### **Paso 1: Instalar Homebrew (si no está instalado) **

1. Verifica si Homebrew está instalado ejecutando el siguiente comando: `brew --version`. 

   ![Texto Alternativo](img/mac/curl/img6.png)

2. Si Homebrew no está instalado, instálalo con el siguiente comando: `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`.

3. Sigue las instrucciones que aparecerán durante la instalación.

##### **Paso 2: Instalar OpenSSL **

1. Una vez que Homebrew esté instalado y actualizado, puedes instalar OpenSSL fácilmente con el siguiente comando en la Terminal: `brew install openssl`. 

   ![Texto Alternativo](img/mac/openssl/img2.png)

##### **Paso 3: Verificar la Instalación**

1. Para verificar que OpenSSL se haya instalado correctamente, ejecuta el siguiente comando en la Terminal: `openssl -version`. 

2. Deberías ver información sobre la versión de OpenSSL instalada en tu sistema.

   ![Texto Alternativo](img/mac/openssl/img1.png)

¡Felicidades! Has instalado OpenSSL correctamente en tu Mac. Ahora puedes utilizar OpenSSL para implementar protocolos de seguridad SSL/TLS en tus aplicaciones web y de red.
