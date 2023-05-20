import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
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

public class Door extends Pane{

    private boolean isLocked;
    private String image;
    private Image door;
    private ImageView doorView;

    public Door(){
        //super();
        image = "file:Images/Locked.png";
        door = new Image(image);
        doorView = new ImageView(door);
        doorView.setX(400);
        doorView.setY(480);
        doorView.setScaleX(3.0);
        doorView.setScaleY(3.0);
        getChildren().add(doorView);

        doorView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                    image = "file:Images/unLocked.png";
                    changeImage(image);
                    doorView.setX(300);
                    doorView.setY(300);
                    doorView.setScaleX(2);
                    doorView.setScaleY(2);
                    getChildren().add(doorView);

            }
        });

    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
        if(isLocked == true){
            image = "file:Images/Locked.png";
        }
        else{
            image = "file:Images/unLocked.png";
        }
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

