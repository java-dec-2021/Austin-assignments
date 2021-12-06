import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava{

    // getTenRolls
    public void getTenRolls(){
        Random randMachine = new Random();
        ArrayList<Integer> rolls = new ArrayList<Integer>();

        for(int i=1; i<11; i++){
            int randomNumber = randMachine.nextInt(20);
            rolls.add(randomNumber);
        }
        System.out.println(rolls);
    }

    // getRandomLetter
    public String getRandomLetter(){
        Random word = new Random();

        String[] array={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        int randomLetters = word.nextInt(26);
        return(array[randomLetters]);
    }

    // generatePassword
    public String generatePassword(){
        String password = "";
        for(int i=0; i<8; i++){
            password = password + getRandomLetter();
        }
        return password;
    }

    // getNewPasswordSet
    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> newPassword = new ArrayList<String>();
        for(int i=0; i<length; i++){
            newPassword.add(generatePassword());
        }
        return newPassword;
    }

    // SENSEI OPTIONAL - if I have time after the fact.
}