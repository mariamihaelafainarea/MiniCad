/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
public interface IFactory {
    	//interfata ce va fi implementata in Factory class
    Forme creeazaForme(Strategy strategy, String[] vector);
}
