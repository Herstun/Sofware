/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrickBreaker.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Rouxk
 */
public class Score implements ScoreInterface{
    @Override
    public void writeScore(int _score) {
   try {
		FileWriter fw = new FileWriter("src/resources/Score/score.txt", true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            if(_score > 0){
                bw.write("The score was:" + " " + _score);
                bw.newLine();
            }
        }
       }catch (IOException e) {
            e.printStackTrace();
        }
    } 
}
