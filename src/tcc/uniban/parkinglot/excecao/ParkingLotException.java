/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.uniban.parkinglot.excecao;

/**
 *
 * @author eduardo
 */
public class ParkingLotException extends Exception{

    public ParkingLotException() {
        super("Causa do erro: Desconhecida");
    }

    public ParkingLotException(String message) {
        super(message);
    }
    
    
        
}
