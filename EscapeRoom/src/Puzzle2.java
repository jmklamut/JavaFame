import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Puzzle2 extends Room{

    private USAFlag usa;
    private Table table;
    private Safe safe;
    private Paper paper;
    private Paper paper2;
    private Hook hook;
    private Earth earth;


    public Puzzle2(Label output, Stage layout) {
        super(output);
        hook = new Hook();
        earth = new Earth(layout, hook, output);
        usa = new USAFlag(output);
        table = new Table(output);
        safe = new Safe(output);
        paper = new Paper(3);
        paper2 = new Paper(4);
        paper.changeX(700);
        paper.changeY(600);
        paper2.changeX(500);
        paper2.changeY(700);
        safe.setSolution("1234");
        getBack().toBack();
        earth.toFront();
        getChildren().add(usa);
        getChildren().add(hook);
        getChildren().add(safe);
        getChildren().add(table);
        getChildren().add(paper);
        getChildren().add(paper2);
        getChildren().add(earth);





        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(!earth.getMovement()){

                }
            }
        };
        timer.start();
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



}
