public class Puzzle {

    public Puzzle(){}

    void createPuzzle(int dif){
        if(dif == 1){
            Puzzle1 pz1 = new Puzzle1();}
        else if(dif == 2){
            Puzzle2 pz2 = new Puzzle2();}
        else{
            Puzzle3 pz3 = new Puzzle3();}
    }



}
