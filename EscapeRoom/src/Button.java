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


public class Button extends Pane{

    private boolean display_inventory;

    public Button(){
        display_inventory = false;
        String inventory_button = "file:Image/yes.png";
        Image button = new Image(inventory_button);
        ImageView buttonView = new ImageView(button);
        getChildren().add(buttonView);
        buttonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                display_inventory = true;
            }
        });
    }

    public boolean isDisplay_inventory() {
        return display_inventory;
    }

    public void setDisplay_inventory(boolean display_inventory) {
        this.display_inventory = display_inventory;
    }
}
