import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Hamburger extends Pane {

    private Image ham_image;
    private ImageView ham_view;

    public Hamburger(Inventory inventory){
        ham_image = new Image("file:Images/Hamburger.jpg");
        ham_view = new ImageView(ham_image);
        ham_view.setTranslateY(-200);
        ham_view.setTranslateX(500);
        ham_view.setScaleX(.3);
        ham_view.setScaleY(.3);
        getChildren().add(ham_view);

        ham_view.setOnMouseClicked(e ->{
            getChildren().remove(ham_view);
            inventory.addItem(ham_view);
            ham_view.setX(-450);
            ham_view.setY(-650);
        });
    }

    public ImageView getView(){
        return ham_view;
    }
}
