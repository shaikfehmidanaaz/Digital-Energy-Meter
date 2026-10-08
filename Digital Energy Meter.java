import java.util.Scanner;

public class DigitalEnergyMeter {

    private double voltage;
    private double current;
    private double powerFactor;
    private double operatingHours;

    public DigitalEnergyMeter(double voltage, double current,
                              double powerFactor, double operatingHours) {
        this.voltage = voltage;
        this.current = current;
        this.powerFactor = powerFactor;
        this.operatingHours = operatingHours;
    }

    // Calculate active power
    public double calculatePower() {
        return voltage * current * powerFactor;
    }

    // Calculate energy consumption
    public double calculateEnergy() {
        double powerWatts = calculatePower();

        // Convert watts to kilowatts
        double powerKW = powerWatts / 1000;

        return powerKW * operatingHours;
    }

    // Display meter readings
    public void displayReading() {
        double power = calculatePower();
        double energy = calculateEnergy();

        System.out.println("\n----- Digital Energy Meter -----");
        System.out.printf("Voltage          : %.2f V%n", voltage);
        System.out.printf("Current          : %.2f A%n", current);
        System.out.printf("Power Factor     : %.2f%n", powerFactor);
        System.out.printf("Operating Hours  : %.2f hours%n", operatingHours);
        System.out.printf("Power             : %.2f W%n", power);
        System.out.printf("Energy Consumed  : %.2f kWh%n", energy);

        if (energy <= 5) {
            System.out.println("Energy Status    : LOW CONSUMPTION");
        } else if (energy <= 20) {
            System.out.println("Energy Status    : NORMAL CONSUMPTION");
        } else {
            System.out.println("Energy Status    : HIGH CONSUMPTION");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== DIGITAL ENERGY METER =====");

        System.out.print("Enter Voltage (V): ");
        double voltage = scanner.nextDouble();

        System.out.print("Enter Current (A): ");
        double current = scanner.nextDouble();

        System.out.print("Enter Power Factor: ");
        double powerFactor = scanner.nextDouble();

        System.out.print("Enter Operating Hours: ");
        double operatingHours = scanner.nextDouble();

        DigitalEnergyMeter meter = new DigitalEnergyMeter(
                voltage,
                current,
                powerFactor,
                operatingHours
        );

        meter.displayReading();

        scanner.close();
    }
}
