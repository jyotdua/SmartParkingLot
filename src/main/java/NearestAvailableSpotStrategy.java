public class NearestAvailableSpotStrategy implements ParkingStrategy{
    public ParkingSpot findParkingSpot(Vehicle vehicle, ParkingLot parkingLot) {
        for(ParkingFloor floor : parkingLot.getParkingFloors()){
            if(!floor.isFloorFunctional())
                continue;

            ParkingSpot parkingSpot = floor.getParkingSpot(vehicle);
            if(parkingSpot != null)
                return parkingSpot;
        }
        return null;
    }
}
