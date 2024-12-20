import java.util.ArrayList;
import java.util.List;

public class Admin {
    private final List<Vehicle> vehicleFleet;
    private final String password;

    public Admin() {
        this.vehicleFleet = new ArrayList<>();
        this.password = "Ausss123";
        prepopulateFleet();
    }

    private void prepopulateFleet() {
        vehicleFleet.add(new Car("CAR001", "Toyota Camry", 50.0));
        vehicleFleet.add(new Car("CAR002", "Honda Accord", 55.0));
        vehicleFleet.add(new Car("CAR003", "Ford Mustang", 70.0));
        vehicleFleet.add(new Car("CAR004", "Chevrolet Malibu", 60.0));
        vehicleFleet.add(new Car("CAR005", "Nissan Altima", 52.0));

        vehicleFleet.add(new Motorcycle("MOTO001", "Yamaha YZF-R3", 30.0));
        vehicleFleet.add(new Motorcycle("MOTO002", "Kawasaki Ninja 400", 35.0));
        vehicleFleet.add(new Motorcycle("MOTO003", "Honda CBR500R", 32.0));
        vehicleFleet.add(new Motorcycle("MOTO004", "Suzuki GSX250R", 28.0));
        vehicleFleet.add(new Motorcycle("MOTO005", "Ducati Monster 797", 40.0));

        vehicleFleet.add(new Truck("TRUCK001", "Ford F-150", 80.0));
        vehicleFleet.add(new Truck("TRUCK002", "Chevrolet Silverado", 85.0));
        vehicleFleet.add(new Truck("TRUCK003", "Ram 1500", 90.0));
        vehicleFleet.add(new Truck("TRUCK004", "Toyota Tundra", 88.0));
        vehicleFleet.add(new Truck("TRUCK005", "Nissan Titan", 82.0));
    }

    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleFleet.add(vehicle);
        System.out.println(vehicle.getClass().getSimpleName() + " added to the fleet.");
    }

    public void displayFleet() {
        if (vehicleFleet.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
        } else {
            System.out.println("Vehicle Fleet:");
            for (Vehicle vehicle : vehicleFleet) {
                System.out.println(vehicle.getClass().getSimpleName() + " - ID: " + vehicle.getVehicleId() + ", Model: " + vehicle.getModel());
            }
        }
    }

    public void displayAvailableVehicles() {
        boolean hasAvailableVehicles = false;
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.isAvailable()) {
                System.out.println(vehicle.getClass().getSimpleName() + " - ID: " + vehicle.getVehicleId() + ", Model: " + vehicle.getModel() + ", Rate: $" + vehicle.getBaseRentalRate() + " per day");
                hasAvailableVehicles = true;
            }
        }
        if (!hasAvailableVehicles) {
            System.out.println("No available vehicles.");
        }
    }

    public Vehicle getVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }
}
