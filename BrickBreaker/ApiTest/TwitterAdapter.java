/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrickBreaker.ApiTest;

//import BrickBreaker.Game;
/**
 *
 * @author Rouxk
 */

public class TwitterAdapter implements TwitterInterface{
    protected static final TwitterInterface thisApi = new TwitterConnector();
    @Override
    public void postTweet(int _score){
        thisApi.postTweet( _score);
    }
}
