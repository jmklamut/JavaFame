import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

public class Puzzle3 extends Room{

    private Paper paper;
    private USAFlag usa;
    private FrenchFlag french;
    private Hamburger ham;
    private Cross cros;
    private double ham_vel;
    private double ham_pos;
    private double cross_vel;
    private double cross_pos;

    public Puzzle3(Inventory inventory, Label output){
        super(output);
        paper = new Paper(6);
        usa = new USAFlag(output, true);
        french = new FrenchFlag(output, true);
        ham = new Hamburger(inventory);
        cros = new Cross(inventory);
        usa.getView().setTranslateX(830);
        french.getView().setTranslateX(253);
        french.getView().setTranslateY(40);
        paper.changeX(1000);
        paper.changeY(700);


        getChildren().add(paper);
        getChildren().add(usa);
        getChildren().add(french);
        getChildren().add(ham);
        getChildren().add(cros);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (usa.getAction()) {
                    ham_vel = ham_vel + 1;
                    if (ham_vel > 300) {
                        ham_vel = 300;
                    }
                    if (ham_pos < 650) {
                        ham_pos = ham_pos + ham_vel;
                        ham.getView().setTranslateY(ham_pos);
                    }
                }
                if (french.getAction()) {
                    cross_vel = cross_vel + 1;
                    if (cross_vel > 300) {
                        cross_vel = 300;
                    }
                    if (cross_pos < 650) {
                        cross_pos = cross_pos + cross_vel;
                        cros.getView().setTranslateY(cross_pos);
                    }

                }
            }
        };
        timer.start();
    }

}

