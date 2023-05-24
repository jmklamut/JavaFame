import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Cross extends Pane {

    private Image crossiant;
    private ImageView cross_view;


    public Cross(Inventory inventory){
        crossiant = new Image("file:Images/bread.png");
        cross_view = new ImageView(crossiant);
        cross_view.setScaleY(1.5);
        cross_view.setScaleX(1.5);
        cross_view.setTranslateX(1100);
        cross_view.setTranslateY(-200);
        getChildren().add(cross_view);

        cross_view.setOnMouseClicked(e ->{
            getChildren().remove(cross_view);
            inventory.addItem(cross_view);
            cross_view.setX(-900);
            cross_view.setY(-610);
        });
    }

    public ImageView getView(){
        return cross_view;
    }


}
