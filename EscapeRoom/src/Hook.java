import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Hook extends Pane {

    private Image hook;
    private ImageView hookView;

    public Hook(){
        hook = new Image("file:Images/hook.png");
        hookView = new ImageView(hook);
        hookView.setScaleX(3);
        hookView.setScaleY(3);
        hookView.setTranslateX(700);
        hookView.setTranslateY(75);
        getChildren().add(hookView);
    }

    public ImageView getHookView(){
        return hookView;
    }
}
