import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.control.Label;

public class Puzzle3 extends Room{

    private Paper paper;
    private USAFlag usa;
    private FrenchFlag french;
    private Hamburger ham;
    private Cross cros;
    private TrashCan can;
    private Chest chest;
    private Key key;
    private double ham_vel;
    private double ham_pos;
    private double cross_vel;
    private double cross_pos;
    private boolean worked;

    public Puzzle3(Inventory inventory, Group root, Label output){
        super(output);
        paper = new Paper(6);
        key = new Key();
        usa = new USAFlag(output, true);
        french = new FrenchFlag(output, true);
        ham = new Hamburger(inventory, output);
        cros = new Cross(inventory, output);
        can = new TrashCan(output);
        chest = new Chest(output);
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
        getChildren().add(can);
        getChildren().add(chest);


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
                if(ham.getFood() && cros.getFood()){
                    chest.setFood(true);
                    stop();
                }
            }
        };
        timer.start();
        AnimationTimer timer1 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(chest.getNext()) {
                    getChildren().add(key);
                    key.getImageView().setTranslateX(175);
                    key.getImageView().setTranslateY(650);
                    stop();
                }
            }
        };
        timer1.start();

        AnimationTimer timer2 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(key.getNext()) {
                    System.out.println("It is in here");
                    getChildren().remove(key);
                    root.setCursor(new ImageCursor(key.getImage()));
                    getDoor().setLocked(false);
                    inventory.setWorked(false);
                    stop();
                }
            }
        };
        timer2.start();
    }

}

