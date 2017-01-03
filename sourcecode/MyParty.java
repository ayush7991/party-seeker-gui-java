/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myparty;

import java.net.MalformedURLException;
import java.net.URL;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author silentwraith
 */
public class MyParty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                String songName = "HungryKidsofHungary-ScatteredDiamonds.mp3";
String pathToMp3 = System.getProperty("user.dir") +"/"+ songName;
BasicPlayer player = new BasicPlayer();
try {
    player.open(new URL("file:///home/silentwraith/Documents/aa.mp3"));
    player.play();
} catch (BasicPlayerException | MalformedURLException e) {
    e.printStackTrace();
}
        // TODO code application logic here
        new loginn().setVisible(true);
    }
    
}