import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Collections;


public class GUI_EscapeRoom extends Application {

    private Scene pz1Scene;
    private Scene overScene;
    private Scene pz2Scene;
    private Group pz1_root;
    private Group pz2_root;
    private Group invent_root;
    private VBox vbox;
    private Label output;
    private VBox vbox1;
    private Label output_med;

    private Inventory inventory;
    private Puzzle1 easy;
    private Puzzle2 medium;
   // private NoButton no;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("EscapeRoom");
        output = new Label("Click On Something");
        output_med = new Label("Click On Something");
        pz1_root = new Group();
        invent_root = new Group();
        pz2_root = new Group();
        inventory = new Inventory(primaryStage);
        pz2Scene = new Scene(pz2_root,1000,512, true);
        easy = new Puzzle1(inventory, pz1_root, output);
        medium = new Puzzle2(output_med, primaryStage);



        pz1Scene = new Scene(pz1_root, 1000, 512,true);



        overScene = new Scene(invent_root, 512,512,true);

        Image overImage = new Image("file:Images/game over.png");
        ImageView overView = new ImageView(overImage);
        overView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        overView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        invent_root.getChildren().add(overView);


        pz1_root.getChildren().add(easy);

        pz2_root.getChildren().add(medium);
        pz2_root.getChildren().add(medium.getBack());
        pz2_root.getChildren().add(medium.getEarth().getEarthView());
      //  pz2_root.getChildren().add(medium.getUsa().getView());
       // pz2_root.getChildren().add(medium.getSafe().getSafeView());
        //pz2_root.getChildren().add(medium.getTable().getTableView());

        pz1_root.getChildren().add(easy.getSafe().getSafeView());
        pz1_root.getChildren().add(easy.getDoor().getDoorView());
        pz1_root.getChildren().add(easy.getPaper().getPaperView());
        pz1_root.getChildren().add(easy.getFlag().getView());

        vbox = new VBox();
        vbox.setTranslateX(Screen.getPrimary().getVisualBounds().getWidth() - 200);
        vbox.setTranslateY(Screen.getPrimary().getVisualBounds().getHeight() - 50);

        Font thefont = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 18);
        output.setTextFill(Color.RED);
        output.setFont(thefont);

        vbox.getChildren().add(output);
        pz1_root.getChildren().add(vbox);


        vbox1 = new VBox();
        vbox1.setTranslateX(Screen.getPrimary().getVisualBounds().getWidth() - 200);
        vbox1.setTranslateY(Screen.getPrimary().getVisualBounds().getHeight() - 50);

        Font thefont1 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 18);
        output_med.setTextFill(Color.RED);
        output_med.setFont(thefont1);

        vbox1.getChildren().add(output_med);
        pz2_root.getChildren().add(vbox1);

        primaryStage.setScene(pz1Scene);

        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);


        primaryStage.show();


        ObservableList<Node> collection = FXCollections.observableArrayList(pz2_root.getChildren());

        Collections.swap(collection,0,1);

        pz2_root.getChildren().setAll(collection);




        easy.getYes().getImageYes().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                inventory.getStage().show();
                inventory.getStage().setMaximized(true);
                inventory.getStage().setFullScreen(true);
            }
        });

        medium.getYes().getImageYes().setOnMouseClicked(new EventHandler<MouseEvent>() {
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
                if(easy.getGameTime().isGame_over() || medium.getGameTime().isGame_over()){
                    primaryStage.setScene(overScene);
                    primaryStage.setMaximized(true);
                    primaryStage.setFullScreen(true);
                    stop();
                }
                if(easy.getDoor().nextRoom()){
                    PauseTransition pause = new PauseTransition(Duration.seconds(5));
                    pause.setOnFinished(eventP -> {
                        primaryStage.setScene(pz2Scene);
                        primaryStage.setMaximized(true);
                        primaryStage.setFullScreen(true);
                    });
                    pause.play();
                    output.setText("Congrats! Going \ninto next room...");
                    inventory.removeItem(easy.getKey().getImageView());
                    inventory.defaultCursor();
                    stop();
                }
            }
        };
        timer.start();

    }

    public Scene getPz1Scene(){
        return pz1Scene;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
