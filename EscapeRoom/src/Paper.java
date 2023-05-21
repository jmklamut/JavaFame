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


public class Paper extends Pane{

    private Image paper;
    private ImageView paperView;

    public Paper() {
        super();
        paper = new Image("file:Images/papers.png");
        paperView = new ImageView(paper);
        paperView.setX(600);
        paperView.setY(600);
        getChildren().add(paperView);
        paperView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Popup.display();
            }
        });
    }

    public void changeX(double x){
        paperView.setX(x);
    }

    public void changeY(double y){
        paperView.setY(y);
    }

    public ImageView getPaperView(){
        return paperView;
    }

    public void changeMessage(String x){
        Popup.changeMessage(x);
    }
}
