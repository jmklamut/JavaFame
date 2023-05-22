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


public class Paper extends Pane {

    private Image paper;
    private ImageView paperView;

    public Paper(int numb) {
        super();
        paper = new Image("file:Images/papers.png");
        paperView = new ImageView(paper);
        getChildren().add(paperView);
        if(numb == 1) {
            paperView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                 //   Popup.changeMessage();
                    Popup.display();
                }
            });
        }
        else if(numb == 2){
            paperView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                  //  PopUp2.display();
                  //  PopUp2.changeText();
                }
            });
        }
    }

    public void changeX(double x) {
        paperView.setX(x);
    }

    public void changeY(double y) {
        paperView.setY(y);
    }

    public ImageView getPaperView() {
        return paperView;
    }
}
