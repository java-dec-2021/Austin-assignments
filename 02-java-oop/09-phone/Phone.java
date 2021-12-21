public abstract class Phone {

    // attributes
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;

    
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }

    // abstract method. This method will be implemented by the subclasses
    public abstract void displayInfo();

    // setters
    public void setVersionNumber(String vN){
        this.versionNumber = vN;
    }

    public void setBatteryPercentage(int bP){
        this.batteryPercentage = bP;
    }

    public void setCarrier(String c){
        this.carrier = c;
    }

    public void setRingTone(String rT){
        this.ringTone = rT;
    }

    // getters
    public String getVersionNumber(){
        return this.versionNumber;
    }

    public int getBatteryPercentage(){
        return this.batteryPercentage;
    }

    public String getCarrier(){
        return this.carrier;
    }

    public String getRingTone(){
        return this.ringTone;
    }

}

