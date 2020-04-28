/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrickBreaker.ApiTest;

//import BrickBreaker.ApiTest.TwitterAdapter;

import java.util.logging.Level;
import java.util.logging.Logger;
import BrickBreaker.Game;
import java.io.IOException;

//import BrickBreaker.ApiTest.TwitterConnector;
/**
 *
 * @author Rouxk
 */
public class Twitter {
     protected int score;
    protected String name;
    protected Game game;
    private final TwitterAdapter adapter;
    //protected final static TwitterConnector thisApi = new TwitterAdapter();
    
    public  Twitter(){
    this.adapter = new TwitterAdapter();
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    public void translate(int _post){
       // switch (_post){
        //    case :
        
                this.adapter.postTweet(this.game.getScore());
    }
    }
//}

