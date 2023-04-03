import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class Room extends Pane{

    private Door door;
    private String image;
    private Image background;
    private ImageView backgroundView;

    public Room(int roomNumber) {
        super();
        door = new Door();
        if(roomNumber == 1){
            image = "file:Images/background.jpg";
        }
        else if(roomNumber == 2){
            image = "file:Images/background.jpg";
        }
        else{
            image = "file:Images/background.jpg";
        }
        background = new Image(image);
        backgroundView = new ImageView(background);
        backgroundView.setViewport(new Rectangle2D(0,0,512,512));
        getChildren().add(backgroundView);
    }

    public Door getDoor() {
        return door;
    }

    public String getImage() {
        return image;
    }


}
