import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.image.*;

import java.io.File;

public class Room extends Pane{

    private Door door;
    private String image;
    private Image background;
    private ImageView backgroundView;
    private Inventory invent;
    private GameTime timer;
    private YesButton yes;
    private Puzzle1 pz1;
   // private Button invent_Button;



    public Room(Label output){
        door = new Door(output);
        timer = new GameTime();
        yes = new YesButton();
       // invent_Button = new Button();

        image = "file:Images/background.jpg";

        background = new Image(image);
        backgroundView = new ImageView(background);
        System.out.println(Screen.getPrimary().getVisualBounds().getWidth());
        System.out.println(Screen.getPrimary().getVisualBounds().getHeight());
        //backgroundView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        //backgroundView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        backgroundView.setFitWidth(1536);
        backgroundView.setFitHeight(816);


        getChildren().add(backgroundView);
        getChildren().add(getDoor());
        getChildren().add(timer);
        getChildren().add(yes);

        if(!door.isLocked()){
            door.setLocked(false);
        }
       // getChildren().add(invent_Button);

    }

    public Door getDoor() {
        return door;
    }

    public YesButton getYes(){
        return yes;
    }

/*
    public Button getInvent_Button() {
        return invent_Button;
    }
    */


    public void playmedia(){
        String musicFile1 = "Sound/music.mp3";     // For example
        Media sound1 = new Media(new File(musicFile1).toURI().toString());
        MediaPlayer mediaPlayer1 = new MediaPlayer(sound1);
        mediaPlayer1.setVolume(.2);
        mediaPlayer1.play();
    }

    public String getImage() {
        return image;
    }

    public ImageView getBack(){
        return backgroundView;
    }

    public GameTime getGameTime(){
        return timer;
    }

    public void setImage(String str){
        image = str;
    }


}
