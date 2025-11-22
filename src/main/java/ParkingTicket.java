import java.util.Date;

public class ParkingTicket {
    String ticketId;
    Vehicle vehicle;
    String parkingSpotId;
    ParkingSpotType parkingSpotType;
    private long entryTime;

    public ParkingTicket(String ticketId, Vehicle vehicle, String parkingSpotId, ParkingSpotType parkingSpotType) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        this.entryTime = System.currentTimeMillis();
    }


    public String getTicketId() {
        return ticketId;
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

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
