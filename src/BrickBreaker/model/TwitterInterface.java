/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrickBreaker.model;


/**
 * This interface is defining the the method that needs to be implemented for
 * the twitter adapter/translator class.
 *
 * @author Tyler Roux, Last updated 4/05/2020
 */
public interface TwitterInterface {

    public void postTweet(int _score);
}
