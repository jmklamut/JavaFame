import javafx.event.ActionEvent;
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


public class NoButton extends Pane{

    private boolean display_inventory;

    public NoButton(Stage inventory){
        display_inventory = true;
        String inventory_button = "file:Images/no.png";
        Image button = new Image(inventory_button);
        ImageView buttonView = new ImageView(button);
        buttonView.setX(500);
        buttonView.setY(500);
        buttonView.setScaleX(.1);
        buttonView.setScaleY(.1);
        getChildren().add(buttonView);
        buttonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //Inventory.getStage().close();
                display_inventory = false;
                inventory.close();

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
