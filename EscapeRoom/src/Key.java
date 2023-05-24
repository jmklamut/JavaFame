import javafx.scene.layout.Pane;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

public class Key extends Pane {

    private Image keyImage;
    private ImageView keyView;
    private boolean next;

    public Key(){
        next = false;
        keyImage = new Image("file:Images/key.png");
        keyView = new ImageView(keyImage);
        getChildren().add(keyView);

        keyView.setOnMouseClicked(e -> {
            getChildren().remove(keyView);
            next = true;
        });

    }


    public ImageView getImageView(){
        return keyView;
    }

    public Image getImage(){
        return keyImage;
    }

    public boolean getNext(){
        return next;
    }

}
