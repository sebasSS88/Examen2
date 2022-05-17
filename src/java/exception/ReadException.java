/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author JAIME
 */
public class ReadException extends Exception{
    
    public ReadException(String message){
        super("Error al leer de la Base De Datos");
    }
}
