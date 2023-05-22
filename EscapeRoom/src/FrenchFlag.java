import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

public class FrenchFlag extends Pane {

    private Image flag_image;
    private ImageView flag_view;

    public FrenchFlag(Label output){
        flag_image = new Image("file:Images/french_flag.jpg");
        flag_view = new ImageView(flag_image);
        flag_view.setScaleY(.4);
        flag_view.setScaleX(.4);
        flag_view.setTranslateX(400);
       // flag_view.setTranslateY(200);
        flag_view.setStyle("-fx-background-color: transparent;");

        flag_view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                output.setText("Nothing in Flag");
            }
        });
        getChildren().add(flag_view);

    }

    public ImageView getView() {
        return flag_view;
    }
}
