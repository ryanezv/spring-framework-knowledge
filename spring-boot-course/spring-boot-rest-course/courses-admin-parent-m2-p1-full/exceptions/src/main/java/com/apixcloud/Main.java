package com.apixcloud;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.zip.DataFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apixcloud.exceptions.GenericResponseError;
import com.apixcloud.exceptions.MyBadRequestException;

public class Main {
    
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Hola info");
        logger.warn("Hola warning");
        logger.error("Hola error");        
        logger.debug("Hola debug");

        /* try {
            String name = null;
            name.toString();

        } catch (NullPointerException e) {            
            //throw new NullPointerException();
            //throw new NullPointerException("El nombre es vacio");                        
            throw new MyBadRequestException(
                "Error controlado desde ApixCloud", 
                new NullPointerException(),
                new GenericResponseError("200", "Error interno", "El reporte con Jasper no se completo.")
            );
            
        } */
        
        // Checked exception
        /* try {
            new FileInputStream(new File("."));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } */

        // Unchecked exception
        /* String name = null;
        name.toString(); */
       

    }

    public void create() throws FileNotFoundException, DataFormatException {
    }

    public void login() throws UserPrincipalNotFoundException {
    }
}