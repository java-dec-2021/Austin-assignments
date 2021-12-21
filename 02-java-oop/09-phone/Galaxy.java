public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return this.getRingTone();
    }

    @Override
    public String unlock() {
        return "Unlocking using facial recognition.";
    }

    @Override
    public void displayInfo() {
        System.out.println("Galaxy version: " + this.getVersionNumber());
        System.out.println("Galaxy battery: " + this.getBatteryPercentage());
        System.out.println("Galaxy carrier: " + this.getCarrier());
        System.out.println("Galaxy ring tone: " + this.getRingTone());
    }