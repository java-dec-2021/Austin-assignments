public class TestPuzzle{
    public static void main(String[] args){
        PuzzleJava test = new PuzzleJava();
        
        test.getTenRolls();
        System.out.println(test.getRandomLetter());
        System.out.println(test.generatePassword());
        System.out.println(test.getNewPasswordSet(4));
    }
}