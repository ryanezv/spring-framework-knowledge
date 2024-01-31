# **MANUAL DE INSTALACIÓN DE HERRAMIENTAS**

A continuación te mostraremos las herramientas fundamentales que te permitirán desarrollar, desplegar y mantener aplicacionesbasadas en Spring Boot a lo largo del curso. Éstas son herramientas clave que utilizarás a lo largo de este viaje de aprendizaje.

Antes de comenzar, asegúrate de conocer la arquitectura y la versión de tu sistema operativo. Puedes verificaresta información en la configuración del sistema.

## **WINDOWS**

### **JDK JAVA**

Comenzamos con el más importante que es el Kit de Desarrollode Software (SDK por sus siglas en inglés) para java, el JDK es esencial para el desarrollo java. Asegúrate de seguir cada paso cuidadosamente.

##### **Paso 1: Descargar el JDK**

1. Accede al sitio web oficial de Oracle: https://www.oracle.com/mx/java/technologies/downloads/.

2. En la sección "JDK DevelopmentKit 17.0.9 downloads", te da 3 opciones:
   
   **![](https://lh7-us.googleusercontent.com/8_qpVv-6mqAgUidRVF_gXccorC6rBgmEKXaF1GBzPfI8n4RAASm764SjjaaDNISZ9vtdouuedTdm8FPnSkLftL1fA0WTrUoG6_xXqJVuZW19ftcsHaFRoCaMKFZQ8_MTbPILX__Mhd7B8UoT-9Vq2sE)**

3. Vamos a seleccionarx64 MSI Installer.

4. Acepta los términos de la licencia y descarga el instalador.

##### **Paso 2: Instalar el JDK**

1. Ejecuta el instaladordescargado.

2. Una vez termine la descarga del archivo .msi debes dar doble clic en dicho archivo y aparecerá el instaladorde nuestra OpenJDK:
   
   **![](https://lh7-us.googleusercontent.com/ME-iptkTwZmRmolOyrV8rYmeNuvWny7vaqK6jwNd178lbubGvWpQaaE2wvbHeRx5geFfiKXWndYRL90qTz4ktIrQ5fcMREnRPusYTSnr9mdxft07OP2mx-WOyHetC1A-vP882xoaWZucOA6tw1ZLv1o)**

3. Durante la instalación, se te pedirá que elijas la ubicación del directorio de instalación. Anota esta ubicación ya que la necesitarás más adelante.

4. Completa el proceso de instalación.

##### **Paso 3: Configurar las Variables de Entorno en Windows**

1. Abre el Panel de Control y busca "Variables de entorno" en la barra de búsqueda.
   
   **![](https://lh7-us.googleusercontent.com/oUYyDNbPj5MwV1ETvTDSiHKW2Aa2gMk7skcggdyKALXQld9kpn5nPJdGdvCSn9ORqyG6oTr0v9R6vxB0Oq_Bz8aa_wf7FATHdtu9YxfFbtkOrMX-8KZiS01iin6baNvOT618ap9vime85xgFqPP7X1A)**

2. Selecciona "Editar las variables de entorno del sistema".

3. Selecciona"Variables de entorno".
   
   **![](https://lh7-us.googleusercontent.com/ELdbyWk9ZkT_3_QKtWs4n3VUrshPA1WwXh3OdEnTTaLAFIu-u0_9AXf8f0ew0dwkEqhCvTS5UgwFvy65Ve1bMJQzWyML7jRw_jtSRVOWaKioF290LRd3t6n2zZ7S0RtH_uClLIAgxHnU-ReaWBSTAEE)**

4. Haz clic en Nueva.
   
   **![](https://lh7-us.googleusercontent.com/Lo5T2Fcgj_zPIkBDHAS5mJq8sCU5enwXMLVsYae8eYYfHzKlMbe7y7AUl2JEcXs55BKKF72FHqpFsxjgWMT5hgFb4hjSlUwbe8yyhWcrO-PnDQQHxsLFWK7Fkzpn1q1uiwhSBqiByMnJ3-QODKzku-c)**

5. Ingresa "JAVA_HOME" como nombre de la variable y la ruta de instalación del JDK como valor. Por ejemplo, C:\Program Files\Java\jdk-17 (Es la ruta donde instalamosen el punto 3).
   
   **![](https://lh7-us.googleusercontent.com/tacw-1vFLQ5Gz8NYwJfR9mfC7aX5B1nP1Ic1EnD2ZGvUYiVg4dib8PS6DcTGUbf4o2QxtFC8hIipIiiFVPZ4U8VtK7a6e0p1FdhZYG4yemxc02wcPjrSB7GMxBJLfwhpEeb8AbcTrsDbqV3Rjz8LdTY)**

6. Da clicken Aceptar.

7. Buscala variable"Path" en la listade variables del sistema y haz clicen "Editar".
   
   **![](https://lh7-us.googleusercontent.com/Y48SJLQvfqGpj17DyP3ZqUVOe4-84ABiFKpeSgmtD1Dq-JpX35C76eOC0byYNzV77dtR04tQiVOsKPRrpp8zXSGArKxyTncN9mX5g8kzDCamUfy26XTzAHdxqX-Ngz_vo9Q5efyy1tK9uFg3m5EgaPk)**

8. En la nueva ventanada click en Nuevo y agrega `%JAVA_HOME%\bin`.
   
   **![](https://lh7-us.googleusercontent.com/V5eyieE5tdIzwdhrp9pifR26U50dZT_xxF4H4Bkc27ZzZISAXtSyNPU4vXiV2ikYNYghFaEADjtM_bdKXc3pELadgRUqVbkk3v0n3QU3SRzAHOhZkBy13PMKzV_9t_UzAKqDifZpA1M-vNIafWroIFw)**

9. Asegúrate de guardar todos los cambios.

##### **Paso 4: Verificar la Instalación**

1. Abre la líneade comandos (cmd) y escribe `java -version`. Deberías ver la versión del JDK instalada.

2. También puedes escribir` javac -version` para verificar la instalación del compilador.
   
   **![](https://lh7-us.googleusercontent.com/o58S7EzqSHcsI2P0tK_e1tzBDtHMvSm61PloQNsRv5vX2fJ_ZLC9NF5jtdRGVX9JjvB9KSLMniY-2qrB48S6tvy8NmrtxaciIcobZg-3VTvXdfyEQxXMLMoIqR5hwfAUVy99LMSmS-SfHD_vI-z5EIQ)**

¡Felicidades! Has instalado con éxito el JDK de Java en tu sistema.

### **SPRING TOOLS SUITE**

Spring Tool Suite (STS), una herramienta integral diseñada para facilitar el desarrollo de aplicaciones basadas en el framework Spring y puedes configurarlo en tu IDE favorito (Eclipse, Visual Studio Code, o Theia). De igual manera existe el paquete "Eclipse (Bundle)" que es una distribución especializada de Eclipse que incluye por default el Spring Tools Suite, lo que evita la necesidad de configurar Eclipse manualmente con los complementos y herramientas necesarios para trabajar con proyectos Spring.

Para el curso, procederemos con la instalaciónde Visual Studio Code, seguido por la incorporación del Spring Tool Suite (STS) como extensión en VS Code. Además, te guiaremos en la instalación de Eclipse (Bundle). Cualquiera de estas opciones que elijas será óptima para el desarrollo delcurso.

#### VisualStudioCode + SpringToolSuite(STS)

##### **Paso 1: Instalar Visual Studio Code**

1. Accede al sitio oficial de VisualStudioCode: https://code.visualstudio.com/.

2. Haz clicen el botón "Download"para descargar el instalador de Windows.
   
   **![](https://lh7-us.googleusercontent.com/mJZSTnyAkHLsZqmPQLjtYshozkhKtDK4KhqHl_DeEb1--ywdrgmJmoeGnmtLAUvkbvir5z98YhvKkdy7tQHz4HK1HYg661LhMCBzIAyLyHla9E7Z6PP3rVEhw0mbwvOvTUOYpX3sTaxhw4VBNuS95Tk)**

3. Ejecuta el instalador descargado, (es posible que se tenga que ejecutar como administrador) y sigue las instrucciones del asistente de instalación.
   
   **![](https://lh7-us.googleusercontent.com/tnbzA0oNGyEJCn3EzBtZyg--U8B2e0s-vmwiXaRlvVSKnR0e0rez--T_7GvuhU2Mm0RE4LJxJwFUYL-bCYBRyUzg_UigfP9L6jF4gXoBFVdtHytldYDccffpTA-EN4f68uN3YOcyzQTXiofe8F7HmVs)**
   
   **![](https://lh7-us.googleusercontent.com/M_TJqVtVis9dRocSMU0Dq73IlzNYuJQqRYuPdSPKYOXCOCXaHNb9aUy8YJx3GK1LUbmJM3GSFANzrK9jZNOvpIM3c9m8TGGmpxNnQJ3jz6LNL11rnU-3WZMrcUlLDYzHHT_3kqeN5TFEO2X681sWuaQ)**
   
   **![](https://lh7-us.googleusercontent.com/yLYI0-VpKHZcoilSg6cSz3qWPX5zFys5hwLGs0YoQIbuJTGYLZmHZD7gLW9k8uU0z2K27COxe1BNrbApzGbnYmNgRXZDq34i9Dfy9p_wX7tpaFksW5XZdrDwYsWt0_Sd60lTm7z76bEvv8byUsejJVU)**
   
   **![](https://lh7-us.googleusercontent.com/pfICbuTnKNgoIJqwn9AhycBPwXI1XM3vFwp4ls4H8LUdyQpJxAYCHIsZmsLvrCY1gc5BTLUyo6rEtnTeJ9j_oMr7EFCDLK0rigd4v9RfyYBQgSwV63QNOxbQl-CIFwqg6iPewqfLHZpaBBrXk4QW6d0)**
   
   **![](https://lh7-us.googleusercontent.com/_-p3QXmDfBKi6xAAkIXJ3w5AK78R5V6kT-IbyArf6kjvHSis1RIZR4b1-CGXHEYupYT-hu3mNEWpwOW3uDuPkMfYgYGUDH6sKct1OiirJKwvOHVtwIz0LwapqtHPbdovt0yy4EwLTkFR3tb3wWj_6gI)**

4. Abre Visual Studio Code después de la instalación. ¡Felicidades, has instalado VS Code con éxito!

##### **Paso 2: Instalar la Extensión de Spring Boot en Visual Studio Code**

1. En VS Code, ve a la pestaña de "Extensions" (icono de cuatro cuadrados en la barra lateral izquierda) o presiona                    `Ctrl + Shift + X`.

2. En la barra de búsqueda,escribe"Spring Boot Extension Pack".
   
   **![](https://lh7-us.googleusercontent.com/Zp7AmmC-tMeii_HJZgiCtntuCbKTKV_8XnHvj08hOWUcLb9gMkargdbUBytFhVLXI34voewm_5pliTNs4E9brEVdg5-fJeVQXDCy-QWbE4JF1Wvf9iXuI-sNiP5gLh26YOSMmUgoH_8jPRrbb2xir3w)**

3. Encuentra la extensión proporcionada por VMware y haz clic en "Install" para instalar el paquete de extensiones.
   
   **![](https://lh7-us.googleusercontent.com/ssYq2jq2LhawugtEhmkG8Oa8xG-p6VDnU8eD4MUjlZ6Sj9xRo-PEfCuQ-va4ae8eg1zXB9OZVEk3itzOyp5Zt6orKiPZlKU1I1vMqofIZbV48hmsv0tFEu430wc_xa9lNTvwFvuBnOQ_hwVy-WkRvQ8)**

4. Después de la instalación, es posible que se te pida que reinicies VS Code. Asegúrate de guardar cualquier trabajo antes de hacerlo.

##### **Paso 3: Configurar la Extensión de Spring Boot**

1. Una vez reiniciado VS Code, en la barra de búsqueda vas a escribir `>Spring Initializr` y deberás poder visualizar esas opciones.
   
   **![](https://lh7-us.googleusercontent.com/hLaiVwU57Vf0psKR1GLPylmLj8d1v5Gz5plzrqJ2mit59rFHPJCAhhAtVwDZ4413xfqaRzKVr-XdvlpCUbYh5Z9UcVu_pZdHpquk4U3CHAZGkldKERANUaaWt6Jqc2GUYc0__2q5kYS2gQdUf-ilZ2Y)**

2. Con esto ya tenemos configurada la extensión para comenzar a editar proyectos Spring Boot en Visual Studio Code.

#### Eclipse(Bundle)

##### **Paso 1: Descargar STS**

3. Accede al sitio web oficial de Spring Tools: https://spring.io/tools/

4. En la sección `Spring Tools 4 for Eclipse` vamos a descargar `4.21.0 - WINDOWS x86_64`.
   
   **![](https://lh7-us.googleusercontent.com/oYcXl5TzjJZZ7IM9_pAsJ8GNwBQbFnwd0rkYE7tEBqMOpvalqJm0LHPeC4uOLAgCU4E5Oh4ldjFaP1ykaTmvn-kPExBx0X1CWmKo_Qi_IyIOKcpfA2tus0tTJh8z68yf41nc8D5iYqTm5hjKebFFu6Y)**

##### **Paso 2: Instalar STS**

1. Da doble clic en el archivo que se descargó y comenzará a descomprimir el contenido en una carpeta llamada `sts-4.21.0.RELEASE`.
   
   **![](https://lh7-us.googleusercontent.com/WVO7oAVdx5iTlA9ps4hmCz5hxzwOORftlkiZwJISO0Yn0GwbSTRQnvLkMK8OjEBGMQHSKfJv9ld4SbPW_9yY8VNxe6hqPEFIM2Q6803VHgiP4uReFp5GPpnAuEA_RHYK8JZyjLg1KqjIfYaUi-FuOHw)**
   
   **<img title="" src="https://lh7-us.googleusercontent.com/qltCWVyQSSgELAdmy_CqfXjBQwaUIo4PlDu_SuE-vOGRo2ltMXTfK0MWs5gSAhGDIfwSa-8A8xu9Yf3nD3jD3JXLqI7oXApC2GHEgljqUQcCR4ilu-WN-2g4jVejNuSoW4e_a6KrpiGUPXzWmeFfkHk" alt="" data-align="center" width="181">**

2. Para mantener una instalación de programas organizada, se recomienda trasladar la carpeta a la ubicación designada de programas instalados.

3. En la nueva ubicación abre la carpeta resultante y ejecutael archivo ejecutable `SpringToolSuite4.exe`.
   
   **![](https://lh7-us.googleusercontent.com/qKnVn4wraUkQ3rT8lcpcJzEBfK4USVY-64QllWYTrg4kbjlWJOOv9Fq3i2JCiVDdGlD4QwoX2KVnrMVEYf6DCQ2u4siGBAIM3E6kn1tT6Sq4ToF4b5NFlQR1WXpUgaxDuV31uiz1mFbOyWUnOr6u63k)**

4. STS iniciará y te pedirá que elijas un espacio de trabajo. Puedes seleccionarla ubicaciónpredeterminadao elegiruna nueva.
   
   **![](https://lh7-us.googleusercontent.com/kWI_tIT4M_JzXrEiTlT_KpFolR_s15CN10DU3rWHi-rQKdZGhy-oFgCRZBN_cmauM1HBfIdSz7Pljv1Tl-qk24C6XxcVInQh-ZtvzSU5jEsL3fKPRvrIo-q4ozngKPJsxd5qhEdZ_0UO_7ev_aE1v-U)**
   
   **![](https://lh7-us.googleusercontent.com/HMmA_EVxNuaHTWTRvhcGMJmyXGqNMSAe1yLMYZyLMAKIuXhpucsTAyS3u8_u4ZvGuJLn9DzWip4qb8hj3Y60DFKVl-VzuYWvv0Ip4nb2EY7lIefJAFmhEuklVe33re0gYDCJ8KKcjPAat2a5TNJfL4c)**

5. Haz clicen "Launch" para iniciarSTS.
   
   **![](https://lh7-us.googleusercontent.com/ih2ui-D-U5DaqhaIfO0MeWiVB11ku1gt7B4lPLgpSP9M4Vbo5Xk68sknC2ErzPBKsxsaYr521_370smJ2re1dVCufF8ngJjaNDwU7ijwwgZfPr9YNpLgT4PYCoorB4DlTKGsYX-h35s2fHymqduxHt4)**

¡Felicidades! Has instalado exitosamente Spring Tool Suite y está listo cualquiera de losdos IDEs que hayas seleccionadopara nuestro curso.

### **PostgreSQL**

PostgreSQL, un sistema de gestión de bases de datos relacional de código abierto. Sigue estos pasos para lograr una instalación exitosa.

##### **Paso 1: Descargar PostgreSQL**

1. Accede al sitio oficial de descargas de PostgreSQL: https://www.postgresql.org/download/.
   
   **![](https://lh7-us.googleusercontent.com/7bPt6xLyvCxltnjkBVIPXhcxL806nJk-f7VOmZjw5OidjWtblEvL_AaQiDxbaUpn2p8Svdh-Ujb96cSEMgis2pDgy-lStQ8tOgFJETwnLFtFnvwYVPOr1aisHEeJZQjevATdpKSjecEzXcmWiO_V8sM)**

2. Selecciona el sistema operativo Windows y da clic en `Download the installer`.
   
   **![](https://lh7-us.googleusercontent.com/hx6hslYv0G9I_8rIxOsiogwY3xeM08LKYEOU0v9dRiDnz23-q1FenA2PlGYEYyWRXQD0Fu7hOVQ7IqOziYR9LMd3EF3dU5qS6bczi8VPperUa2FV7byAUUo_85NTPI5HlTdsFlO_fiDgUeBNchj9VsE)**

3. Selecciona la versiónde Windows `(x86-64 ó x86-32)`.

4. Guarda el instalador en tu equipo.

##### **Paso 2: Instalar PostgreSQL**

1. Ejecuta el instalador descargado.
   
   **![](https://lh7-us.googleusercontent.com/fEVsNcP10zujJLbM5bOek89PuSvDB4gC7vXKoLxHAODnHq3HxoPJeUK_z7sTpuKRugPS_uycAMCDapLxVmNwhvEwumvY2IJs2qpJFkIEfgY0XQZfEV2u8Q6ILm-GMER42K1l5iJMW91CzGKb7YAYSqg)**

2. Elige la ubicaciónde instalación y haz clic en `Siguiente`.
   
   **![](https://lh7-us.googleusercontent.com/yVKYB_n94E7e10r9CMU8GQsLl7SH5wZg5pXoDmgtcb2ySmx_N6u8Jx50edqktUH0JBgPcka0-Px1NpEuvnaLXXsURQC_0vTnqFuBdqDlo99ChCfDM-xV8Xf0Ch0DmPsZcmocsos_5WIIxHnguygUySQ)**

3. En la sección de los componentes que deseas instalar se encuentran las herramientas de línea de comandos y las bibliotecas de desarrollo, por lo seleccionaremos todas:
   
   1. PostgreSQL Server: Es el motor de la basede datos PostgreSQL.Incluye el servidor que gestiona las conexiones de los clientes, ejecuta las consultas SQL y administra el almacenamiento de los datos. Este componente es esencial y siempre se instala, ya que también incluye bibliotecas y herramientas adicionales necesarias para el desarrollo de aplicacionesque utilizanPostgreSQL.
   
   2. Command Line Tools: Herramientas de línea de comandosque facilitan la administración y el uso de PostgreSQL. Incluye utilidadescomo psql para interactuar directamente con la base de datos desde la línea de comandos. Útil para administradores y desarrolladores que prefieren trabajardesdela terminal.
   
   3. pgAdmin(o Herramientade AdministraciónGráfica):Una interfaz gráfica de usuario para administrar y visualizar bases de datos PostgreSQL. Permite realizar tareas administrativas, ejecutar consultas y gestionar objetos de la base de datos de manera visual. Recomendado para aquellos que prefieren una interfaz gráfica para administrar bases de datos.
   
   4. Stack Builder: Una herramienta que permite agregar extensiones y complementos a PostgreSQL. Puedes usar Stack Builder para instalar herramientas adicionales, controladores de conexión y otros complementos que puedan ser necesarios. Las herramientas para el curso lasveremos más adelanteen el punto 10.
      
      **![](https://lh7-us.googleusercontent.com/rrcqTcX7uVD92MgK9hyzdvypXmWvqxVnRlzWB6_u4xDhPnK83TH9eOZJ0LZkUXjczNcGsbqUXcOWCW4PB02FbHEKHrszGKMfRrKF2GOsdhjdCjfAL-OCRxq1FSUgs85v9NuJkOQ-TcOjg-8hv_rxls4)**

4. Eligela ubicaciónde instalaciónde la data y haz clicen `Siguiente`.
   
   **![](https://lh7-us.googleusercontent.com/F9dTp98wG5ofb0FQnTAAH-F1gf94KMa7xkMi-ZPy1bQvptmdSxgki7uVWNn9tC0uZ0kBUIzO2KB856LokV7JOnG4wZarPHrBcD-lyQg7bp8iTQQ3aohhyt1yOqbeZ3YmJOaU4_TuziZnCcwJ6GCC8EI)**

5. Establece una contraseña para el superusuario (postgres). Asegúrate de recordar estacontraseña,ya que la necesitarás más adelante. 
   
   **![](https://lh7-us.googleusercontent.com/LABuAiXG3biXDBlIllZQkujYmxGgbKqzMd0bqw1lawLhufC4dZ7WGOvifMjQNjvC7aBNnxHXD4VLVjn5LcMif3eSFk_d-68PhHDZeeja63FFzv6G2aWeZ4avpPN7YVd3X-m3NC02z0dqww8dqcFPe-0)**

6. Configura el puerto de escucha. Deja el valor predeterminado (5433) a menos que haya conflictos con otros servicios.
   
   **![](https://lh7-us.googleusercontent.com/bMyD3eXgg0g_Uqs9ciXkKIot7qh73j6q8ZTnbdqcGhyLXTX_QG2ztb5Nu31XXNbNGMlSCxTl9SK1M9f_xOt_0N4313hrC2J__G_mgc7k14mK2bQf247z2VwMsdymudys_lYSsN3UtWlYT1YkF7b6g_M)**

7. Selecciona la configuración regional a ser usada, en nuestro caso Spanish, México.
   
   **![](https://lh7-us.googleusercontent.com/KeT4spcm9O9Qy4O6Mgn-w6xLU_ew4tjfDGiNtEdal41WCBXxGv7nycd9ecXNu0BqAVKtytUhUuLJ0UfIc9cEjr7rzMvvf3flKQGAFYg9F7NcsDXu5LCLnlok_wxwqWM-MLtyGzRTwbyFdWwxaoW34Mc)**

8. A continuaciónse muestra un resumen de instalación.
   
   **![](https://lh7-us.googleusercontent.com/5Ozqlwrq7isC37rDZo_gH_53VCI17N3OW_qWQdvWsHtT5ccDKF7dSNQRUiPrLeLx6Vcjen82QBbRIzm8vfnT4tK9dB6ABeQK9J8FoGrJpeN8Nx2rjFg3K0rTvM--J05Tje7aEXgGAHryr6BE2XhMNvA)**

9. Comienzala instalación.
   
   **![](https://lh7-us.googleusercontent.com/6XNlUr2UXTs3x8TLlbFg7dFvREjaK_OdHS18TubXRkGIehTKDjtpN69i1qxYgW3ELQ49kQRPMTHzEmyhz7A1G68DpiqCfJGvw7JUqkkChPxsDJRI1ez7JnMuML9lPpM9TcR0yGK45YVNfG2YhpInf5c)**

10. Al completar la instalación, te muestra una leyenda para inicializar la configuración de Stack Builder, la mantienes seleccionada y das clic en `Terminar`.
    
    **![](https://lh7-us.googleusercontent.com/Ljw90hmOgK8v4hF5wW2F5TfgPdq2Sg4B3GC3a2qmWbb-NnV-hHTk1J11JXeO5st1w7uVQublslCkF38wnUTJ8Em1rU2BPCHZVuETN8Z6MR3UCl-pg5jaQVOOnOTBtI2SiUhIZ77DhlXdzMP0n9GJy68)**

11. Se abrirá la ventana de configuración de Stack Builder, seleccionamos la versión y el puerto que instalamos y damos clicen `Siguiente`.
    
    **![](https://lh7-us.googleusercontent.com/p4lrmWmMK-DzzIkgvysAG1-1VWo_J47Z5sSda4wmitWDYDFW9yCGcQULPIZlHHz62Ip3Ut-ml-qS0p1saknYpiwZ6HHZBNwmrU-flbyUF5hGRUNT2sGTIryoZlhtgxbjYskul01gnkZLu3SudzWwrOY)**

12. En la siguiente pantalla seleccionaremos la opción `pgJDBC v42.6.0-1` que permitela conectividad Java a PostgreSQL mediante JDBC.
    
    **![](https://lh7-us.googleusercontent.com/TdPEZYZv_u6qjtTad91SVPH15pyzm9eYzPiUZHCJgdT9-ZafInb95VvCYS0kJv1cNn-lTZmg1J-Y47YPEU3hxf7J450ge5c3VcBbS0W5wAoDHUp08p8Qyjw1U90cg_87ruZQ5_ovC9C8HsYa8jG8qvc)**

13. Seleccionamos la ruta de descarga y damos clicen `Next`.
    
    **![](https://lh7-us.googleusercontent.com/plUOTI-T8nQs0-azLs3GVrsq5QXuQOWNlgM77EN_A3T2hJFEcQazuyhe4QHi0-D8t-5SSwT9hEjXvjZogmNATtrn5eVFfiEsPhxT1LRPogJqFbDSXkjtViVZxvX0BEQKjnlsUhP4-LUgR6BwL0IeDG4)**

14. Una vez terminada se inicializa el instalador del JDBC.

**![](https://lh7-us.googleusercontent.com/_p3xcKpOpaNiPxa7_ybEzqRqJbQYUP2B6Mv_GGDZl6EHXXmrHXRqeG0UWdPD9tC97p1hAfebnO7S44KWsv4RPmbvaK4s769d9nX-UulWuc6Yq0Zo-32koylN9rpRMXQDrX6zMrrUTidiFYU5dmIzMTI)**

15. Seleccionamos la ruta de instalación damos clic en `Next `y comienzala instalación.
    
    **![](https://lh7-us.googleusercontent.com/oqGW0x6S4gdcXrE1i66akaIpnHA4yWz2UrUfKXc_yRT4B6C380HKFtOL5AcqHKCUcmvMkJIRL6Qf1jjCl4vI0GN9L8aUl22VQ98McESHk6pKMvdsNn6D4R7uIyvhucdNSBaswG0g-JO8mweDGTVN-ho)**

16.Finalizamos con éxito la instalación.

**![](https://lh7-us.googleusercontent.com/x3fHQf-gQPs8pC19dZiDelotY4pC4r4cTEpSrhCv-1th-ZFEKkcKsyYypQL58OolOG9qCCAWawurBHym-Wpndm2YTTEFVT37lSU5C8fQvkzqQBo07133KAQWuyIh86k5r7AvU3n_dTmkRcWkbxBIm9Q)**

##### **Paso 3: Configurar las Variables de Entorno en Windows**

1. Abre el Panel de Control y busca `Variables de entorno` en la barra de búsqueda.
   
   **![](https://lh7-us.googleusercontent.com/oUYyDNbPj5MwV1ETvTDSiHKW2Aa2gMk7skcggdyKALXQld9kpn5nPJdGdvCSn9ORqyG6oTr0v9R6vxB0Oq_Bz8aa_wf7FATHdtu9YxfFbtkOrMX-8KZiS01iin6baNvOT618ap9vime85xgFqPP7X1A)**

2. Selecciona `Editar las variables de entorno del sistema`.

3. Selecciona `Variables de entorno`.
   
   **![](https://lh7-us.googleusercontent.com/ELdbyWk9ZkT_3_QKtWs4n3VUrshPA1WwXh3OdEnTTaLAFIu-u0_9AXf8f0ew0dwkEqhCvTS5UgwFvy65Ve1bMJQzWyML7jRw_jtSRVOWaKioF290LRd3t6n2zZ7S0RtH_uClLIAgxHnU-ReaWBSTAEE)**

4. Haz clic en Nueva.
   
   **![](https://lh7-us.googleusercontent.com/Lo5T2Fcgj_zPIkBDHAS5mJq8sCU5enwXMLVsYae8eYYfHzKlMbe7y7AUl2JEcXs55BKKF72FHqpFsxjgWMT5hgFb4hjSlUwbe8yyhWcrO-PnDQQHxsLFWK7Fkzpn1q1uiwhSBqiByMnJ3-QODKzku-c)**

5. Ingresa "POSTGRESQL" como nombre de la variable y la ruta de instalación del JDK como valor. Por ejemplo, `C:\Program Files\Java\jdk-17` (Es la ruta donde instalamosen el paso 2-punto 3).
   
   **![](https://lh7-us.googleusercontent.com/nsBICHDcXVODd3AV2ABJJTO3JrIVUw2Fyh-VdYaJePvtKUcl71MNA4tuL-Iyy0U6NwAHS3TWcLn7-oDvjXb6lXZpixuNDT50wJ8o5dtG72LT5rQuZGBXfjLUX66nhFr8JRGO-073OJ-Hg25mssrj7js)**

6. Da clicken `Aceptar`.

7. Buscala variable `Path` en la lista de variables del entorno y haz clicen `Editar`.
   
   **![](https://lh7-us.googleusercontent.com/Y48SJLQvfqGpj17DyP3ZqUVOe4-84ABiFKpeSgmtD1Dq-JpX35C76eOC0byYNzV77dtR04tQiVOsKPRrpp8zXSGArKxyTncN9mX5g8kzDCamUfy26XTzAHdxqX-Ngz_vo9Q5efyy1tK9uFg3m5EgaPk)**

8. En la nueva ventanada clicken Nuevo y agrega `%POSTGRESQL%\bin`.
   
   **![](https://lh7-us.googleusercontent.com/W5B6-VOihVJHDJkMYigtSGYJZT_oxDSTIf_lsrcRh25MuwY5EBHk1B1aZBQzImm-okELxbJvO9v0RVyZqoTh0K7UB_yE-NRUyn4cEY_k48QDXwcUWiX4NPwYFN0gUMThGQXrJjl-cYzPB4AChB-_gx8)**

9. Asegúrate de guardar todos los cambios.

##### **Paso 4: Verificar instalación**

1. Abre el símbolo del sistema y ejecuta el siguiente comando para conectarsea PostgreSQL: `psql -U postgres -p 5433` e ingresarás tu contraseña (Paso 2-punto 5).
   
   **![](https://lh7-us.googleusercontent.com/HBbSWgsJF6O0q3cNrzaaA2fvmURR6PUPCdn6Uw1n_ipVL7z9GC-8_CH_xr4rM2LZzJQvS0KE_jqijxN5Dbf_BEPVsaMSwTqzgM0TrHjVM7soFnExVfjhvdpRk2t68nsRcCN-1vxaVvI6GjnPbB4nXIY)**

2. Si puedes iniciar sesión sin errores, la instalación fue exitosa.

¡Enhorabuena! Has completado con éxito la instalación de PostgreSQL. Este logro marca un paso adicional hacia la configuración completa de nuestro entorno para comenzarel curso. ¡Estamoslistos para avanzar!

### **Postman**

Postman es una plataforma colaborativa que proporciona un entorno completo para el desarrollo y pruebade APIs. Esta herramientanos permite crear, compartir, probar y documentar microservicios de manera eficiente.

##### **Paso 1: Descargar Postman**

1. Accede al sitio oficial de descargas de Postman: https://www.postman.com/downloads/.
   
   **![](https://lh7-us.googleusercontent.com/5Xm3PCh8D9NVlkG_TZia_9kS9iqNBqn1gT_m7eV8Mhkl298qXBwVtmAkQtKaXZz4ngxM-fHntlHD_c48212wAao0zsq6lsqTLawZUTnwbohZNHLV5elESNbxCQULYyfu18ijh0hcws95iqMYbh2FvBk)**

2. Seleccionala versiónde Postman de Windows.

3. Haz clic en el botón de descarga y guarda el archivo de instalación en tu sistema.

##### **Paso 2: Instalar Postman**

1. Ejecutael instaladordescargado.
2. Siguelasinstruccionesdelasistentede instalación.
3. Finalizala instalación.

##### **Paso 3: Iniciar Postman**

1. Despuésde la instalación,busca el iconode Postman en tu sistemay ábrelo.
2. En la primera ejecución, Postman te pedirá que inicies sesión o crees una cuenta. Puedes optar por hacerlo o simplemente cerrar la ventana para accedera Postman sin iniciarsesión.

¡Felicidades! Has instalado Postman con éxito. Estamos listos para iniciar con el curso.