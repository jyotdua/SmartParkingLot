public class ParkingSpot {
    private Vehicle vehicle;
    private String parkingSpotId;
    private ParkingSpotType parkingSpotType;
    private Boolean isEmpty;


    ParkingSpot(String parkingSpotId, ParkingSpotType parkingSpotType) {
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public void parkVehicle(Vehicle vehicle){
        this.isEmpty = false;
        this.vehicle = vehicle;
    }

    public void unParkVehicle(){
        this.isEmpty = true;
        this.vehicle = null;
    }

    public boolean isFree() {
        return isEmpty;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        if(isEmpty){
            return switch (vehicle.getVehicleType()) {
                case VehicleType.CAR -> parkingSpotType == ParkingSpotType.LARGE || parkingSpotType == ParkingSpotType.MEDIUM;
                case VehicleType.BUS, VehicleType.TRUCK ->  parkingSpotType == ParkingSpotType.LARGE;
            };
        }
        return false;
    }
}
