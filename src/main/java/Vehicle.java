public class Vehicle {
    String vehicleId;
    String registrationNumber;
    VehicleType vehicleType;

    public Vehicle(String vehicleId, String registrationNumber, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
