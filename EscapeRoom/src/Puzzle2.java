import javafx.scene.control.Label;

public class Puzzle2 extends Room{

    private USAFlag usa;
    private Table table;
    private Safe safe;

    public Puzzle2(Label output) {
        super(output);
        usa = new USAFlag(output);
        table = new Table(output);
        safe = new Safe(output);
        safe.setSolution("1234");
        getChildren().add(usa);
        getChildren().add(safe);
        getChildren().add(table);

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

}
