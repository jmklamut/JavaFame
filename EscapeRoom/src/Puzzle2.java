import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Puzzle2 extends Room{

    private USAFlag usa;
    private Table table;
    private Safe safe;
    private Paper paper;
    private Paper paper2;
    private Paper paper3;
    private Hook hook;
    private Earth earth;
    private Closet closet;
    private Key key;
    private boolean worked;


    public Puzzle2(Inventory inventory, Group root, Label output, Stage layout) {
        super(output);
        hook = new Hook();
        earth = new Earth(layout, hook, output);
        usa = new USAFlag(output, false);
        table = new Table(output);
        safe = new Safe(output);
        closet = new Closet(output);
        paper = new Paper(3);
        paper2 = new Paper(4);
        paper3 = new Paper(5);
        key = new Key();
        paper.changeX(700);
        paper.changeY(600);
        paper2.changeX(500);
        paper2.changeY(700);
        safe.setSolution("FrenchAmerican");
        getBack().toBack();
        earth.toFront();
        getChildren().add(usa);
        getChildren().add(hook);
        getChildren().add(safe);
        getChildren().add(table);
        getChildren().add(paper);
        getChildren().add(paper2);
        getChildren().add(earth);
        getChildren().add(closet);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(!earth.getMovement()){
                    closet.setOpen_door(true);
                }
                if(closet.getNext()){
                    inventory.addItem(paper3.getPaperView());
                    paper3.getPaperView().setTranslateY(50);
                    paper3.getPaperView().setTranslateX(50);
                    stop();
                }
            }
        };
        timer.start();

        AnimationTimer timer1 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(!safe.checkLock()) {
                    key.getImageView().setTranslateX(100);
                    key.getImageView().setTranslateY(50);
                    inventory.addItem(key.getImageView());
                    stop();
                }
            }
        };
        timer1.start();

        AnimationTimer timer2 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                worked = inventory.useItem(key.getImage(), key.getImageView());
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

    public USAFlag getUsa(){
        return usa;
    }

    public Safe getSafe(){
        return safe;
    }

    public Table getTable(){
        return table;
    }

    public Earth getEarth(){
        return earth;
    }

    public Hook getHook(){
        return hook;
    }

    public Paper getPaper(){
        return paper;
    }

    public Paper getPaper2(){
        return paper2;
    }

    public Paper getPaper3(){
        return paper3;
    }


    public Key getKey(){
        return key;
    }



}
