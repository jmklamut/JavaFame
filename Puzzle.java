public class Puzzle {

    public Puzzle(){}
    boolean solved = false;

    void createPuzzle(int room){
        if(room == 1){
            Puzzle1(); //Puzzle1,2,3 are functions for now can be made into classes later
        }
        else if(room == 2){
            Puzzle2();
        }
        else{
            Puzzle3();
        }

    }

    public void Puzzle1(){
        //TODO: this is the code for puzzle1
        System.out.println("Hello this is Puzzle 1.");
        solved = true;

    }

    public void Puzzle2(){
        //TODO: this is the code for puzzle2
        System.out.println("Hello this is Puzzle 2. The solution is Hksk");

    }

    public void Puzzle3(){
        //TODO: this is the code for puzzle3
        System.out.println("Hello this is Puzzle 3. The solution is 17pl");
    }

    public boolean checkIfSolved(){
        return solved;
    }

}
