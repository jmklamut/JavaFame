import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.util.Duration;

import static java.lang.Thread.sleep;


public class Safe extends Pane {

    private boolean isLocked;
    private boolean clicked;
    private String solution;
    private String image;
    private Image safe;
    private ImageView safeView;
    private Key key;
    private StackPane pane_word;


    public Safe(Label output) {
        clicked = true;
        key = new Key();
        pane_word = new StackPane();
        isLocked = true;
        image = "file:Images/Safe.png";
        solution = "";
        safe = new Image(image);
        safeView = new ImageView(safe);
        safeView.setX(775);
        safeView.setY(292);
        safeView.setScaleX(.2);
        safeView.setScaleY(.2);
        safeView.setDisable(false);
        getChildren().add(safeView);
            safeView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    output.setText("Please enter a code\n DONT PRESS SAFE");
                    pane_word.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                    Canvas canvas = new Canvas(750, 80);
                    canvas.setLayoutX(100);
                    GraphicsContext gc = canvas.getGraphicsContext2D();
                    gc.setFill(Color.RED);
                    Font thefont = Font.font("Times New Roman", FontWeight.BOLD, 20);
                    gc.setFont(thefont);
                    gc.fillText("Enter the Key Code Here", 75, 75);
                    gc.strokeText("Enter the Key Code Here", 75, 75);
                    TextField password = new TextField();
                    password.setPromptText("Enter Code Here");
                    pane_word.getChildren().addAll(password, canvas);
                    pane_word.setLayoutX(300);
                    pane_word.setLayoutY(50);
                    //pane_word.setLayoutX(Screen.getPrimary().getVisualBounds().getWidth()/3);
                    //pane_word.setLayoutY(Screen.getPrimary().getVisualBounds().getHeight()/3);
                    pane_word.setStyle("-fx-background-color: grey;");
                    pane_word.toFront();
                    getChildren().add(pane_word);
                    password.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (!password.getText().equals(solution)) {
                                gc.clearRect(0, 0, 750, 80);
                                gc.fillText("Your password is incorrect!", 75, 75);
                                gc.strokeText("Your password is incorrect!", 75, 75);
                                PauseTransition pause1 = new PauseTransition(Duration.seconds(3));
                                pause1.setOnFinished(eventPause -> {
                                    System.out.println("Waited");
                                    pane_word.getChildren().remove(canvas);
                                    pane_word.getChildren().remove(password);
                                    pane_word.setStyle("-fx-background-color: transparent;");
                                    getChildren().remove(pane_word);
                                });
                                pause1.play();
                                System.out.println("Your password is incorrect!");
                                isLocked = true;
                            } else {

                                isLocked = false;
                                output.setText("Safe has been unlocked!");
                                gc.clearRect(0, 0, 750, 80);
                                gc.fillText("Safe Unlocked! Check Inventory!", 75, 75);
                                gc.strokeText("Safe Unlocked! Check Inventory!", 75, 75);
                                System.out.println("Safe Unlocked! Check Inventory!");
                                PauseTransition pause = new PauseTransition(Duration.seconds(3));
                                pause.setOnFinished(eventPause -> {
                                    System.out.println("Waited");
                                    pane_word.getChildren().remove(canvas);
                                    pane_word.getChildren().remove(password);
                                    pane_word.setStyle("-fx-background-color: transparent;");
                                    getChildren().remove(pane_word);
                                });
                                pause.play();

                                //  pane_word.getChildren().add(replace);
                                // sleep(3000);
                                //   pane_word.getChildren().remove(replace);
                                // }
                                // catch(Exception e){
                                //    System.out.println("Don't work");
                                //  }
                            }
                            password.clear();
                        }
                    });
                }
            });
    }

    public void setSolution(String ans) {
        solution = ans;
    }




    public void check(String ans) {
        if (solution == ans) {
            isLocked = false;
        }
    }

    public Image getImage() {
        return safe;

    }

    public ImageView getSafeView(){
        return safeView;
    }

    public void runningSafe(){
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                System.out.println(l);
            }
        };
        timer.start();
    }

    public StackPane getPane(){
        return pane_word;
    }

    public boolean checkLock() {
        return isLocked;
    }

    public void changeLock(boolean lock){
        isLocked = lock;
    }
}