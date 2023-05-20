import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.*;
import javafx.scene.*;

public class Inventory {

    private  String image;
    private  Image background;
    private  ImageView backgroundView;
    private Stage inventory_stage;
    private Group root;
    private Scene inventoryScene;
    private NoButton no;

    private boolean worked;


    public Inventory(){
        worked = false;
        inventory_stage = new Stage();
        inventory_stage.setTitle("Inventory");
        root = new Group();
        inventoryScene =  new Scene(root,512,512,true);
        image = "file:Images/inventory page.png";
        background = new Image(image);
        backgroundView = new ImageView(background);
        backgroundView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        backgroundView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        root.getChildren().add(backgroundView);

        no = new NoButton(inventory_stage);
        /*
        Button close = new Button();
        close.setOnAction(e->inventory.close());
        */
        root.getChildren().add(no);
        //root.getChildren().add(close);

        inventory_stage.setScene(inventoryScene);

    }


    public void addItem(ImageView itemView){
        root.getChildren().add(itemView);
    }

    public void removeItem(String im){
        root.getChildren().remove(im);
    }

    public boolean useItem(Image view, ImageView imageView) {
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.setCursor(new ImageCursor(view));
                worked = true;
            }
        });

        if(worked){
           return true;
        }
        else{
            return false;
        }
    }

    public Stage getStage(){
        return inventory_stage;
    }





}
