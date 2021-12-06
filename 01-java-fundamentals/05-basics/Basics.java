import java.util.ArrayList;

public class Basics {

    // print 1-255
    public void print255() {
        for (int i=1; i<256; i++){
            System.out.println(i);
        }
    }

    // print odds between 1-255
    public void printOdds(){
        for (int i=1; i<256; i+=2){
            System.out.println(i);
        }
    }

    // Return Sum of 1-255
    public void sigma255(){
        int sum=0;
        for (int i=1; i<256; i++){
            sum = sum+i;
        }
        System.out.println(sum);
    }

    // Iterate through an array
    public void iterateArray(){
        int[] myArray = {4, 5, 8, 10, 457, 13};
        for (int i=0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }

    // Find max in array

    public void findMax(){
        ArrayList<Integer> thisArray = new ArrayList<Integer>();
        thisArray.add(10);
        thisArray.add(5);
        thisArray.add(657);
        thisArray.add(-33);
        thisArray.add(77);
        
        int max=0;
        for (int i=0; i<thisArray.size(); i++){
            if (thisArray.get(i) > max) {
                max = thisArray.get(i);
            }
        }
        System.out.println(max);
    }

    // Array with odds 1-255
    public void oddsTo255(){
        ArrayList<Integer> oddArray = new ArrayList<Integer>();
        for (int i=1; i<256; i++){
            if (i%2 == 1) {
                oddArray.add(i);
            }
        }
        System.out.println(oddArray);
    }
}