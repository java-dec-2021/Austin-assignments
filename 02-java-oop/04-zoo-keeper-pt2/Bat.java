public class Bat extends Mammal {
    int energyLevel = 300;

    public void fly(){
        System.out.println("The bat has taken off - whoosh!");
        this.energyLevel -= 50;
    }

    public void eatHumans(){
        System.out.println("AHH! The bat just ate someone!");
        this.energyLevel += 25;
    }

    public void attackTowns(){
        System.out.println("THE ENTIRE TOWN IS ON FIRE!!! RUN!!!!");
        this.energyLevel -= 100;
    }
}