import java.util.UUID;

public class ParkingTicketGenerator {

    public ParkingTicket generateParkingTicket(ParkingSpot parkingSpot) {
        if(parkingSpot == null){
            throw new IllegalArgumentException("Parking Spot cannot be null");
        }
        return new ParkingTicket(generateParkingTicketId(), parkingSpot.getVehicle(), parkingSpot.getParkingSpotId(),
                parkingSpot.getParkingSpotType());
    }

    public String generateParkingTicketId(){
        return UUID.randomUUID().toString();
    }

}
