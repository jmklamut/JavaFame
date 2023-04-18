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

public class Inventory extends Pane{

    private String image;
    private Image background;
    private ImageView backgroundView;


    public Inventory(){
        super();
        image = "file:Images/inventory page.png";
        background = new Image(image);
        backgroundView = new ImageView(background);
        backgroundView.setViewport(new Rectangle2D(0, 0, 512, 512));
        getChildren().add(backgroundView);

    }

    private void addItem(String im){
        Image item = new Image(im);
        ImageView itemView = new ImageView(item);
        getChildren().add(itemView);
    }






}
