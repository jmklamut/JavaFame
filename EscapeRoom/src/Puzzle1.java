import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Puzzle1 extends Room{

    private String solution;
    private String question;
    private Safe safe;
    private Paper paper;
    private Paper paper2;
    private Table table;
    private Key key;
    private FrenchFlag french;
    private boolean worked;

    public Puzzle1(Inventory inventory, Group root, Label output) {
        super(output);
        french = new FrenchFlag(output);
        safe = new Safe(output);
        key = new Key();
        safe.setSolution("1776");
        paper = new Paper(1);
        paper2 = new Paper(2);
        paper.changeX(600);
        paper.changeY(600);
        paper2.changeX(250);
        paper2.changeY(700);
        table = new Table(output);
        getChildren().add(safe);
        getChildren().add(paper);
        getChildren().add(paper2);
        getChildren().add(table);
        getChildren().add(french);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(!safe.checkLock()) {
                    key.getImageView().setTranslateX(50);
                    key.getImageView().setTranslateY(50);
                    inventory.addItem(key.getImageView());
                    stop();
                }
            }
        };
        timer.start();

        AnimationTimer timer2 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                worked = inventory.useItem(key.getImage(), key.getImageView());
               // System.out.println(worked);
                if(worked){
                    System.out.println("It is in here");
                    root.setCursor(new ImageCursor(key.getImage()));
                    getDoor().setLocked(false);
                    stop();
                }
            }
        };
        timer2.start();





    }

    public void safe_display(){

    }

    public String displayQuestion(){
        return question;
    }

    public String displaySolution(){
        return solution;
    }

    public Safe getSafe(){
        return safe;
    }

    public Paper getPaper() {return paper; }

    public Key getKey(){
        return key;
    }

    public Table getTable() {
        return table;
    }

    public boolean getWorked(){
        return worked;
    }
}
