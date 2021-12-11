public class Gorilla extends Mammal{

    public void throwSomething(){
        System.out.println("The gorilla has thrown something.");
        this.energyLevel -= 5;
    }

    public void eatBananas(){
        System.out.println("The gorilla ate some bananas.");
        this.energyLevel += 10;
    }

    public void climb(){
        System.out.println("The gorilla is climbing!");
        this.energyLevel -= 10;
    }
}