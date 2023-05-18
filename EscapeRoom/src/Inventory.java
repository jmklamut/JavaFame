import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.*;
import javafx.scene.*;

public class Inventory {

    private  String image;
    private  Image background;
    private  ImageView backgroundView;
    private Stage inventory;
    private Group root;
    private Scene inventoryScene;


    public Inventory(){

        inventory = new Stage();
        root = new Group();
        inventoryScene =  new Scene(root,512,512,true);
        image = "file:Images/inventory page.png";
        background = new Image(image);
        backgroundView = new ImageView(background);
        backgroundView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        backgroundView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        root.getChildren().add(backgroundView);

        NoButton no = new NoButton();
        Button close = new Button();
        close.setOnAction(e->inventory.close());

        root.getChildren().add(no);
        root.getChildren().add(close);

        inventory.setScene(inventoryScene);

    }


    public void addItem(String im){
        Image item = new Image(im);
        ImageView itemView = new ImageView(item);
        root.getChildren().add(itemView);
    }

    public void removeItem(String im){
        root.getChildren().remove(im);
    }

    public void useItem(Image view) {
        ImageView temp = new ImageView(view);
        temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.setCursor(new ImageCursor(view));
            }
        });
    }

    public Stage getStage(){
        return inventory;
    }





}
