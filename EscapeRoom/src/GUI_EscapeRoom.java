import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class GUI_EscapeRoom extends Application {

    private Scene roomScene;
    private Scene inventoryScene;
    private Scene overScene;
    private Group root;
    private Group root2;
    private Group root3;
    private VBox vbox;
    private Label output;

    private Inventory inventory;
    private Puzzle1 easy;
   // private NoButton no;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("EscapeRoom");
        output = new Label("Click On Something");
        root = new Group();
        root3 = new Group();
        inventory = new Inventory(primaryStage);
        easy = new Puzzle1(inventory, root, output);



        roomScene = new Scene(root, 1000, 512,true);


        overScene = new Scene(root3, 512,512,true);

        Image overImage = new Image("file:Images/game over.png");
        ImageView overView = new ImageView(overImage);
        overView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        overView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        root3.getChildren().add(overView);


        root.getChildren().add(easy);


        root.getChildren().add(easy.getSafe().getSafeView());
        root.getChildren().add(easy.getDoor().getDoorView());
        root.getChildren().add(easy.getPaper().getPaperView());

        vbox = new VBox();
        vbox.setTranslateX(Screen.getPrimary().getVisualBounds().getWidth() - 200);
        vbox.setTranslateY(Screen.getPrimary().getVisualBounds().getHeight() - 50);

        Font thefont = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15);
        output.setTextFill(Color.RED);
        output.setFont(thefont);

        vbox.getChildren().add(output);
        root.getChildren().add(vbox);

        primaryStage.setScene(roomScene);

        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);


        primaryStage.show();

        easy.getYes().getImageYes().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                inventory.getStage().show();
                inventory.getStage().setMaximized(true);
                inventory.getStage().setFullScreen(true);
            }
        });


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(easy.getGameTime().isGame_over()){
                    primaryStage.setScene(overScene);
                    primaryStage.setMaximized(true);
                    primaryStage.setFullScreen(true);
                    stop();
                }
            }
        };
        timer.start();

    }

    public Scene getRoomScene(){
        return roomScene;
    }

    public Scene getInventoryScene(){
        return inventoryScene;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
