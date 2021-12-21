public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
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
        System.out.println("IPhone version: " + this.getVersionNumber());
        System.out.println("IPhone battery: " + this.getBatteryPercentage());
        System.out.println("IPhone carrier: " + this.getCarrier());
        System.out.println("IPhone ring tone: " + this.getRingTone());
    }
}