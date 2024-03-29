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
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.image.*;

import static java.lang.Thread.sleep;

public class Door extends Pane{

    private boolean isLocked;
    private boolean next;
    private String image;
    private Image door;
    private Image undoor;
    private ImageView doorView;

    public Door(Label output){
        //super();
        isLocked = true;
        next = false;
        image = "file:Images/Locked.png";
        undoor = new Image("file:Images/unLocked.png");
        door = new Image(image);
        doorView = new ImageView(door);
        doorView.setX(400);
        doorView.setY(445);
        doorView.setScaleX(5.0);
        doorView.setScaleY(5.0);
        getChildren().add(doorView);

        doorView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(isLocked == false) {
                    System.out.println("Hello");
                    doorView.setImage(undoor);
                    output.setText("Congrats! Going \ninto next room...");
                    next = true;
                }
                else{
                    output.setText("Door Locked");
                }

            }
        });

    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean nextRoom(){
        return next;
    }

    public void setRoom(boolean set){
        next = set;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
        /*
        if(isLocked == true){
            image = "file:Images/Locked.png";
        }
        else{
            image = "file:Images/unLocked.png";
        }
         */
    }


    public void changeImage(String im) {
        Image temp = new Image(im);
        ImageView tempView = new ImageView(temp);
        door = temp;
        doorView = tempView;
    }


    public void unlockDoor(){
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("I've been cliked on "
                        +mouseEvent.getSceneX()+","+mouseEvent.getSceneY());
            }
        });
    }

    public ImageView getDoorView(){
        return doorView;
    }
}

