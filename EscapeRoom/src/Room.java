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

public class Room extends Pane{

    private Door door;
    private String image;
    private Image background;
    private ImageView backgroundView;
    private Inventory invent;
    private GameTime timer;
    private Puzzle1 pz1;
   // private Button invent_Button;



    public Room() {
        super();
        door = new Door();
        timer = new GameTime();
       // invent_Button = new Button();

        image = "file:Images/background.jpg";

        background = new Image(image);
        backgroundView = new ImageView(background);
        backgroundView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        backgroundView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());

        getChildren().add(backgroundView);
        getChildren().add(getDoor());
        getChildren().add(timer);

        if(!door.isLocked()){
            door.setLocked(false);
        }
       // getChildren().add(invent_Button);

    }

    public Door getDoor() {
        return door;
    }

/*
    public Button getInvent_Button() {
        return invent_Button;
    }
    */


    public String getImage() {
        return image;
    }

    public GameTime getGameTime(){
        return timer;
    }

    public void setImage(String str){
        image = str;
    }


}
