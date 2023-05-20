import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

public class FrenchFlag extends Pane {

    private Image flag_image;
    private ImageView flag_view;

    public FrenchFlag(){
        flag_image = new Image("file:Images/french_flag.jpg");
        flag_view = new ImageView(flag_image);
        flag_view.setScaleY(.4);
        flag_view.setScaleX(.4);
        flag_view.setTranslateX(400);
       // flag_view.setTranslateY(200);
        flag_view.setStyle("-fx-background-color: transparent;");
        getChildren().add(flag_view);



    }
}
