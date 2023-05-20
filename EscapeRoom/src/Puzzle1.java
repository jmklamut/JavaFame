import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Puzzle1 extends Room{

    private String solution;
    private String question;
    private Safe safe;
    private Paper paper;
   // private Paper paper2;
    private Table table;
    private FrenchFlag french;
    private boolean worked;

    public Puzzle1(Inventory inventory, Group root) {
        super();
        french = new FrenchFlag();
        safe = new Safe();
        Key key = new Key();
        safe.setSolution("1776");
        paper = new Paper();
      //  paper2 = new Paper();
       // paper2.changeX(250);
       // paper2.changeY(700);
        table = new Table();
        getChildren().add(safe);
        getChildren().add(paper);
       // getChildren().add(paper2);
        getChildren().add(table);
        getChildren().add(french);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(safe.checkLock()) {
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
                    stop();
                }
            }
        };
        timer2.start();

        getDoor().getDoorView().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (worked) {
                    getDoor().setLocked(false);
                }
            }


        });



    }

    public void safe_display(){
        safe.getSafeView().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Hello");
                /*
                Label message = new Label("wehfuwr9uqwhrf9uwe9fh");
                message.setTranslateX(100);
                message.setTranslateY(100);
                PasswordField passwordField = new PasswordField();
                passwordField.setPromptText("Enter Code Here");
                getChildren().add(passwordField);
                getChildren().add(message);
                passwordField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        if (!passwordField.getText().equals(solution)) {
                            message.setText("Your password is incorrect!");

                            System.out.println("Your password is incorrect!");
                            safe.changeLock(true);
                        } else {
                            message.setText("Your password has been confirmed");
                            System.out.println("Your password has been confirmed");
                            safe.changeLock(false);
                        }

                        passwordField.clear();
                    }
                });
                 */
            }
        });
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

    public Table getTable() {
        return table;
    }

    public boolean getWorked(){
        return worked;
    }
}
