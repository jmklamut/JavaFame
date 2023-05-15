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
   // private Button invent_Button;



    public Room(int roomNumber) {
        super();
        door = new Door();
        timer = new GameTime();
       // invent_Button = new Button();

        switch (roomNumber) {
            case 1:
                image = "file:Images/background.jpg";
                break;
            case 2:
                image = "file:Images/space.png";
                break;
            default:
                image = "file:Images/inventory.png";
        }

        background = new Image(image);
        backgroundView = new ImageView(background);
        backgroundView.setViewport(new Rectangle2D(0, 0, 1000, 1000));
        getChildren().add(backgroundView);
        getChildren().add(getDoor());
        getChildren().add(timer);
       // getChildren().add(invent_Button);

        switch (roomNumber) {
            case 1:
                Puzzle1 pz1 = new Puzzle1();
                getChildren().add(pz1.getSafe());
                getChildren().add(pz1.getPaper());
                getChildren().add(pz1.getTable());
                if(!door.isLocked()){
                    door.setLocked(false);
                }
                break;
            case 2:
                Puzzle2 pz2 = new Puzzle2();
                break;
            default:
                Puzzle3 pz3 = new Puzzle3();
        }
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


}
