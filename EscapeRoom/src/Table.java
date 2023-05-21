import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
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


public class Table extends Pane{

    private Image table;
    private ImageView tableView;

    public Table(Label output){
        table = new Image("file:Images/depressionTable.png");
        tableView = new ImageView(table);
        tableView.setTranslateX(1000);
        tableView.setTranslateY(500);
        tableView.setScaleX(4);
        tableView.setScaleY(4);

        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                output.setText("Nothing Happened");
            }
        });

        getChildren().add(tableView);
    }

    public ImageView getTableView(){
        return tableView;
    }

}
