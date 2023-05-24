import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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


    public Inventory(Stage primaryStage){
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

        Canvas canvas = new Canvas(300, 100);
        canvas.setLayoutX(575);
        canvas.setLayoutY(0);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.YELLOW);
        Font thefont = Font.font("Times New Roman", FontWeight.LIGHT, 40);
        gc.setFont(thefont);
        gc.fillText("Inventory", 100,50);
        root.getChildren().add(canvas);



        no = new NoButton(inventory_stage, primaryStage);
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

    public void removeItem(ImageView im){
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

    public void defaultCursor(){
        root.setCursor(Cursor.DEFAULT);
    }

    public Stage getStage(){
        return inventory_stage;
    }

    public void setWorked(boolean set){
        worked = set;
    }
}
